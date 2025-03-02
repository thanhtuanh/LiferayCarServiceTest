/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package spheos.service.persistence.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.test.AssertUtils;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.util.IntegerWrapper;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PersistenceTestRule;
import com.liferay.portal.test.rule.TransactionalTestRule;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import spheos.exception.NoSuchCarException;

import spheos.model.Car;

import spheos.service.CarLocalServiceUtil;
import spheos.service.persistence.CarPersistence;
import spheos.service.persistence.CarUtil;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class CarPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(Propagation.REQUIRED, "spheos.service"));

	@Before
	public void setUp() {
		_persistence = CarUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Car> iterator = _cars.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Car car = _persistence.create(pk);

		Assert.assertNotNull(car);

		Assert.assertEquals(car.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Car newCar = addCar();

		_persistence.remove(newCar);

		Car existingCar = _persistence.fetchByPrimaryKey(
			newCar.getPrimaryKey());

		Assert.assertNull(existingCar);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addCar();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Car newCar = _persistence.create(pk);

		newCar.setBrand(RandomTestUtil.randomString());

		newCar.setModell(RandomTestUtil.randomString());

		newCar.setYear(RandomTestUtil.nextInt());

		newCar.setColor(RandomTestUtil.randomString());

		newCar.setPrice(RandomTestUtil.nextDouble());

		_cars.add(_persistence.update(newCar));

		Car existingCar = _persistence.findByPrimaryKey(newCar.getPrimaryKey());

		Assert.assertEquals(existingCar.getCarId(), newCar.getCarId());
		Assert.assertEquals(existingCar.getBrand(), newCar.getBrand());
		Assert.assertEquals(existingCar.getModell(), newCar.getModell());
		Assert.assertEquals(existingCar.getYear(), newCar.getYear());
		Assert.assertEquals(existingCar.getColor(), newCar.getColor());
		AssertUtils.assertEquals(existingCar.getPrice(), newCar.getPrice());
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		Car newCar = addCar();

		Car existingCar = _persistence.findByPrimaryKey(newCar.getPrimaryKey());

		Assert.assertEquals(existingCar, newCar);
	}

	@Test(expected = NoSuchCarException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<Car> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"CAR_Car", "carId", true, "brand", true, "modell", true, "year",
			true, "color", true, "price", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Car newCar = addCar();

		Car existingCar = _persistence.fetchByPrimaryKey(
			newCar.getPrimaryKey());

		Assert.assertEquals(existingCar, newCar);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Car missingCar = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingCar);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		Car newCar1 = addCar();
		Car newCar2 = addCar();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCar1.getPrimaryKey());
		primaryKeys.add(newCar2.getPrimaryKey());

		Map<Serializable, Car> cars = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(2, cars.size());
		Assert.assertEquals(newCar1, cars.get(newCar1.getPrimaryKey()));
		Assert.assertEquals(newCar2, cars.get(newCar2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Car> cars = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(cars.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		Car newCar = addCar();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCar.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Car> cars = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, cars.size());
		Assert.assertEquals(newCar, cars.get(newCar.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Car> cars = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(cars.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		Car newCar = addCar();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCar.getPrimaryKey());

		Map<Serializable, Car> cars = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, cars.size());
		Assert.assertEquals(newCar, cars.get(newCar.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			CarLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<Car>() {

				@Override
				public void performAction(Car car) {
					Assert.assertNotNull(car);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		Car newCar = addCar();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Car.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("carId", newCar.getCarId()));

		List<Car> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Car existingCar = result.get(0);

		Assert.assertEquals(existingCar, newCar);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Car.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("carId", RandomTestUtil.nextLong()));

		List<Car> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		Car newCar = addCar();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Car.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("carId"));

		Object newCarId = newCar.getCarId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in("carId", new Object[] {newCarId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingCarId = result.get(0);

		Assert.assertEquals(existingCarId, newCarId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Car.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("carId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"carId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected Car addCar() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Car car = _persistence.create(pk);

		car.setBrand(RandomTestUtil.randomString());

		car.setModell(RandomTestUtil.randomString());

		car.setYear(RandomTestUtil.nextInt());

		car.setColor(RandomTestUtil.randomString());

		car.setPrice(RandomTestUtil.nextDouble());

		_cars.add(_persistence.update(car));

		return car;
	}

	private List<Car> _cars = new ArrayList<Car>();
	private CarPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}