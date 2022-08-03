package models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Contact {
    private String name;
    private String phoneNumber;
    private String birthDate;
    private int age;

    public Contact(String name, String phoneNumber, String birthDate) throws ParseException {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name can't be null or blank.");
        }
        if (phoneNumber == null || phoneNumber.isBlank()) {
            throw new IllegalArgumentException("Phone number can't be null or blank.");
        } else if (phoneNumber.length() < 5) {
            throw new IllegalArgumentException("Phone number can't be shorter than 5 digits.");
        }
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
        this.age = toAge(birthDate);
    }

    public Contact(Contact source) {
        this.name = source.name;
        this.phoneNumber = source.phoneNumber;
        this.birthDate = source.birthDate;
        this.age = source.age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name can't be blank or null.");
        }
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.isBlank()) {
            throw new IllegalArgumentException("Phone number can't be null or blank.");
        }
        if (phoneNumber.length() < 5) {
            throw new IllegalArgumentException("Phone number can't be shorter than 5 digits");

        }
        this.phoneNumber = phoneNumber;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) throws ParseException {
        this.birthDate = birthDate;
        setAge(toAge(birthDate));
    }

    public int toAge(String birthDate) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        formatter.setLenient(false);
        long diff = new Date().getTime() - formatter.parse(birthDate).getTime();// Date().getTime() - time in milliseconds from 1970 till now
        return age = (int) (TimeUnit.MILLISECONDS.toDays(diff) / 365);
    }

    public int getAge() {
        return age;
    }

    private void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return
                "Name: " + name + "\n" +
                        "Phone Number: " + phoneNumber + "\n" +
                        "Birth Date: " + birthDate + "\n" +
                        "Age: " + age + " year old\n";
    }
}
