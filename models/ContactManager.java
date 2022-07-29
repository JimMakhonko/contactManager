package models;

import java.util.ArrayList;
import java.util.Arrays;

public class ContactManager {
    ArrayList<Contact> contacts;


    public ContactManager() {
        this.contacts = new ArrayList<Contact>();
    }

    public Contact getContacts(int index) {
        return new Contact(contacts.get(index));
    }

    public void setContacts(int index, Contact contact) {
        if(index< 0) throw new IllegalArgumentException("Index can't be less than 0");
        contacts.set(index, new Contact(contact));
    }

    public void addContact(Contact contact) {
        contacts.add(new Contact(contact));
    }

    public void removeContact(String name) {
        if(contacts.isEmpty()) throw new IllegalStateException("Cannot remove from empty list");
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getName().equals(name)) {
                contacts.remove(i);
            }
        }
    }

    @Override
    public String toString() {
        String temp = "";
        for (int i = 0; i < contacts.size(); i++) {
            temp+= contacts.get(i);
            temp+="\n";
        }
        return temp;
    }
}
