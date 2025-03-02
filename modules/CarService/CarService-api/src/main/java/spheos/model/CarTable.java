/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package spheos.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;CAR_Car&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Car
 * @generated
 */
public class CarTable extends BaseTable<CarTable> {

	public static final CarTable INSTANCE = new CarTable();

	public final Column<CarTable, Long> carId = createColumn(
		"carId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<CarTable, String> brand = createColumn(
		"brand", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CarTable, String> modell = createColumn(
		"modell", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CarTable, Integer> year = createColumn(
		"year", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<CarTable, String> color = createColumn(
		"color", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CarTable, Double> price = createColumn(
		"price", Double.class, Types.DOUBLE, Column.FLAG_DEFAULT);

	private CarTable() {
		super("CAR_Car", CarTable::new);
	}

}