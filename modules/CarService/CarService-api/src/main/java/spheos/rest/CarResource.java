package spheos.rest;

import com.liferay.portal.kernel.service.ServiceContext;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;
import spheos.model.Car;
import spheos.service.CarLocalService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Component(
        service = Object.class,
        property = {
                "osgi.jaxrs.application.base=/cars",
                "osgi.jaxrs.name=CarRest"
        },
        scope = ServiceScope.PROTOTYPE
)
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CarResource {

    @Reference
    private CarLocalService carLocalService;

    @POST
    public Response addCar(Car car) {
        ServiceContext serviceContext = new ServiceContext();
        Car newCar = carLocalService.addCar(car.getBrand(), car.getModell(), car.getYear(), car.getColor(), car.getPrice(), serviceContext);
        return Response.ok(newCar).build();
    }

    @GET
    public List<Car> getAllCars() {
        return carLocalService.getAllCars();
    }

    @GET
    @Path("/{id}")
    public Response getCar(@PathParam("id") long id) {
        try {
            return Response.ok(carLocalService.getCar(id)).build();
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @PUT
    @Path("/{id}")
    public Response updateCar(@PathParam("id") long id, Car car) {
        try {
            Car updatedCar = carLocalService.updateCar(id, car.getBrand(), car.getModell(), car.getYear(), car.getColor(), car.getPrice());
            return Response.ok(updatedCar).build();
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deleteCar(@PathParam("id") long id) {
        try {
            carLocalService.deleteCar(id);
            return Response.noContent().build();
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}