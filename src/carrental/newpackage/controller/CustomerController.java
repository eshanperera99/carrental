/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carrental.newpackage.controller;

import carrental.newpackage.dto.CustomerDTO;
import carrental.newpackage.service.ServiceFactory;
import carrental.newpackage.service.custom.CustomerService.CustomerServiceException;
import java.util.ArrayList;
import carrental.newpackage.service.custom.CustomerService;

/**
 *
 * @author eshan
 */
public class CustomerController {

    CustomerService managecustService = (CustomerService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.CUSTOMER);

    public String addcustomer(CustomerDTO managecustdto) throws CustomerService.CustomerServiceException {
        return managecustService.addCustomer(managecustdto);
    }

    public ArrayList<CustomerDTO> getAllCustomer() throws CustomerServiceException {
        return managecustService.getAllCustomers();
    }

    public String updateCustomer(CustomerDTO managecustdto) throws CustomerServiceException {
        return managecustService.updateCustomer(managecustdto);
    }

    public String deleteCustomer(String id) throws CustomerServiceException {
        return managecustService.deleteCustomer(id);
    }

    public CustomerDTO getCustomer(String custId) throws CustomerServiceException {
        return managecustService.getCustomer(custId);
    }

}
