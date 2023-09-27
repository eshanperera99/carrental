package carrental.newpackage.service.custom.impl;

import carrental.newpackage.dao.DaoFactory;
import carrental.newpackage.dao.custom.CustomerDAO;
import carrental.newpackage.dto.CustomerDTO;
import carrental.newpackage.entity.CustomerEntity;
import carrental.newpackage.service.custom.CustomerService;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CustomerServiceImpl implements CustomerService {

    CustomerDAO customerDAO = (CustomerDAO) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.CUSTOMER);

    @Override
    public String addCustomer(CustomerDTO customerDTO) {
        CustomerEntity customerEntity = new CustomerEntity(customerDTO.getId(),
                customerDTO.getFirstname(),
                customerDTO.getLastname(),
                customerDTO.getContactnumber(),
                customerDTO.getAddress());
        try {
            if (customerDAO.add(customerEntity)) {
                return "Successfully Added";
            } else {
                return "Fail";
            }
        } catch (Exception ex) {
            Logger.getLogger(CustomerServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public String deleteCustomer(String customerId) throws CustomerServiceException {
        try {
            if (customerDAO.delete(customerId)) {
                return "Successfully Deleted";
            } else {
                return "Fail";
            }
        } catch (Exception ex) {
            Logger.getLogger(CustomerServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public String updateCustomer(CustomerDTO customerDTO) throws CustomerServiceException {
        CustomerEntity customerEntity = new CustomerEntity(customerDTO.getId(),
                customerDTO.getFirstname(),
                customerDTO.getLastname(),
                customerDTO.getContactnumber(),
                customerDTO.getAddress());
        try {
            if (customerDAO.update(customerEntity)) {
                return "Successfully Updated";
            } else {
                return "Fail";
            }
        } catch (Exception ex) {
            Logger.getLogger(CustomerServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public CustomerDTO getCustomer(String customerId) throws CustomerServiceException {
        CustomerEntity customerEntity = null;
        try {
            customerEntity = customerDAO.get(customerId);
            return new CustomerDTO(customerEntity.getId(), customerEntity.getFirstname(),
                customerEntity.getLastname(), customerEntity.getContactnumber(), customerEntity.getAddress());
        } catch (Exception ex) {
            Logger.getLogger(CustomerServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ArrayList<CustomerDTO> getAllCustomers() throws CustomerServiceException {
        ArrayList<CustomerDTO> customerDTOs = new ArrayList<>();
        ArrayList<CustomerEntity> customerEntities = null;
        try {
            customerEntities = customerDAO.getALL();
        } catch (Exception ex) {
            Logger.getLogger(CustomerServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (CustomerEntity customerEntity : customerEntities) {
            CustomerDTO customerDTO = new CustomerDTO(customerEntity.getId(),
                    customerEntity.getFirstname(),
                    customerEntity.getLastname(),
                    customerEntity.getContactnumber(),
                    customerEntity.getAddress());
            customerDTOs.add(customerDTO);
        }
        return customerDTOs;
    }
}
