package spheos.service.impl;

import com.liferay.portal.aop.AopService;
import org.osgi.service.component.annotations.Component;
import spheos.model.Car;
import spheos.service.base.CarLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;

import java.util.List;

@Component(
		property = "model.class.name=spheos.model.Car",
		service = AopService.class
)
public class CarLocalServiceImpl extends CarLocalServiceBaseImpl {

	public Car addCar(String brand, String modell, int year, String color, double price, ServiceContext serviceContext) {
		long carId = counterLocalService.increment(Car.class.getName());
		Car car = carPersistence.create(carId);

		car.setBrand(brand);
		car.setModell(modell);
		car.setYear(year);
		car.setColor(color);
		car.setPrice(price);

		carPersistence.update(car);
		return car;
	}

	public Car getCar(long carId) throws PortalException {
		return carPersistence.findByPrimaryKey(carId);
	}

	public List<Car> getAllCars() {
		return carPersistence.findAll();
	}

	public Car updateCar(long carId, String brand, String modell, int year, String color, double price) throws PortalException {
		Car car = getCar(carId);
		car.setBrand(brand);
		car.setModell(modell);
		car.setYear(year);
		car.setColor(color);
		car.setPrice(price);
		return carPersistence.update(car);
	}

	public Car deleteCar(long carId) throws PortalException {
		Car car = getCar(carId); // Hole das Auto, bevor es gelöscht wird
		carPersistence.remove(car); // Lösche das Auto aus der Datenbank
		return car; // Rückgabe des gelöschten Autos
	}

}
