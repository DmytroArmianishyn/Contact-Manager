import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {


ContactBook contactBook = new ContactBook("+380947415055");
Owner owner = Owner.getInstance();
owner.start(contactBook,"D:\\Java\\ContactManager\\src\\Contacts");




    }
}