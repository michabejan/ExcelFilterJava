import javafx.beans.property.SimpleStringProperty;

/**
 * Created by bejan on 13.02.2017.
 */
public class Donator {

    SimpleStringProperty address;
    SimpleStringProperty title;
    SimpleStringProperty firstname;
    SimpleStringProperty surname;
    SimpleStringProperty street;
    SimpleStringProperty postalcode;

    public String getExtra() {
        return extra.get();
    }

    public SimpleStringProperty extraProperty() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra.set(extra);
    }

    SimpleStringProperty extra;


    public String getAddress() {
        return address.get();
    }

    public SimpleStringProperty addressProperty() {
        return address;
    }

    public void setAddress(String address) {
        this.address.set(address);
    }

    public String getTitle() {
        return title.get();
    }

    public SimpleStringProperty titleProperty() {
        return title;
    }

    public void setTitle(String title) {
        this.title.set(title);
    }

    public String getFirstname() {
        return firstname.get();
    }

    public SimpleStringProperty firstnameProperty() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname.set(firstname);
    }

    public String getSurname() {
        return surname.get();
    }

    public SimpleStringProperty surnameProperty() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname.set(surname);
    }

    public String getStreet() {
        return street.get();
    }

    public SimpleStringProperty streetProperty() {
        return street;
    }

    public void setStreet(String street) {
        this.street.set(street);
    }

    public String getPostalcode() {
        return postalcode.get();
    }

    public SimpleStringProperty postalcodeProperty() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode.set(postalcode);
    }

    public String getLocation() {
        return location.get();
    }

    public SimpleStringProperty locationProperty() {
        return location;
    }

    public void setLocation(String location) {
        this.location.set(location);
    }

    public String getEmail() {
        return email.get();
    }

    public SimpleStringProperty emailProperty() {
        return email;
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public String getPhone() {
        return phone.get();
    }

    public SimpleStringProperty phoneProperty() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone.set(phone);
    }

    public String getWhere() {
        return where.get();
    }

    public SimpleStringProperty whereProperty() {
        return where;
    }

    public void setWhere(String where) {
        this.where.set(where);
    }

    public String getHowMuch() {
        return howMuch.get();
    }

    public SimpleStringProperty howMuchProperty() {
        return howMuch;
    }

    public void setHowMuch(String howMuch) {
        this.howMuch.set(howMuch);
    }

    public String getOnce() {
        return once.get();
    }

    public SimpleStringProperty onceProperty() {
        return once;
    }

    public void setOnce(String once) {
        this.once.set(once);
    }

    public String getMultiple() {
        return multiple.get();
    }

    public SimpleStringProperty multipleProperty() {
        return multiple;
    }

    public void setMultiple(String multiple) {
        this.multiple.set(multiple);
    }

    SimpleStringProperty location;

    public Donator(SimpleStringProperty address, SimpleStringProperty title, SimpleStringProperty firstname, SimpleStringProperty surname, SimpleStringProperty street, SimpleStringProperty postalcode, SimpleStringProperty location, SimpleStringProperty email, SimpleStringProperty phone, SimpleStringProperty where,SimpleStringProperty extra, SimpleStringProperty howMuch, SimpleStringProperty once, SimpleStringProperty multiple) {
        this.address = address;
        this.title = title;
        this.firstname = firstname;
        this.surname = surname;
        this.street = street;
        this.postalcode = postalcode;
        this.location = location;
        this.email = email;
        this.phone = phone;
        this.where = where;
        this.howMuch = howMuch;
        this.once = once;
        this.multiple = multiple;
        this.extra = extra;
    }

    SimpleStringProperty  email;
    SimpleStringProperty phone;
    SimpleStringProperty where;
    SimpleStringProperty howMuch;
    SimpleStringProperty once;
    SimpleStringProperty multiple;


}
