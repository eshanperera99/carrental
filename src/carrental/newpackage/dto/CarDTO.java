package carrental.newpackage.dto;

public class CarDTO {

    public static CarDTO cardto;

    private Integer Carid;
    private String Carnum;
    private String Brand;
    private String Model;
    private String Cartype;
    private Double Dailyrate;

    public CarDTO(Integer Carid, String Carnum, String Brand, String Model, String Cartype, Double Dailyrate) {
        this.Carid = Carid;
        this.Carnum = Carnum;
        this.Brand = Brand;
        this.Model = Model;
        this.Cartype = Cartype;
        this.Dailyrate = Dailyrate;
    }

    public CarDTO() {
    }

    public static CarDTO getCardto() {
        return cardto;
    }

    public static void setCardto(CarDTO cardto) {
        CarDTO.cardto = cardto;
    }

    public Integer getCarid() {
        return Carid;
    }

    public void setCarid(Integer Carid) {
        this.Carid = Carid;
    }

    public String getCarnum() {
        return Carnum;
    }

    public void setCarnum(String Carnum) {
        this.Carnum = Carnum;
    }

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String Brand) {
        this.Brand = Brand;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String Model) {
        this.Model = Model;
    }

    public String getCartype() {
        return Cartype;
    }

    public void setCartype(String Cartype) {
        this.Cartype = Cartype;
    }

    public Double getDailyrate() {
        return Dailyrate;
    }

    public void setDailyrate(Double Dailyrate) {
        this.Dailyrate = Dailyrate;
    }

    
    
    
    @Override
    public String toString() {
        return "Cardto{" + "Carid=" + Carid + ", Carnum=" + Carnum + ", Brand=" + Brand + ", Model=" + Model + ", Cartype=" + Cartype + ", Dailyrate=" + Dailyrate + '}';
    }

}
