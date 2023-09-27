package carrental.newpackage.service.custom;

import carrental.newpackage.dto.CustomerDTO;
import carrental.newpackage.dto.CarDTO;
import carrental.newpackage.dto.RentalDTO;
import carrental.newpackage.service.SuperService;
import java.util.ArrayList;

public interface RentalService extends SuperService {

    String rentCar(CustomerDTO customerDTO, CarDTO carDTO, String startDate, String endDate, double cost);
    String rentCar(RentalDTO rentalDTO);

    String returnCar(String id);

    ArrayList<RentalDTO> getAllRentals();

    RentalDTO getRentalDetails(String rentalId);

    boolean isCarFree(String id);

    boolean isCustomerFree(String id);

    double calculateRentalCost(String startDate, String endDate, double dailyRate);

    public static class Exceptions extends Exception {

        public Exceptions() {
        }
    }
}
