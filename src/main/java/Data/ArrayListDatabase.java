package Data;

import Element.Person;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class ArrayListDatabase implements Database {

    private Set<Person> listOfPeople;

    public ArrayListDatabase() {
        listOfPeople = new TreeSet<Person>();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Iterator<Person> itr = listOfPeople.iterator();
        while (itr.hasNext()) {
            stringBuilder.append(itr.next());
        }
        return stringBuilder.toString();
    }

    public String printDatabase() {
        return this.toString();
    }

    public void addPerson(Person person) {
        if (checkIfExist(person)) {
            setDuplicatedPersonPesel(person);
        } else {
            listOfPeople.add(person);
        }
    }

    public void setDuplicatedPersonPesel(Person person) {
        Iterator<Person> itr = listOfPeople.iterator();
        while (itr.hasNext()) {
            if (person.getPesel().equals(itr.next().getPesel())) {
                itr.remove();
                listOfPeople.add(person);
            }
        }
    }

    public boolean checkIfExist(Person person) {
        Iterator<Person> itr = listOfPeople.iterator();
        while (itr.hasNext()) {
            if (person.getPesel().equals(itr.next().getPesel())) {
                return true;
            }else
                return false;
        }
        return false;
    }
}
