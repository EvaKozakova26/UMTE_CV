package cz.uhk.fim.brahavl1.pocitaniuzivatelu;

/**
 * Created by brahavl1 on 12.03.2018.
 */

public class Person {

    private String name;
    private int age;
    private boolean male;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isMale() {
        return male;
    }

    public void setMale(boolean male) {
        this.male = male;
    }

    public Person(String name, int age, boolean male) {
        this.name = name;
        this.age = age;
        this.male = male;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
