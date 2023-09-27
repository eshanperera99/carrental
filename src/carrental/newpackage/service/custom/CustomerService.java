package carrental.newpackage.service.custom;

import carrental.newpackage.dto.CustomerDTO;
import carrental.newpackage.service.SuperService;
import java.util.ArrayList;

public interface CustomerService extends SuperService{

    String addCustomer(CustomerDTO customerDTO);

    String deleteCustomer(String customerId) throws CustomerServiceException;

    String updateCustomer(CustomerDTO customerDTO) throws CustomerServiceException;

    CustomerDTO getCustomer(String customerId) throws CustomerServiceException;

    ArrayList<CustomerDTO> getAllCustomers() throws CustomerServiceException;

    public static class CustomerServiceException extends Exception {

        public CustomerServiceException() {
        }

        public CustomerServiceException(String message) {
            super(message);
        }
    }
}