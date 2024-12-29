package POJO;

public class BillingAddress {
    private String FirstName;
    private String LastName;
    private String postalCode;

    public BillingAddress(String firstName, String lastName, String postalCode) {
        FirstName = firstName;
        LastName = lastName;
        this.postalCode = postalCode;
    }

    public BillingAddress() {
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}
