package Data;

import Element.Person;

import java.util.ArrayList;
import java.util.List;

public class ArrayDatabase implements Database {

    private List<Person> listOfPeople;

    public ArrayDatabase() {
        listOfPeople = new ArrayList<Person>();
    }

    public List<Person> getListOfPeople() {
        return listOfPeople;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < listOfPeople.size(); i++) {
            stringBuilder.append(listOfPeople.get(i));
        }
        return stringBuilder.toString();
    }

    public void addPerson(){

    }

}
