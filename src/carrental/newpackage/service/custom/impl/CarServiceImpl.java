package carrental.newpackage.service.custom.impl;

import carrental.newpackage.dao.DaoFactory;
import carrental.newpackage.dto.CarDTO;
import carrental.newpackage.entity.CarEntity;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import carrental.newpackage.service.custom.CarService;
import carrental.newpackage.dao.custom.CarDAO;

public class CarServiceImpl implements CarService {

    CarDAO cardao = (CarDAO) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.CAR);

    @Override
    public String addcar(CarDTO cardto) {
        CarEntity carentity = new CarEntity(cardto.getCarid(),
                cardto.getCarnum(),
                cardto.getModel(),
                cardto.getBrand(),
                cardto.getCartype(),
                cardto.getDailyrate());
        try {
            if (cardao.add(carentity)) {
                return "Successfully Added";
            } else {
                return "Fail";
            }
        } catch (Exception ex) {
            Logger.getLogger(CarServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public String deletecar(String id) throws Exceptions {
        try {
            if (cardao.delete(id)) {
                return "Successfully Deleted";
            } else {
                return "Fail";
            }
        } catch (Exception ex) {
            Logger.getLogger(CarServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public String updatecar(CarDTO cardto) throws Exceptions {
        CarEntity carentity = new CarEntity(cardto.getCarid(),
                cardto.getCarnum(),
                cardto.getModel(),
                cardto.getBrand(),
                cardto.getCartype(),
                cardto.getDailyrate());
        try {
            if (cardao.update(carentity)) {
                return "Successfully Updated";
            } else {
                return "Fail";
            }
        } catch (Exception ex) {
            Logger.getLogger(CarServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public CarDTO getcar(String id) throws CarService.Exceptions {
        CarEntity carentity = null;
        try {
            carentity = (cardao.get(id));
            return new CarDTO(carentity.getCarid(), carentity.getCarnum(), carentity.getModel(), carentity.getBrand(), carentity.getCartype(), carentity.getDailyrate());
    
        } catch (Exception ex) {
            Logger.getLogger(CustomerServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ArrayList<CarDTO> getAllcar() throws Exceptions {
        ArrayList<CarDTO> cardtos = new ArrayList<>();
        ArrayList<CarEntity> carentitys = null;
        try {
            carentitys = cardao.getALL();
        } catch (Exception ex) {
            Logger.getLogger(CarServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (CarEntity carentity : carentitys) {
            CarDTO cardto = new CarDTO(carentity.getCarid(), carentity.getCarnum(), carentity.getModel(), carentity.getBrand(), carentity.getCartype(), carentity.getDailyrate());
            cardtos.add(cardto);
        }
        return cardtos;
    }
}
