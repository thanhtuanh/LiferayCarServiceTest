/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package spheos.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

import spheos.exception.NoSuchCarException;

import spheos.model.Car;

/**
 * The persistence interface for the car service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CarUtil
 * @generated
 */
@ProviderType
public interface CarPersistence extends BasePersistence<Car> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CarUtil} to access the car persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the car in the entity cache if it is enabled.
	 *
	 * @param car the car
	 */
	public void cacheResult(Car car);

	/**
	 * Caches the cars in the entity cache if it is enabled.
	 *
	 * @param cars the cars
	 */
	public void cacheResult(java.util.List<Car> cars);

	/**
	 * Creates a new car with the primary key. Does not add the car to the database.
	 *
	 * @param carId the primary key for the new car
	 * @return the new car
	 */
	public Car create(long carId);

	/**
	 * Removes the car with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param carId the primary key of the car
	 * @return the car that was removed
	 * @throws NoSuchCarException if a car with the primary key could not be found
	 */
	public Car remove(long carId) throws NoSuchCarException;

	public Car updateImpl(Car car);

	/**
	 * Returns the car with the primary key or throws a <code>NoSuchCarException</code> if it could not be found.
	 *
	 * @param carId the primary key of the car
	 * @return the car
	 * @throws NoSuchCarException if a car with the primary key could not be found
	 */
	public Car findByPrimaryKey(long carId) throws NoSuchCarException;

	/**
	 * Returns the car with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param carId the primary key of the car
	 * @return the car, or <code>null</code> if a car with the primary key could not be found
	 */
	public Car fetchByPrimaryKey(long carId);

	/**
	 * Returns all the cars.
	 *
	 * @return the cars
	 */
	public java.util.List<Car> findAll();

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
	public java.util.List<Car> findAll(int start, int end);

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
	public java.util.List<Car> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Car>
			orderByComparator);

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
	public java.util.List<Car> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Car> orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the cars from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of cars.
	 *
	 * @return the number of cars
	 */
	public int countAll();

}