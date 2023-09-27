package carrental.newpackage.dao.custom.impl;

import carrental.newpackage.dao.CrudUtill;
import carrental.newpackage.dao.custom.CustomerDAO;
import carrental.newpackage.entity.CustomerEntity;

import java.sql.ResultSet;
import java.util.ArrayList;

public class CustomerDaoImpl implements CustomerDAO {

    @Override
    public boolean add(CustomerEntity customerEntity) throws Exception {
        return CrudUtill.executeUpdate("INSERT INTO customer VALUES(?,?,?,?,?)",
                customerEntity.getId(),
                customerEntity.getFirstname(),
                customerEntity.getLastname(),
                customerEntity.getContactnumber(),
                customerEntity.getAddress());
    }

    @Override
    public boolean update(CustomerEntity customerEntity) throws Exception {
        return CrudUtill.executeUpdate("UPDATE customer SET Firstname=?, Lastname=?, ContactNumber=?, Address=? WHERE CustomerID=?",
                customerEntity.getFirstname(),
                customerEntity.getLastname(),
                customerEntity.getContactnumber(),
                customerEntity.getAddress(),
                customerEntity.getId());
    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtill.executeUpdate("DELETE FROM customer WHERE CustomerID=?", id);
    }

    @Override
    public CustomerEntity get(String id) throws Exception {
        ResultSet resultSet =(ResultSet)  CrudUtill.executeQuery("SELECT * FROM customer WHERE CustomerID=?", id);
        if (resultSet.next()) {
            return new CustomerEntity(
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5)
            );
        }
        return null;
    }

    @Override
    public ArrayList<CustomerEntity> getALL() throws Exception {
              ArrayList<CustomerEntity> customerEntities = new ArrayList<>();
        ResultSet resultSet = (ResultSet) CrudUtill.executeQuery("SELECT * FROM customer");
        while (resultSet.next()) {
            CustomerEntity customerEntity = new CustomerEntity(
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5)
            );
            customerEntities.add(customerEntity);
        }
        return customerEntities;
    }

}
