import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Contact {



   private String name;
    private String surname;

    private  String number;

    private TypeContact typecontact;

    private String email;


    private String birthdate;

    private String typeofCompany;

   protected Contact(ContactBuilder builder) {
        name=builder.name;
        surname=builder.surname;
        number=builder.number;
        birthdate=builder.birthdate;
        typecontact=builder.typecontact;
        typeofCompany=builder.typeofCompany;
        email=builder.email;


    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public TypeContact getTypecontact() {
        return typecontact;
    }

    public void setTypecontact(TypeContact typecontact) {
        this.typecontact = typecontact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getTypeofCompany() {
        return typeofCompany;
    }

    public void setTypeofCompany(String typeofCompany) {
        this.typeofCompany = typeofCompany;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(", ");;
        sb.append((surname!=null?surname + " ,":""));
        sb.append(number).append(", ");
        sb.append(typecontact).append(", ");
        sb.append((birthdate!=null?birthdate+ " ,":""));
        sb.append((typeofCompany!=null?typeofCompany+ " ,":""));
        sb.append((email!=null?email:""));
        sb.append(".").append('\n');
        return sb.toString();
    }



    public static class ContactBuilder{

        private String name;
        private   String number;


       private String surname=null;



     private TypeContact typecontact=null;

    private   String email=null;


      private String birthdate=null;

     private String typeofCompany=null;


      public ContactBuilder(String name, String number) {
          this.name = name;

          Pattern pattern = Pattern.compile("\\+380\\d{9}");


          Matcher matcher = pattern.matcher(number);
          if (matcher.find())
          this.number = number;
          else
              throw new FormatExeption();
      }

      public ContactBuilder surname (String val){
          surname=val;
          return this;

      }
      public ContactBuilder birthdate (String val){
         birthdate=val;
          return this;

      }
      public ContactBuilder typecontact (TypeContact val){
         typecontact=val;
          return this;

      }
      public ContactBuilder email (String val){
          email=val;
          return this;

      }
      public ContactBuilder typeofCompany (String val){
          typeofCompany=val;
          return this;

      }



      public Contact build(String type){
        if (type.equals("User")){
            return new User(this);
        }
        else if (type.equals("Company"))
            return  new Company(this);
        else
            throw new RuntimeException();
      }



  }



}
