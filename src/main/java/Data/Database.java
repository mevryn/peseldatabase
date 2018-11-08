package Data;

import Element.Person;

import java.util.ArrayList;
import java.util.List;

public class Database {
    public Database() {
        listOfPeople =new ArrayList<Person>();
    }

    public List<Person> getListOfPeople() {
        return listOfPeople;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0;i<listOfPeople.size();i++){
            stringBuilder.append(listOfPeople.get(i));
        }
        return stringBuilder.toString();
    }

    private List<Person> listOfPeople;

}
