package eirb.ohayak.server;

/**
 * Created by mrhyk on 07/11/2016.
 */
public class User {
    private String firstName;
    private String lastName;
    private String city;

    public User(String firstName, String lastName, String city){
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

}
