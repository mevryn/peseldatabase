package Data;

import Element.Person;

import java.util.*;

public class ArrayListDatabase implements Database {

    private Set<Person> listOfPeople;

    public ArrayListDatabase() {
        listOfPeople = new HashSet<Person>();
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
        listOfPeople.remove(person);
        listOfPeople.add(person);
    }
    public ArrayList sortDatabaseByCity(){
      List<Person> sorted = new ArrayList<>(listOfPeople);
        sorted.sort(Comparator.comparing(Person::getCity));
        return (ArrayList)sorted;
    }
    public int checkSize(){
        return listOfPeople.size();
    }
}
