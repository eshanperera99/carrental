package carrental.newpackage.dao.custom.impl;

import carrental.newpackage.controller.CarController;
import carrental.newpackage.controller.CustomerController;
import carrental.newpackage.dao.CrudUtill;
import carrental.newpackage.dao.custom.RentalDAO;
import carrental.newpackage.dto.CarDTO;
import carrental.newpackage.dto.CustomerDTO;
import carrental.newpackage.entity.CarEntity;
import carrental.newpackage.entity.CustomerEntity;
import carrental.newpackage.entity.RentalEntity;

import java.sql.ResultSet;
import java.util.ArrayList;

public class RentalDaoImpl implements RentalDAO {

    @Override
    public boolean update(RentalEntity t) throws Exception {
        return CrudUtill.executeUpdate("UPDATE rental SET RentalEndDate=? WHERE CustomerId=? AND CarId=?",
                t.getRentalEndDate(), t.getCustomer().getId(), t.getCar().getCarid());
    }

    @Override
    public ArrayList<RentalEntity> getALL() throws Exception {
        ArrayList<RentalEntity> rentalEntities = new ArrayList<>();
        ResultSet resultSet = (ResultSet) CrudUtill.executeQuery("SELECT * FROM rental");
        while (resultSet.next()) {
             CustomerDTO customerDTO = new CustomerController().getCustomer(resultSet.getInt(2) + "");
            CarDTO carDTO = new CarController().getcar(resultSet.getInt(3) + "");

            RentalEntity rentalEntity = new RentalEntity(
                    resultSet.getInt(1),
                    new CustomerEntity(customerDTO.getId(), customerDTO.getFirstname(), customerDTO.getLastname(), customerDTO.getContactnumber(), customerDTO.getAddress()),
                    new CarEntity(carDTO.getCarid(), carDTO.getCarnum(), carDTO.getBrand(),carDTO.getModel(), carDTO.getCartype(),carDTO.getDailyrate()),
                    resultSet.getDate(4),
                    resultSet.getDate(5),
                    resultSet.getDouble(6),
                    resultSet.getInt(7)
            );
            rentalEntities.add(rentalEntity);
        }
        return rentalEntities;
    }

    @Override
    public RentalEntity get(String rentalId) throws Exception {
        ResultSet resultSet = (ResultSet) CrudUtill.executeQuery("SELECT * FROM rental WHERE RentalId=?", rentalId);
        if (resultSet.next()) {

            CustomerDTO customerDTO = new CustomerController().getCustomer(resultSet.getInt(2) + "");
            CarDTO carDTO = new CarController().getcar(resultSet.getInt(3) + "");

            return new RentalEntity(
                    resultSet.getInt(1),
                    new CustomerEntity(customerDTO.getId(), customerDTO.getFirstname(), customerDTO.getLastname(), customerDTO.getContactnumber(), customerDTO.getAddress()),
                    new CarEntity(carDTO.getCarid(), carDTO.getCarnum(), carDTO.getBrand(),carDTO.getModel(), carDTO.getCartype(),carDTO.getDailyrate()),
                    resultSet.getDate(4),
                    resultSet.getDate(5),
                    resultSet.getDouble(6),
                    resultSet.getInt(7)
            );
        }
        return null;
    }

    @Override
    public boolean add(RentalEntity rentalEntity) throws Exception {
        return CrudUtill.executeUpdate("INSERT INTO rental (CustomerId, CarId, RentalStartDate, RentalEndDate, RentalCost, state) VALUES (?,?,?,?,?,?)",
                rentalEntity.getCustomer().getId(),
                rentalEntity.getCar().getCarid(),
                rentalEntity.getRentalStartDate(),
                rentalEntity.getRentalEndDate(),
                rentalEntity.getRentalCost(),
                rentalEntity.getState());
    }

    @Override
    public boolean delete(String id) throws Exception {
        System.out.println(id);
        return CrudUtill.executeUpdate("UPDATE rental SET state=0 WHERE RentalId=?",
                id);
    }

    @Override
    public boolean isCarFree(String carID) throws Exception {
        ResultSet resultSet = (ResultSet) CrudUtill.executeQuery("SELECT * FROM rental WHERE CarId=? AND state = 1", carID);
        return !resultSet.next();
    }

    @Override
    public boolean isCustomerFree(String customerID) throws Exception {
        ResultSet resultSet = (ResultSet) CrudUtill.executeQuery("SELECT * FROM rental WHERE CustomerId=? AND state = 1", customerID);
        return !resultSet.next();
    }
}
