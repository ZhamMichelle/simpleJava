package java8;

import java.util.Optional;

public class optionalFeature {
    public static void main(String[] args) {


        System.out.println(find()+10);


    }

    public static int find() {
        User user = new User("Michelle", "Obama",45);
        User user1=new User();
        Optional<User> opt = Optional.ofNullable(user1);
        return opt.get().getAge();
    }
}

class User {
    private String name;
    private String surname;
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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

    public User() {
    }

    public User(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age=age;
    }

}
