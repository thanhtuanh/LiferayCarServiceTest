/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package spheos.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

import spheos.exception.NoSuchCarException;

import spheos.model.Car;
import spheos.model.CarTable;
import spheos.model.impl.CarImpl;
import spheos.model.impl.CarModelImpl;

import spheos.service.persistence.CarPersistence;
import spheos.service.persistence.CarUtil;
import spheos.service.persistence.impl.constants.CARPersistenceConstants;

/**
 * The persistence implementation for the car service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = CarPersistence.class)
public class CarPersistenceImpl
	extends BasePersistenceImpl<Car> implements CarPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>CarUtil</code> to access the car persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		CarImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public CarPersistenceImpl() {
		setModelClass(Car.class);

		setModelImplClass(CarImpl.class);
		setModelPKClass(long.class);

		setTable(CarTable.INSTANCE);
	}

	/**
	 * Caches the car in the entity cache if it is enabled.
	 *
	 * @param car the car
	 */
	@Override
	public void cacheResult(Car car) {
		entityCache.putResult(CarImpl.class, car.getPrimaryKey(), car);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the cars in the entity cache if it is enabled.
	 *
	 * @param cars the cars
	 */
	@Override
	public void cacheResult(List<Car> cars) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (cars.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Car car : cars) {
			if (entityCache.getResult(CarImpl.class, car.getPrimaryKey()) ==
					null) {

				cacheResult(car);
			}
		}
	}

	/**
	 * Clears the cache for all cars.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CarImpl.class);

		finderCache.clearCache(CarImpl.class);
	}

	/**
	 * Clears the cache for the car.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Car car) {
		entityCache.removeResult(CarImpl.class, car);
	}

	@Override
	public void clearCache(List<Car> cars) {
		for (Car car : cars) {
			entityCache.removeResult(CarImpl.class, car);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(CarImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(CarImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new car with the primary key. Does not add the car to the database.
	 *
	 * @param carId the primary key for the new car
	 * @return the new car
	 */
	@Override
	public Car create(long carId) {
		Car car = new CarImpl();

		car.setNew(true);
		car.setPrimaryKey(carId);

		return car;
	}

	/**
	 * Removes the car with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param carId the primary key of the car
	 * @return the car that was removed
	 * @throws NoSuchCarException if a car with the primary key could not be found
	 */
	@Override
	public Car remove(long carId) throws NoSuchCarException {
		return remove((Serializable)carId);
	}

	/**
	 * Removes the car with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the car
	 * @return the car that was removed
	 * @throws NoSuchCarException if a car with the primary key could not be found
	 */
	@Override
	public Car remove(Serializable primaryKey) throws NoSuchCarException {
		Session session = null;

		try {
			session = openSession();

			Car car = (Car)session.get(CarImpl.class, primaryKey);

			if (car == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCarException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(car);
		}
		catch (NoSuchCarException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Car removeImpl(Car car) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(car)) {
				car = (Car)session.get(CarImpl.class, car.getPrimaryKeyObj());
			}

			if (car != null) {
				session.delete(car);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (car != null) {
			clearCache(car);
		}

		return car;
	}

	@Override
	public Car updateImpl(Car car) {
		boolean isNew = car.isNew();

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(car);
			}
			else {
				car = (Car)session.merge(car);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(CarImpl.class, car, false, true);

		if (isNew) {
			car.setNew(false);
		}

		car.resetOriginalValues();

		return car;
	}

	/**
	 * Returns the car with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the car
	 * @return the car
	 * @throws NoSuchCarException if a car with the primary key could not be found
	 */
	@Override
	public Car findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCarException {

		Car car = fetchByPrimaryKey(primaryKey);

		if (car == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCarException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return car;
	}

	/**
	 * Returns the car with the primary key or throws a <code>NoSuchCarException</code> if it could not be found.
	 *
	 * @param carId the primary key of the car
	 * @return the car
	 * @throws NoSuchCarException if a car with the primary key could not be found
	 */
	@Override
	public Car findByPrimaryKey(long carId) throws NoSuchCarException {
		return findByPrimaryKey((Serializable)carId);
	}

	/**
	 * Returns the car with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param carId the primary key of the car
	 * @return the car, or <code>null</code> if a car with the primary key could not be found
	 */
	@Override
	public Car fetchByPrimaryKey(long carId) {
		return fetchByPrimaryKey((Serializable)carId);
	}

	/**
	 * Returns all the cars.
	 *
	 * @return the cars
	 */
	@Override
	public List<Car> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cars.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CarModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cars
	 * @param end the upper bound of the range of cars (not inclusive)
	 * @return the range of cars
	 */
	@Override
	public List<Car> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the cars.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CarModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cars
	 * @param end the upper bound of the range of cars (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of cars
	 */
	@Override
	public List<Car> findAll(
		int start, int end, OrderByComparator<Car> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the cars.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CarModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cars
	 * @param end the upper bound of the range of cars (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of cars
	 */
	@Override
	public List<Car> findAll(
		int start, int end, OrderByComparator<Car> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<Car> list = null;

		if (useFinderCache) {
			list = (List<Car>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_CAR);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_CAR;

				sql = sql.concat(CarModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Car>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the cars from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Car car : findAll()) {
			remove(car);
		}
	}

	/**
	 * Returns the number of cars.
	 *
	 * @return the number of cars
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_CAR);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "carId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_CAR;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return CarModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the car persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		CarUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		CarUtil.setPersistence(null);

		entityCache.removeCache(CarImpl.class.getName());
	}

	@Override
	@Reference(
		target = CARPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = CARPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = CARPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_CAR = "SELECT car FROM Car car";

	private static final String _SQL_COUNT_CAR =
		"SELECT COUNT(car) FROM Car car";

	private static final String _ORDER_BY_ENTITY_ALIAS = "car.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Car exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		CarPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}