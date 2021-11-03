package Contact;

public class Contact {
    public String name;
    public String nameNoSpace;
    public String address;
    public String age;

    public Contact(String nameNoSpace, String name, String age, String address) {
        this.nameNoSpace = nameNoSpace;
        this.name = name;
        this.age = age;
        this.address = address;
    }
}
