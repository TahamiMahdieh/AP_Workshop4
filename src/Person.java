public class Person {
    private String firstName;
    private String lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object o){
        if (o == this)
            return true;
        if (!(o instanceof Person))
            return false;
        Person p = (Person) o;
        return (p.firstName.equals(firstName) && p.lastName.equals(lastName));
    }

    // person class
}
