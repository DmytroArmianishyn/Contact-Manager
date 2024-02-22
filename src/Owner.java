import java.io.*;
import java.util.*;

public class Owner {

    private static Owner instance;


    private Owner() {

    }

    public static Owner getInstance() {
        if (instance == null) {
            instance = new Owner();
        }
        return instance;
    }


    public void start(ContactBook contactBook,String file) {

        contactBook.contacts=read(file);



        Scanner scanner = new Scanner(System.in);
        int choice = 1;

        while (choice != 0) {

            System.out.println("0-Stop program \n" +
                    "1-print all contacts \n" +
                    "2-search by: \n" +
                    "3-sorted by:\n" +
                    "4-add contact\n" +
                    "5-delete contact");
            choice = scanner.nextInt();

            switch (choice) {

                case 0:
                    System.out.println("End");
                    write(file,contactBook.contacts);
                    break;

                case 1:
                    iterator(contactBook);
                    break;

                case 2:
                    search(contactBook);
                    break;
                case 3:
                    System.out.println("1-sort by number\n" +
                            "2-sort by name");
                    int ch = scanner.nextInt();
                    comparator(contactBook, ch);
                    break;
                case 4:
add(contactBook);
                    break;
                case 5:

                    System.out.println("you delete " + delete(contactBook.contacts));


            }


        }


    }

    public void search(ContactBook contactBook) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("1-search by number \n" +
                "2-search by name");
        int button = scanner.nextInt();
        scanner.nextLine();

        if (button == 1) {
            System.out.println("Write number ");
            String word = scanner.nextLine();
            for (int i = 0; i < contactBook.contacts.size(); i++) {
                if (contactBook.contacts.get(i).getNumber() == word) {
                    System.out.println(contactBook.contacts.get(i));

                }


            }

        } else if (button == 2) {
            System.out.println("Write name");
            String word = scanner.nextLine();


            for (int i = 0; i < contactBook.contacts.size(); i++) {
                if (contactBook.contacts.get(i).getName().equals(word)) {
                    System.out.println(contactBook.contacts.get(i));

                }


            }
        }

    }


    public void iterator(ContactBook contactBook) {
        int size = contactBook.contacts.size() - 1;


        UserIterator osobaIterator = new UserIterator<>(contactBook.contacts);

        while (osobaIterator.hasNext()) {
            System.out.println(osobaIterator.next());
        }


    }

    public void comparator(ContactBook contactBook, int choice) {
        if (choice == 1) {
            Comparator<Contact> comparator = Comparator.comparing(Contact::getNumber);
            Collections.sort(contactBook.contacts, comparator);
        }
        if (choice == 2) {
            Comparator<Contact> comparator = Comparator.comparing(Contact::getName);
            Collections.sort(contactBook.contacts, comparator);
        }


    }

    public void add(ContactBook contactBook){
Scanner scanner = new Scanner(System.in);
        System.out.println("You want creat User or Company");
        String type = scanner.nextLine();
        System.out.println("Please write name");
        String name = scanner.nextLine();
        System.out.println("Please write number");
        String number =   scanner.nextLine();
        Contact.ContactBuilder contactBuilder = new Contact.ContactBuilder(name,number);

        System.out.println("please enter additional information if you do not want to fill in this field, please put - ");

        System.out.println("email");
        String email = scanner.nextLine();
        contactBuilder.birthdate(email);
        if (type.equals("User")) {

            System.out.println("surname");
            String surname = scanner.nextLine();
contactBuilder.surname(surname);

            System.out.println("birthdate");
            String birthdate = scanner.nextLine();
            contactBuilder.birthdate(birthdate);
        }else if (type.equals("Company")){

            System.out.println("Type of Company");
            String typeofCompany = scanner.nextLine();
            contactBuilder.birthdate(typeofCompany);

        }else {
            throw new RuntimeException();
        }

        contactBook.contacts.add(contactBuilder.build(type));







    }


    public List<Contact> read(String file){
        List<Contact> ls = new ArrayList<>();
        try {
            BufferedReader buf = new BufferedReader(new FileReader(file));
            String line;



            while ((line=buf.readLine())!=null){
                String[] regex = line.split(" ");
                for (int i = 0; i <regex.length ; i++) {
                    if (regex[i].equals("-"))
                        regex[i]=null;

                }
                if (regex[0].equals("U")){

                    ls.add(new User(new Contact.ContactBuilder(regex[1],regex[2]).surname(regex[3]).email(regex[4]).birthdate(regex[5])));

                }
                else if (regex[0].equals("C")) {

                    ls.add(new Company(new Contact.ContactBuilder(regex[1], regex[2]).email(regex[3]).typeofCompany(regex[4])));

                }

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


return ls;


    }
    public void write(String file , List<Contact> ls){

        try {
            PrintWriter writer = new PrintWriter(file);
            String lin = "";

            for (int i = 0; i <ls.size() ; i++) {
                if (ls.get(i).getSurname()==null)
                    ls.get(i).setSurname("-");
                if (ls.get(i).getEmail()==null)
                    ls.get(i).setEmail("-");
                if (ls.get(i).getBirthdate()==null)
                    ls.get(i).setBirthdate("-");
                if (ls.get(i).getTypeofCompany()==null)
                    ls.get(i).setTypeofCompany("-");
                if (ls.get(i).getTypecontact().equals(TypeContact.User))
                    lin += "U " +  ls.get(i).getName() + " " + ls.get(i).getNumber() + " "+ ls.get(i).getSurname() + " " + ls.get(i).getEmail() + " " + ls.get(i).getBirthdate()+ '\n' ;
                 else if (ls.get(i).getTypecontact().equals(TypeContact.Company))
                    lin += "C "  +  ls.get(i).getName() + " " + ls.get(i).getNumber() + " " + ls.get(i).getEmail() + " " + ls.get(i).getTypeofCompany() + '\n';



                writer.write(lin);
                lin="";
            }

            writer.close();


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
    public Contact delete(List<Contact> contacts){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Write number witch you want delete");
        String num = scanner.nextLine();
        Contact contact = null;

        for (int i = 0; i <contacts.size() ; i++) {
            if(contacts.get(i).getNumber().equals(num)) {
                contact = contacts.get(i);
                contacts.remove(i);

            }

        }

return contact;
    }

}
