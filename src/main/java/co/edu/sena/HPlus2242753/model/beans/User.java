package co.edu.sena.HPlus2242753.model.beans;

public class User {
    private String password;
    private String username;
    private String firstname;
    private String lastname;
    private int age;
    private String activity;

    public User() {
    }
    public User(String password, String username, String firstname, String lastname, int age, String activity) {
        this.password = password;
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.activity = activity;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public int getAge() {
        return age;
    }

    public String getActivity() {
        return activity;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }
    @Override
    public String toString() { //usado para depurar
        return "User{" +
                "password='" + password + '\'' +
                ", username='" + username + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", age='" + age + '\'' +
                ", activity='" + activity + '\'' +
                '}';
    }
}