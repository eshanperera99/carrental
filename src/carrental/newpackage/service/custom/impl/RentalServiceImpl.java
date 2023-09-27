package carrental.newpackage.service.custom.impl;

import carrental.newpackage.dao.DaoFactory;
import carrental.newpackage.dao.custom.RentalDAO;
import carrental.newpackage.dto.CarDTO;
import carrental.newpackage.dto.CustomerDTO;
import carrental.newpackage.dto.RentalDTO;
import carrental.newpackage.entity.CarEntity;
import carrental.newpackage.entity.CustomerEntity;
import carrental.newpackage.entity.RentalEntity;
import carrental.newpackage.service.custom.RentalService;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RentalServiceImpl implements RentalService {

    private final RentalDAO rentalDAO = (RentalDAO) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.RENTAL);

    @Override
    public String rentCar(CustomerDTO customerDTO, CarDTO carDTO, String startDate, String endDate, double cost) {
        RentalEntity rentalEntity = new RentalEntity(null,
                new CustomerEntity(),
                new CarEntity(),
                new Date(),
                new Date(),
                cost,
                1
        );

        try {
            if (rentalDAO.add(rentalEntity)) {
                return "Successfully Rented";
            } else {
                return "Fail to Rent";
            }
        } catch (Exception ex) {
            Logger.getLogger(RentalServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return "Error: " + ex.getMessage();
        }
    }


    @Override
    public ArrayList<RentalDTO> getAllRentals() {
        ArrayList<RentalDTO> rentalDTOs = new ArrayList<>();
        try {
            ArrayList<RentalEntity> rentalEntities = rentalDAO.getALL();
            for (RentalEntity rentalEntity : rentalEntities) {
                RentalDTO rentalDTO = new RentalDTO(
                        rentalEntity.getRentalId(),
                        new CustomerDTO(rentalEntity.getCustomer().getId(), rentalEntity.getCustomer().getFirstname(), rentalEntity.getCustomer().getLastname(), rentalEntity.getCustomer().getContactnumber(), rentalEntity.getCustomer().getAddress()), // You should obtain CustomerDTO and CarDTO instances here
                        new CarDTO(rentalEntity.getCar().getCarid(), rentalEntity.getCar().getCarnum(), rentalEntity.getCar().getBrand(), rentalEntity.getCar().getModel(), rentalEntity.getCar().getCartype(), rentalEntity.getCar().getDailyrate()), // based on rentalEntity's customer and car IDs
                        rentalEntity.getRentalStartDate().toString(),
                        rentalEntity.getRentalEndDate().toString(),
                        rentalEntity.getRentalCost(),
                        rentalEntity.getState()
                );
                rentalDTOs.add(rentalDTO);
            }
        } catch (Exception ex) {
            Logger.getLogger(RentalServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rentalDTOs;
    }

    @Override
    public RentalDTO getRentalDetails(String rentalId) {
        try {
            RentalEntity rentalEntity = rentalDAO.get(rentalId);
            if (rentalEntity != null) {
                RentalDTO rentalDTO = new RentalDTO(
                        rentalEntity.getRentalId(),
                        new CustomerDTO(rentalEntity.getCustomer().getId(), rentalEntity.getCustomer().getFirstname(), rentalEntity.getCustomer().getLastname(), rentalEntity.getCustomer().getContactnumber(), rentalEntity.getCustomer().getAddress()), // You should obtain CustomerDTO and CarDTO instances here
                        new CarDTO(rentalEntity.getCar().getCarid(), rentalEntity.getCar().getCarnum(), rentalEntity.getCar().getBrand(), rentalEntity.getCar().getModel(), rentalEntity.getCar().getCartype(), rentalEntity.getCar().getDailyrate()), // based on rentalEntity's customer and car IDs
                        rentalEntity.getRentalStartDate().toString(),
                        rentalEntity.getRentalEndDate().toString(),
                        rentalEntity.getRentalCost(),
                        rentalEntity.getState()
                );
                return rentalDTO;
            }
        } catch (Exception ex) {
            Logger.getLogger(RentalServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public double calculateRentalCost(String startDate, String endDate, double dailyRate) {
        // Implement rental cost calculation logic here and return the cost
        // You can use startDate, endDate, and dailyRate parameters to calculate the cost
        // You may want to calculate the number of days and multiply it by the daily rate
        // You can also handle exceptions and error messages as needed
        return 0.0; // Replace this with your actual calculation
    }

    @Override
    public boolean isCarFree(String id) {
        try {
            return rentalDAO.isCarFree(id);
        } catch (Exception ex) {
            Logger.getLogger(RentalServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean isCustomerFree(String id) {
        try {
            return rentalDAO.isCustomerFree(id);
        } catch (Exception ex) {
            Logger.getLogger(RentalServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public String rentCar(RentalDTO rentalDTO) {
           SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        RentalEntity rentalEntity;
        try {
            rentalEntity = new RentalEntity(rentalDTO.getRentalId(),
                    new CustomerEntity(rentalDTO.getCustomer().getId(), rentalDTO.getCustomer().getFirstname(), rentalDTO.getCustomer().getLastname(), rentalDTO.getCustomer().getContactnumber(), rentalDTO.getCustomer().getAddress()),
                    new CarEntity(rentalDTO.getCar().getCarid(), rentalDTO.getCar().getCarnum(), rentalDTO.getCar().getBrand(), rentalDTO.getCar().getModel(), rentalDTO.getCar().getCartype(), rentalDTO.getCar().getDailyrate()),
                    sdf.parse(rentalDTO.getRentalStartDate()),
                    sdf.parse(rentalDTO.getRentalEndDate()),
                    rentalDTO.getRentalCost(),
                    1
            );
            if (rentalDAO.add(rentalEntity)) {
                return "Successfully Rented";
            } else {
                return "Fail to Rent";
            }
        } catch (ParseException ex) {
            Logger.getLogger(RentalServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(RentalServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
return "Fail to Rent";
      
    }

    @Override
    public String returnCar(String id) {
        try {
            if (rentalDAO.delete(id)) {
                return "Successfully Returned";
            } else {
                return "Fail to Return";
            }
        } catch (Exception ex) {
            Logger.getLogger(RentalServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return "Error: " + ex.getMessage();
        }
        
    }
}
