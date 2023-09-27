/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carrental.newpackage.controller;

import carrental.newpackage.dto.CarDTO;
import carrental.newpackage.service.ServiceFactory;
import java.util.ArrayList;
import carrental.newpackage.service.custom.CarService;
import carrental.newpackage.service.custom.CustomerService;

/**
 *
 * @author eshan
 */
public class CarController {

    CarService carService = (CarService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.CAR);

    public String addcar(CarDTO cardto) throws CarService.Exceptions {
        return carService.addcar(cardto);
    }

    public ArrayList<CarDTO> getAllcar() throws CustomerService.CustomerServiceException, CarService.Exceptions {
        return carService.getAllcar();
    }

    public String updatecar(CarDTO cardto) throws CustomerService.CustomerServiceException, CarService.Exceptions {
        return carService.updatecar(cardto);
    }

    public String deletecar(String id) throws CustomerService.CustomerServiceException, CarService.Exceptions {
        return carService.deletecar(id);
    }

    public CarDTO getcar(String id) throws CustomerService.CustomerServiceException, CarService.Exceptions {
        return carService.getcar(id);
    }

}
