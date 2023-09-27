package carrental.newpackage.controller;

import carrental.newpackage.dto.CustomerDTO;
import carrental.newpackage.dto.CarDTO;
import carrental.newpackage.dto.RentalDTO;
import carrental.newpackage.service.ServiceFactory;
import carrental.newpackage.service.custom.CustomerService;
import carrental.newpackage.service.custom.RentalService;

import java.util.ArrayList;

public class RentalController {

    RentalService rentalService = (RentalService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.RENTAL);
    
public String rentCar(RentalDTO rentalDTO) {
        // Implement the rental logic here and call the corresponding service method
        // You can also handle exceptions and error messages as needed
        return rentalService.rentCar(rentalDTO);
    }
    public String rentCar(CustomerDTO customerDTO, CarDTO carDTO, String startDate, String endDate, double cost) {
        // Implement the rental logic here and call the corresponding service method
        // You can also handle exceptions and error messages as needed
        return rentalService.rentCar(customerDTO, carDTO, startDate, endDate, cost);
    }

    public String returnCar(String id) {
        // Implement the return car logic here and call the corresponding service method
        // You can also handle exceptions and error messages as needed
        return rentalService.returnCar(id);
    }

    public ArrayList<RentalDTO> getAllRentals() {
        // Implement getting all rentals and call the corresponding service method
        // You can also handle exceptions and error messages as needed
        return rentalService.getAllRentals();
    }

    public RentalDTO getRentalDetails(String rentalId) {
        // Implement getting rental details by ID and call the corresponding service method
        // You can also handle exceptions and error messages as needed
        return rentalService.getRentalDetails(rentalId);
    }

    public double calculateRentalCost(String startDate, String endDate, double dailyRate) {
        // Implement rental cost calculation and call the corresponding service method
        // You can also handle exceptions and error messages as needed
        return rentalService.calculateRentalCost(startDate, endDate, dailyRate);
    }
    
    public boolean isCarFree(String id){
           return rentalService.isCarFree(id);
    }
     public boolean isCustomerFree(String id){
           return rentalService.isCustomerFree(id);
    }
}
