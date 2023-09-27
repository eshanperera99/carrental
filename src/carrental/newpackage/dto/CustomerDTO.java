package carrental.newpackage.dto;

import static carrental.newpackage.dto.CarDTO.cardto;

public class CustomerDTO {

    public static CustomerDTO customerdto;
    private Integer id;
    private String firstname;
    private String lastname;
    private String contactnumber;
    private String address;

    public CustomerDTO(Integer id, String firstname, String lastname, String contactnumber, String address) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.contactnumber = contactnumber;
        this.address = address;
    }

    public static CustomerDTO getCustomerto() {
        return customerdto;
    }

    public static void setCustomerdto(CustomerDTO customerdto) {
        CustomerDTO.customerdto = customerdto;
    }

    public CustomerDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getContactnumber() {
        return contactnumber;
    }

    public void setContactnumber(String contactnumber) {
        this.contactnumber = contactnumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "CustomerDTO{"
                + "id=" + id
                + ", firstname='" + firstname + '\''
                + ", lastname='" + lastname + '\''
                + ", contactnumber='" + contactnumber + '\''
                + ", address='" + address + '\''
                + '}';
    }
}
