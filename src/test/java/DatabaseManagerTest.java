import Data.Database;
import Element.Person;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseManagerTest {

    @Test
    void addNewPerson() {
        Person A = new Person("Warszawa","Michał Kwaśniewski","951124444");
        Person B = new Person("Poznań","Michał Komisarek","95112002451");
        Database database=new Database();
        database.getListOfPeople().add(A);
        database.getListOfPeople().add(B);
        System.out.println(database.getListOfPeople());
        assertEquals(new String("[Person{name='Michał Kwaśniewski', pesel='951124444', city='Warszawa'}\n" +
                ", Person{name='Michał Komisarek', pesel='95112002451', city='Poznań'}\n" +
                "]"),database.getListOfPeople().toString());
    }
}