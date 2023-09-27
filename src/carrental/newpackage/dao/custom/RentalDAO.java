/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrental.newpackage.dao.custom;

import carrental.newpackage.dao.CrudDAO;
import carrental.newpackage.entity.CustomerEntity;
import carrental.newpackage.entity.RentalEntity;

/**
 *
 * @author Ruwanmx.Developer
 */
public interface RentalDAO extends CrudDAO<RentalEntity, String>  {
    boolean isCarFree(String id) throws Exception;
     boolean isCustomerFree(String id) throws Exception;
}
