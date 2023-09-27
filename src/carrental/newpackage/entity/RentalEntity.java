package carrental.newpackage.entity;

import java.util.Date;

public class RentalEntity {
    private Integer rentalId;
    private CustomerEntity customer;
    private CarEntity car;
    private Date rentalStartDate;
    private Date rentalEndDate;
    private Double rentalCost;
    private int state;
    
    public RentalEntity() {
    }

    public RentalEntity(Integer rentalId, CustomerEntity customer, CarEntity car, Date rentalStartDate, Date rentalEndDate, Double rentalCost, int state) {
        this.rentalId = rentalId;
        this.customer = customer;
        this.car = car;
        this.rentalStartDate = rentalStartDate;
        this.rentalEndDate = rentalEndDate;
        this.rentalCost = rentalCost;
        this.state = state;
    }

    public Integer getRentalId() {
        return rentalId;
    }

    public void setRentalId(Integer rentalId) {
        this.rentalId = rentalId;
    }

    public CustomerEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
    }

    public CarEntity getCar() {
        return car;
    }

    public void setCar(CarEntity car) {
        this.car = car;
    }

    public Date getRentalStartDate() {
        return rentalStartDate;
    }

    public void setRentalStartDate(Date rentalStartDate) {
        this.rentalStartDate = rentalStartDate;
    }

    public Date getRentalEndDate() {
        return rentalEndDate;
    }

    public void setRentalEndDate(Date rentalEndDate) {
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
        return "RentalEntity{" +
                "rentalId=" + rentalId +
                ", customer=" + customer +
                ", car=" + car +
                ", rentalStartDate=" + rentalStartDate +
                ", rentalEndDate=" + rentalEndDate +
                ", rentalCost=" + rentalCost +
                '}';
    }
}
