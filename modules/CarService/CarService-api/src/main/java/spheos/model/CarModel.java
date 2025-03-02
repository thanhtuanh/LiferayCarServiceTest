/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package spheos.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the Car service. Represents a row in the &quot;CAR_Car&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>spheos.model.impl.CarModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>spheos.model.impl.CarImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Car
 * @generated
 */
@ProviderType
public interface CarModel extends BaseModel<Car> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a car model instance should use the {@link Car} interface instead.
	 */

	/**
	 * Returns the primary key of this car.
	 *
	 * @return the primary key of this car
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this car.
	 *
	 * @param primaryKey the primary key of this car
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the car ID of this car.
	 *
	 * @return the car ID of this car
	 */
	public long getCarId();

	/**
	 * Sets the car ID of this car.
	 *
	 * @param carId the car ID of this car
	 */
	public void setCarId(long carId);

	/**
	 * Returns the brand of this car.
	 *
	 * @return the brand of this car
	 */
	@AutoEscape
	public String getBrand();

	/**
	 * Sets the brand of this car.
	 *
	 * @param brand the brand of this car
	 */
	public void setBrand(String brand);

	/**
	 * Returns the modell of this car.
	 *
	 * @return the modell of this car
	 */
	@AutoEscape
	public String getModell();

	/**
	 * Sets the modell of this car.
	 *
	 * @param modell the modell of this car
	 */
	public void setModell(String modell);

	/**
	 * Returns the year of this car.
	 *
	 * @return the year of this car
	 */
	public int getYear();

	/**
	 * Sets the year of this car.
	 *
	 * @param year the year of this car
	 */
	public void setYear(int year);

	/**
	 * Returns the color of this car.
	 *
	 * @return the color of this car
	 */
	@AutoEscape
	public String getColor();

	/**
	 * Sets the color of this car.
	 *
	 * @param color the color of this car
	 */
	public void setColor(String color);

	/**
	 * Returns the price of this car.
	 *
	 * @return the price of this car
	 */
	public double getPrice();

	/**
	 * Sets the price of this car.
	 *
	 * @param price the price of this car
	 */
	public void setPrice(double price);

	@Override
	public Car cloneWithOriginalValues();

	public default String toXmlString() {
		return null;
	}

}