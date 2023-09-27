package carrental.newpackage.dao.custom.impl;

import carrental.newpackage.dao.CrudUtill;
import carrental.newpackage.entity.CarEntity;
import java.sql.ResultSet;
import java.util.ArrayList;
import carrental.newpackage.dao.custom.CarDAO;

public class CarDaoImpl implements CarDAO {

    @Override
    public boolean add(CarEntity t) throws Exception {
        return CrudUtill.executeUpdate("INSERT INTO vehicle VALUES(?,?,?,?,?,?)", t.getCarid(), t.getCarnum(), t.getBrand(),t.getModel(), t.getCartype(), t.getDailyrate());
    }

    @Override
    public boolean update(CarEntity t) throws Exception {
        return CrudUtill.executeUpdate("UPDATE vehicle  SET CarNumber=?,Brand=?, Model=?, CarType=?,DailyRate=? WHERE  CarID=?", t.getCarnum(), t.getBrand(), t.getModel(), t.getCartype(), t.getDailyrate(), t.getCarid());
    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtill.executeUpdate("DELETE FROM vehicle WHERE CarID=?", id);
    }

    @Override
    public CarEntity get(String id) throws Exception {
        ResultSet rst = (ResultSet) CrudUtill.executeQuery("Select * FROM vehicle WHERE CarID = ?", id);
        while (rst.next()) {
            return new CarEntity(rst.getInt(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getDouble(6));
        }
        return null;
    }

    @Override
    public ArrayList<CarEntity> getALL() throws Exception {
        ArrayList<CarEntity> carentitys = new ArrayList<>();
        ResultSet rst = (ResultSet) CrudUtill.executeQuery("Select * FROM vehicle");
        while (rst.next()) {
            CarEntity carentity = new CarEntity(rst.getInt(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getDouble(6));
            carentitys.add(carentity);
        }
        return carentitys;
    }

}
