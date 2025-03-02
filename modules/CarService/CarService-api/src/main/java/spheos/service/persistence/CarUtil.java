/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package spheos.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import spheos.model.Car;

/**
 * The persistence utility for the car service. This utility wraps <code>spheos.service.persistence.impl.CarPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CarPersistence
 * @generated
 */
public class CarUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Car car) {
		getPersistence().clearCache(car);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, Car> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Car> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Car> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Car> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Car> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Car update(Car car) {
		return getPersistence().update(car);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Car update(Car car, ServiceContext serviceContext) {
		return getPersistence().update(car, serviceContext);
	}

	/**
	 * Caches the car in the entity cache if it is enabled.
	 *
	 * @param car the car
	 */
	public static void cacheResult(Car car) {
		getPersistence().cacheResult(car);
	}

	/**
	 * Caches the cars in the entity cache if it is enabled.
	 *
	 * @param cars the cars
	 */
	public static void cacheResult(List<Car> cars) {
		getPersistence().cacheResult(cars);
	}

	/**
	 * Creates a new car with the primary key. Does not add the car to the database.
	 *
	 * @param carId the primary key for the new car
	 * @return the new car
	 */
	public static Car create(long carId) {
		return getPersistence().create(carId);
	}

	/**
	 * Removes the car with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param carId the primary key of the car
	 * @return the car that was removed
	 * @throws NoSuchCarException if a car with the primary key could not be found
	 */
	public static Car remove(long carId)
		throws spheos.exception.NoSuchCarException {

		return getPersistence().remove(carId);
	}

	public static Car updateImpl(Car car) {
		return getPersistence().updateImpl(car);
	}

	/**
	 * Returns the car with the primary key or throws a <code>NoSuchCarException</code> if it could not be found.
	 *
	 * @param carId the primary key of the car
	 * @return the car
	 * @throws NoSuchCarException if a car with the primary key could not be found
	 */
	public static Car findByPrimaryKey(long carId)
		throws spheos.exception.NoSuchCarException {

		return getPersistence().findByPrimaryKey(carId);
	}

	/**
	 * Returns the car with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param carId the primary key of the car
	 * @return the car, or <code>null</code> if a car with the primary key could not be found
	 */
	public static Car fetchByPrimaryKey(long carId) {
		return getPersistence().fetchByPrimaryKey(carId);
	}

	/**
	 * Returns all the cars.
	 *
	 * @return the cars
	 */
	public static List<Car> findAll() {
		return getPersistence().findAll();
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
	public static List<Car> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<Car> findAll(
		int start, int end, OrderByComparator<Car> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
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
	public static List<Car> findAll(
		int start, int end, OrderByComparator<Car> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the cars from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of cars.
	 *
	 * @return the number of cars
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static CarPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(CarPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile CarPersistence _persistence;

}