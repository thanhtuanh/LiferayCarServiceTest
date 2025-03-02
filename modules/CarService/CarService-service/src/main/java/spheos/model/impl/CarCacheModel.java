/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package spheos.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import spheos.model.Car;

/**
 * The cache model class for representing Car in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class CarCacheModel implements CacheModel<Car>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CarCacheModel)) {
			return false;
		}

		CarCacheModel carCacheModel = (CarCacheModel)object;

		if (carId == carCacheModel.carId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, carId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{carId=");
		sb.append(carId);
		sb.append(", brand=");
		sb.append(brand);
		sb.append(", modell=");
		sb.append(modell);
		sb.append(", year=");
		sb.append(year);
		sb.append(", color=");
		sb.append(color);
		sb.append(", price=");
		sb.append(price);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Car toEntityModel() {
		CarImpl carImpl = new CarImpl();

		carImpl.setCarId(carId);

		if (brand == null) {
			carImpl.setBrand("");
		}
		else {
			carImpl.setBrand(brand);
		}

		if (modell == null) {
			carImpl.setModell("");
		}
		else {
			carImpl.setModell(modell);
		}

		carImpl.setYear(year);

		if (color == null) {
			carImpl.setColor("");
		}
		else {
			carImpl.setColor(color);
		}

		carImpl.setPrice(price);

		carImpl.resetOriginalValues();

		return carImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		carId = objectInput.readLong();
		brand = objectInput.readUTF();
		modell = objectInput.readUTF();

		year = objectInput.readInt();
		color = objectInput.readUTF();

		price = objectInput.readDouble();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(carId);

		if (brand == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(brand);
		}

		if (modell == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(modell);
		}

		objectOutput.writeInt(year);

		if (color == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(color);
		}

		objectOutput.writeDouble(price);
	}

	public long carId;
	public String brand;
	public String modell;
	public int year;
	public String color;
	public double price;

}