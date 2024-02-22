import java.util.ArrayList;
import java.util.List;

public class ContactBook {


       private String numberOfPhone;


      List<Contact> contacts = new ArrayList<>();



      public ContactBook(String numberOfPhone) {
            this.numberOfPhone = numberOfPhone;

        }




        public String getNumberOfPhone() {
            return numberOfPhone;
        }

        public void setNumberOfPhone(String numberOfPhone) {
            this.numberOfPhone = numberOfPhone;
        }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    @Override
    public String toString() {
        return "ContactBook{" +
                "contacts=" + contacts +
                '}';
    }
}
