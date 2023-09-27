/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package carrental.newpackage.dao;

import java.util.ArrayList;

/**
 *
 * @author eshan
 */
public interface CrudDAO<T ,ID> extends SuperDAO{
     boolean add(T t) throws Exception;
     boolean update(T t)throws Exception;
     boolean delete(ID id)throws Exception;
     T get(ID id)throws Exception;
     ArrayList<T>getALL()throws Exception;
}
