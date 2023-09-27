/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carrental.newpackage.service;

import carrental.newpackage.service.custom.impl.CarServiceImpl;
import carrental.newpackage.service.custom.impl.CustomerServiceImpl;
import carrental.newpackage.service.custom.impl.RentalServiceImpl;

/**
 *
 * @author eshan
 */
public class ServiceFactory {
    private static ServiceFactory serviceFactory;
    private ServiceFactory(){}
    public static ServiceFactory getInstance (){
         if (serviceFactory == null){
             serviceFactory = new ServiceFactory();
         }
         return serviceFactory;
    }
    public SuperService getService(ServiceType type){
        switch (type) {
            case CUSTOMER:
                return new CustomerServiceImpl();
              case CAR:
                return new CarServiceImpl();  
              case RENTAL:
                return new RentalServiceImpl();  
            default:
                return null;
        }
    }
    public enum ServiceType{
        CUSTOMER,CAR,RENTAL
    }
    
}
