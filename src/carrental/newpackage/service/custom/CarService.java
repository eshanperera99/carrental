package carrental.newpackage.service.custom;

import carrental.newpackage.dto.CarDTO;
import carrental.newpackage.dto.CustomerDTO;
import carrental.newpackage.service.SuperService;
import java.util.ArrayList;

public interface CarService extends SuperService {

    public String addcar(CarDTO cardto);

    String deletecar(String id) throws Exceptions;

    String updatecar(CarDTO cardto) throws Exceptions;

    CarDTO getcar(String id) throws Exceptions;

    ArrayList<CarDTO> getAllcar() throws Exceptions;

    public static class Exceptions extends Exception {

        public Exceptions() {
        }
    }

}
