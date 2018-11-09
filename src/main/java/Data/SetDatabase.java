package Data;

import Element.Person;

import java.util.*;

public class SetDatabase implements Database {

    private Set<Person> listOfPeople;

    public SetDatabase() {
        listOfPeople = new HashSet<Person>();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        List<Person> personList = sortDatabaseByCity();
        for (int i = 0; i < personList.size(); i++) {
            stringBuilder.append(personList.get(i));
        }
        return stringBuilder.toString();
    }

    public String printDatabase() {
        return this.toString();
    }

    public void addPerson(Person person) {
        if (checkIfPeselIsCorrect(person)) {
            listOfPeople.remove(person);
            listOfPeople.add(person);
        } else {
            System.out.println("Wrong Pesel");
        }
    }

    public ArrayList sortDatabaseByCity() {
        List<Person> sorted = new ArrayList<>(listOfPeople);
        sorted.sort(Comparator.comparing(Person::getCity));
        return (ArrayList) sorted;
    }

    public int checkSize() {
        return listOfPeople.size();
    }

    public boolean checkIfPeselIsCorrect(Person person) {
        int peselLength = person.getPesel().length();
        if(peselLength!=11){
            return false;
        }
        int[] pesel = new int[peselLength];
        for (int i = 0; i < peselLength; i++) {
            pesel[i] = Character.getNumericValue(person.getPesel().charAt(i));
        }
        int controlNumber = Character.getNumericValue(person.getPesel().charAt(peselLength - 1));
        int sum = 0;
        sum += pesel[0] * 1;
        sum += pesel[1] * 3;
        sum += pesel[2] * 7;
        sum += pesel[3] * 9;
        sum += pesel[4] * 1;
        sum += pesel[5] * 3;
        sum += pesel[6] * 7;
        sum += pesel[7] * 9;
        sum += pesel[8] * 1;
        sum += pesel[9] * 3;
        sum = 10 - (sum % 10);
        if (sum == controlNumber || sum == 10) {
            return true;
        } else
            return false;
    }
}
