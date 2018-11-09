package Element;

import java.util.Comparator;

public class Person implements Comparable<Person> {

    private String name;
    private String pesel;
    private String city;

    public int compareTo(Person person){
        return this.city.compareTo(person.getCity());
    }
    @Override
    public boolean equals(Object obj){
        if(obj instanceof Person) {
            Person person = (Person) obj;
            return person.pesel.equals(this.pesel);
        }else{
            return false;
        }
    }
    @Override
    public int hashCode(){
        return pesel.hashCode();
    }
    public String getCity() {
        return city;

    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public Person(String city, String name, String pesel) {
        this.name = name;
        this.pesel = pesel;
        this.city = city;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", pesel='" + pesel + '\'' +
                ", city='" + city + '\'' +
                '}' + '\n';
    }
}
