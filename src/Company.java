public class Company extends Contact{
    protected Company(ContactBuilder builder) {
        super(builder);

        builder.typecontact(TypeContact.Company);
        setTypecontact(TypeContact.Company);




    }
}
