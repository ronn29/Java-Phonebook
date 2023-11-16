import java.util.Scanner;
 
public class Phonebook {
    public static Scanner s = new Scanner(System.in);
    private String[] names;
    private String[] numbers;
    private int size = 0;
    private static final int contactSize = 10;
 
    public Phonebook() {
        names = new String[contactSize];
        numbers = new String[contactSize];
    }
 
    public static void main(String[] args) {
        Phonebook pb = new Phonebook();
 
        System.out.println("Welcome to my Phonebook");
        System.out.println("What do you want to do?");
        System.out.println("\n1. Add");
        System.out.println("2. Edit");
        System.out.println("3. Delete");
        System.out.println("4. View");
 
        while (true) {
            System.out.print("\nSelect: ");
            int select = s.nextInt();
            s.nextLine();
          
            switch(select){
               case 1:
                  System.out.print("Enter name: ");
                  String name = s.nextLine();
                  System.out.print("Enter number: ");
                  String phoneNumber = s.nextLine();
                  pb.addContact(name, phoneNumber);
                  break;
               
               case 2:
                  System.out.print("Enter index to edit: ");
                  int index = s.nextInt();
                  pb.editContact(index);
                  break;
               
               case 3:
                  System.out.print("Enter index to delete: ");
                   index = s.nextInt();
                  pb.deleteContact(index);
                  break;
               
               case 4:
                  System.out.println("Here are the list");
                  pb.viewContacts();
                  break;
               
               default:
                  System.out.println("Invalid");
                  break;
            
            }
        }
    }
 
    public void addContact(String name, String number) {
        if (size < contactSize) {
            names[size] = name;
            numbers[size] = number;
            size++;
        }
    }
 
    public void viewContacts() {
        for (int i = 0; i < size; i++) {
            
            System.out.printf("\nName: %s[%d] | Number: %s", names[i], i, numbers[i]);
        }
    }
 
    public void deleteContact(int index) {
        if (index >= 0 && index < size) {
            for (int i = index; i < size - 1; i++) {
                names[i] = names[i + 1];
                numbers[i] = numbers[i + 1];
            }
            size--;
        } else {
            System.out.println("Invalid index to delete");
        }
    }
 
    public void editContact(int index) {
        if (index >= 0 && index < size) {
            System.out.printf("\nName: %s[%d] | Number: %s", names[index], index, numbers[index]);
            System.out.print("\nName[1] | Number[2]: ");
            int choice = s.nextInt();
            s.nextLine();
 
            if (choice == 1) {
                System.out.print("Name: ");
                String newName = s.nextLine();
                names[index] = newName;
            } else if (choice == 2) {
                System.out.print("Number: ");
                String newNumber = s.nextLine();
                numbers[index] = newNumber;
            } else {
                System.out.println("Invalid choice for editing");
            }
        } else {
            System.out.println("Invalid index to edit");
        }
    }
}
