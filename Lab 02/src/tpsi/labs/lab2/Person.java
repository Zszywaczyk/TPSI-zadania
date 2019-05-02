package tpsi.labs.lab2;

public class Person implements EmailRecipient{
    private String firstName;
    private String lastName;
    private String emailAddress;

    public Person(String firstName, String lastName, String emailAddres){
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddres;
    }

    @Override
    public String getEmailAddress(){
        return emailAddress;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    @Override
    public String toString(){
        return firstName + " " + lastName;
    }
}
