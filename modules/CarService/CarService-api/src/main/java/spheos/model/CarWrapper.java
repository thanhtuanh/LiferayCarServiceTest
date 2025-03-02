/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package spheos.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Car}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Car
 * @generated
 */
public class CarWrapper
	extends BaseModelWrapper<Car> implements Car, ModelWrapper<Car> {

	public CarWrapper(Car car) {
		super(car);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("carId", getCarId());
		attributes.put("brand", getBrand());
		attributes.put("modell", getModell());
		attributes.put("year", getYear());
		attributes.put("color", getColor());
		attributes.put("price", getPrice());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long carId = (Long)attributes.get("carId");

		if (carId != null) {
			setCarId(carId);
		}

		String brand = (String)attributes.get("brand");

		if (brand != null) {
			setBrand(brand);
		}

		String modell = (String)attributes.get("modell");

		if (modell != null) {
			setModell(modell);
		}

		Integer year = (Integer)attributes.get("year");

		if (year != null) {
			setYear(year);
		}

		String color = (String)attributes.get("color");

		if (color != null) {
			setColor(color);
		}

		Double price = (Double)attributes.get("price");

		if (price != null) {
			setPrice(price);
		}
	}

	@Override
	public Car cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the brand of this car.
	 *
	 * @return the brand of this car
	 */
	@Override
	public String getBrand() {
		return model.getBrand();
	}

	/**
	 * Returns the car ID of this car.
	 *
	 * @return the car ID of this car
	 */
	@Override
	public long getCarId() {
		return model.getCarId();
	}

	/**
	 * Returns the color of this car.
	 *
	 * @return the color of this car
	 */
	@Override
	public String getColor() {
		return model.getColor();
	}

	/**
	 * Returns the modell of this car.
	 *
	 * @return the modell of this car
	 */
	@Override
	public String getModell() {
		return model.getModell();
	}

	/**
	 * Returns the price of this car.
	 *
	 * @return the price of this car
	 */
	@Override
	public double getPrice() {
		return model.getPrice();
	}

	/**
	 * Returns the primary key of this car.
	 *
	 * @return the primary key of this car
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the year of this car.
	 *
	 * @return the year of this car
	 */
	@Override
	public int getYear() {
		return model.getYear();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the brand of this car.
	 *
	 * @param brand the brand of this car
	 */
	@Override
	public void setBrand(String brand) {
		model.setBrand(brand);
	}

	/**
	 * Sets the car ID of this car.
	 *
	 * @param carId the car ID of this car
	 */
	@Override
	public void setCarId(long carId) {
		model.setCarId(carId);
	}

	/**
	 * Sets the color of this car.
	 *
	 * @param color the color of this car
	 */
	@Override
	public void setColor(String color) {
		model.setColor(color);
	}

	/**
	 * Sets the modell of this car.
	 *
	 * @param modell the modell of this car
	 */
	@Override
	public void setModell(String modell) {
		model.setModell(modell);
	}

	/**
	 * Sets the price of this car.
	 *
	 * @param price the price of this car
	 */
	@Override
	public void setPrice(double price) {
		model.setPrice(price);
	}

	/**
	 * Sets the primary key of this car.
	 *
	 * @param primaryKey the primary key of this car
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the year of this car.
	 *
	 * @param year the year of this car
	 */
	@Override
	public void setYear(int year) {
		model.setYear(year);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected CarWrapper wrap(Car car) {
		return new CarWrapper(car);
	}

}