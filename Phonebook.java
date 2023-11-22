package test;

import java.util.Scanner;


public class Phonebook
{
    public static void main(String args[])
    {
        Contacts contacts=new Contacts();
        Scanner s= new Scanner(System.in);

        System.out.println("Welcome to my Phonebook");
        System.out.println("What  do you want to do?");
        System.out.println("[1] View List \n[2] Add New \n[3] Edit \n[4] Delete");

        while (1 != 0){



            System.out.print("Enter Option: ");
            int choice= s.nextInt();
            s.nextLine();

            switch(choice){

                case 1:
                    System.out.println("You have selected view");
                    contacts.ViewList();
                    break;

                case 2:
                    System.out.println("You have selected Add new");

                    System.out.print("Enter name: ");
                    String name = s.nextLine();

                    System.out.print("Enter number: ");
                    String num = s.nextLine();

                    contacts.addContact(name, num);
                    break;

                case 3:
                    System.out.println("You have selected Edit");

                    System.out.print("Enter index to edit: ");
                    int i = s.nextInt();

                    contacts.editContact(i);


                case 4:
                    System.out.println("You have selected Delete");
                    System.out.print("Enter index to delete: ");
                    int x = s.nextInt();
                    contacts.deleteContact(x);
                    break;
            }
        }


    }
}
class Contacts
{

    String[] contact_name;
    String[] contact_num;

    int size;
    final int max_contact = 10;

    public Contacts() {
        contact_name = new String[max_contact];
        contact_num = new String[max_contact];
        size = 0;
    }

    public void ViewList()
    {
        System.out.println("Here are your contacts:");

        for (int i = 0; i < size; i++) {
            System.out.println("["+ i+"]"+ contact_name[i] +" "+ contact_num[i]);
        }

    }
    public void addContact(String name, String phoneNumber) {
        if (size < max_contact) {
            contact_name[size] = name;
            contact_num[size] = phoneNumber;
            size++;
            System.out.println("Contact added: " + name + " - " + phoneNumber);
        }
    }
    public void deleteContact(int index) {
        if (index >= 0 && index < size) {
            for (int i = index; i < size - 1; i++) {
                contact_name[i] = contact_name[i + 1];
                contact_num[i] = contact_num[i + 1];
            }
            size--;
        }
    }

    public void editContact(int index) {
        Scanner s = new Scanner(System.in);
        if (index >= 0 && index < size) {
            System.out.printf("\nName: %s[%d] | Number: %s", contact_name[index], index, contact_num[index]);
            System.out.print("\nName[1] | Number[2]: ");
            int choice = s.nextInt();
            s.nextLine();

            if (choice == 1) {
                System.out.print("Name: ");
                String newName = s.nextLine();
                contact_name[index] = newName;
            } else if (choice == 2) {
                System.out.print("Number: ");
                String newNumber = s.nextLine();
                contact_num[index] = newNumber;
            }
        }
    }
}