import models.Contact;
import models.ContactManager;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Scanner;

public class Main {
    static ContactManager contactManager = new ContactManager();
    public static void main(String[] args) {
        try {
            loadContacts("contacts.txt");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("CONTACTS LOADED\n\n");
            System.out.println(contactManager);
            manageContacts();
        }
    }

    /**
     * Name: manageContacts
     * <p>
     * Inside the function:
     * • 1. Starts a new instance of Scanner;
     * • 2. In an infinite loop, the user can choose to a) add b) remove a contact c) exit.
     * •        case a: ask for the name, phone number and birthDate.
     * •        case b: ask who they'd like to remove.
     * •        case c: break the loop.
     * • 3. close Scanner.
     */
    public static void manageContacts() {

        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("Would you like to \n\ta) add a contact\n\tb) remove a contact\n\tc) to exit.");
            String response = scan.nextLine();
            if (response.equals("a")) {
                System.out.print("\tName: ");
                String name = scan.nextLine();
                System.out.print("\tPhone number: ");
                String phoneNumber = scan.nextLine();
                System.out.print("\tBirth date: ");
                String birthDate = scan.nextLine();
                if (name.isBlank() || phoneNumber.isBlank() || phoneNumber.length() < 5|| birthDate.isBlank()) {
                    System.out.println("\nThe input you provided is not valid. Registration failed.");
                } else {
                    try {
                        contactManager.addContact(new Contact(name,phoneNumber,birthDate));
                    } catch (ParseException e) {
                        System.out.println(e.getMessage());
                    } finally {
                        System.out.println("\n\nUPDATED CONTACTS\n\n" + contactManager);
                    }
                }
            } else if (response.equals("b")) {
                System.out.print("What contact do you want to remove: ");
                String nameToRemove = scan.nextLine();
                contactManager.removeContact(nameToRemove);
                System.out.println(nameToRemove + " successfully removed");
                System.out.println(contactManager);
            }
            if (response.equals("c")) {
                break;
            }
        }
        scan.close();
    }

    public static void loadContacts(String filename) throws FileNotFoundException {
        FileInputStream file = new FileInputStream(filename);
        Scanner scanF = new Scanner(file);
        while (scanF.hasNextLine()) {
            try {
                Contact contact = new Contact(scanF.next(), scanF.next(), scanF.next());
                contactManager.addContact(contact);
            } catch (ParseException e) {
                System.out.println(e.getMessage());
            }
        }
        scanF.close();
    }
    /**
     * Name: loadContacts
     * @param fileName (String)
     * @throws FileNotFoundException
     *
     * Inside the function:
     *   • 1. loads contacts from <fileName>;
     *   • 2. From the manager object, it adds all contacts to the contacts list.
     *        Hint: use scan.next to grab the next String separated by white space.
     */

}
