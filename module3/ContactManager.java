import java.util.*;
 
public class ContactManager {
 
    public static void main(String[] args) {
 
        HashMap<String, Contact> contacts = new HashMap<>();
 
        // Step 4: add contacts here
        contacts.put("Ada Lovelace", new Contact("Ada Lovelace", "+1 617 555 0101"));
        contacts.put("Harry Potter", new Contact("Harry Potter", "+1 224-555-2520"));
        contacts.put("Carly Reading", new Contact("Carly Reading", "+1 422-555-1666"));
        contacts.put("Megan Smith", new Contact("Megan Smith", "+1 778-555-5764"));
        contacts.put("Sam Anderson", new Contact("Sam Anderson", "+1 989-555-0020"));        


        // Step 5: look up a contact
        if (contacts.get("Ada Lovelace") == null) System.out.print("Contact not found");
        else System.out.println(contacts.get("Ada Lovelace").toString());


        if (contacts.get("Bob Bobson") == null) System.out.print("Contact not found");
        else System.out.println(contacts.get("Bob Bobson").toString());


        // Step 6: print sorted list
        ArrayList<Contact> sorted = new ArrayList<>(contacts.values());
        sorted.sort((a, b) -> a.getName().compareTo(b.getName()));
        System.out.println("\n=== All Contacts ===");
        for(Contact c : sorted) {
            System.out.println(c.toString());
        }
    }
}

