/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package spheos.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link CarLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see CarLocalService
 * @generated
 */
public class CarLocalServiceWrapper
	implements CarLocalService, ServiceWrapper<CarLocalService> {

	public CarLocalServiceWrapper() {
		this(null);
	}

	public CarLocalServiceWrapper(CarLocalService carLocalService) {
		_carLocalService = carLocalService;
	}

	/**
	 * Adds the car to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CarLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param car the car
	 * @return the car that was added
	 */
	@Override
	public spheos.model.Car addCar(spheos.model.Car car) {
		return _carLocalService.addCar(car);
	}

	@Override
	public spheos.model.Car addCar(
		String brand, String modell, int year, String color, double price,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return _carLocalService.addCar(
			brand, modell, year, color, price, serviceContext);
	}

	/**
	 * Creates a new car with the primary key. Does not add the car to the database.
	 *
	 * @param carId the primary key for the new car
	 * @return the new car
	 */
	@Override
	public spheos.model.Car createCar(long carId) {
		return _carLocalService.createCar(carId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _carLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the car from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CarLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param car the car
	 * @return the car that was removed
	 */
	@Override
	public spheos.model.Car deleteCar(spheos.model.Car car) {
		return _carLocalService.deleteCar(car);
	}

	/**
	 * Deletes the car with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CarLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param carId the primary key of the car
	 * @return the car that was removed
	 * @throws PortalException if a car with the primary key could not be found
	 */
	@Override
	public spheos.model.Car deleteCar(long carId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _carLocalService.deleteCar(carId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _carLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _carLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _carLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _carLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _carLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>spheos.model.impl.CarModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _carLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>spheos.model.impl.CarModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _carLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _carLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _carLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public spheos.model.Car fetchCar(long carId) {
		return _carLocalService.fetchCar(carId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _carLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<spheos.model.Car> getAllCars() {
		return _carLocalService.getAllCars();
	}

	/**
	 * Returns the car with the primary key.
	 *
	 * @param carId the primary key of the car
	 * @return the car
	 * @throws PortalException if a car with the primary key could not be found
	 */
	@Override
	public spheos.model.Car getCar(long carId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _carLocalService.getCar(carId);
	}

	/**
	 * Returns a range of all the cars.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>spheos.model.impl.CarModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cars
	 * @param end the upper bound of the range of cars (not inclusive)
	 * @return the range of cars
	 */
	@Override
	public java.util.List<spheos.model.Car> getCars(int start, int end) {
		return _carLocalService.getCars(start, end);
	}

	/**
	 * Returns the number of cars.
	 *
	 * @return the number of cars
	 */
	@Override
	public int getCarsCount() {
		return _carLocalService.getCarsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _carLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _carLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _carLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the car in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CarLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param car the car
	 * @return the car that was updated
	 */
	@Override
	public spheos.model.Car updateCar(spheos.model.Car car) {
		return _carLocalService.updateCar(car);
	}

	@Override
	public spheos.model.Car updateCar(
			long carId, String brand, String modell, int year, String color,
			double price)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _carLocalService.updateCar(
			carId, brand, modell, year, color, price);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _carLocalService.getBasePersistence();
	}

	@Override
	public CarLocalService getWrappedService() {
		return _carLocalService;
	}

	@Override
	public void setWrappedService(CarLocalService carLocalService) {
		_carLocalService = carLocalService;
	}

	private CarLocalService _carLocalService;

}