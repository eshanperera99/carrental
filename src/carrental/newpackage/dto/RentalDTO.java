package carrental.newpackage.dto;


public class RentalDTO {
    private Integer rentalId;
    private CustomerDTO customer;
    private CarDTO car;
    private String rentalStartDate;
    private String rentalEndDate;
    private Double rentalCost;
    private int state;

    public RentalDTO(Integer rentalId, CustomerDTO customer, CarDTO car, String rentalStartDate, String rentalEndDate, Double rentalCost, int state) {
        this.rentalId = rentalId;
        this.customer = customer;
        this.car = car;
        this.rentalStartDate = rentalStartDate;
        this.rentalEndDate = rentalEndDate;
        this.rentalCost = rentalCost;
        this.state = state;
    }

   

    public RentalDTO() {
    }

    public Integer getRentalId() {
        return rentalId;
    }

    public void setRentalId(Integer rentalId) {
        this.rentalId = rentalId;
    }

    public CustomerDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDTO customer) {
        this.customer = customer;
    }

    public CarDTO getCar() {
        return car;
    }

    public void setCar(CarDTO car) {
        this.car = car;
    }

    public String getRentalStartDate() {
        return rentalStartDate;
    }

    public void setRentalStartDate(String rentalStartDate) {
        this.rentalStartDate = rentalStartDate;
    }

    public String getRentalEndDate() {
        return rentalEndDate;
    }

    public void setRentalEndDate(String rentalEndDate) {
        this.rentalEndDate = rentalEndDate;
    }

    public Double getRentalCost() {
        return rentalCost;
    }

    public void setRentalCost(Double rentalCost) {
        this.rentalCost = rentalCost;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "RentalDTO{" +
                "rentalId=" + rentalId +
                ", customer=" + customer +
                ", car=" + car +
                ", rentalStartDate='" + rentalStartDate + '\'' +
                ", rentalEndDate='" + rentalEndDate + '\'' +
                ", rentalCost=" + rentalCost +
                '}';
    }
}
