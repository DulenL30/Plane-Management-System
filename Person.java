public class Person {
    private String name;
    private String surname;
    private String email;

    public Person(String name, String surname, String email){
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    // Getters and Setters for return the values and set the values.
    public  String getName(){
        return name;
    }

    public void setName(String name){
        this .name = name;
    }

    public String getSurname(){
        return surname;
    }

    public void setSurname(String surname){
        this.surname = surname;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }


    // Method for print personal information.
    public void print_person_info(){
        System.out.println("Person Information: ");
        System.out.println("Name: " + name);
        System.out.println("Surname: " + surname);
        System.out.println("Email: " + email);
    }
}
