package carrental.newpackage.dao;

import carrental.newpackage.dao.custom.impl.CarDaoImpl;
import carrental.newpackage.dao.custom.impl.CustomerDaoImpl;
import carrental.newpackage.dao.custom.impl.RentalDaoImpl;

public class DaoFactory {
 private DaoFactory(){}
 private static DaoFactory daofactory;
 public static DaoFactory getInstance (){
         if (daofactory == null){
             daofactory = new DaoFactory();
         }
         return daofactory;
    }
public SuperDAO getDao(DaoTypes type){
    switch (type) {
        case CUSTOMER:
            return new  CustomerDaoImpl();
         case CAR:
            return new  CarDaoImpl(); 
            case RENTAL:
            return new  RentalDaoImpl();  
        default:
            return null;
    }
}
 public enum DaoTypes{
     CUSTOMER,CAR,RENTAL
 }
}
 