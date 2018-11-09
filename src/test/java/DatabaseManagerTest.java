import Data.ArrayListDatabase;
import Element.Person;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DatabaseManagerTest {

    @Test
    void addNewPerson() {
        Person A = new Person("Poznań", "Michał Kwaśniewski", "951124444");
        Person B = new Person("Poznań", "Michał Komisarek", "95112002451");
        ArrayListDatabase database = new ArrayListDatabase();
        database.addPerson(A);
        database.addPerson(B);
        assertEquals(new String("Person{name='Michał Kwaśniewski',"+
                " pesel='951124444', city='Poznań'}\n"+
                "Person{name='Michał Komisarek', "+
                "pesel='95112002451', city='Poznań'}\n"),database.printDatabase());
    }

    @Test
    void addNewPersonPeselTest(){
        Person A = new Person("Poznań", "Michał Kwaśniewski", "951124444");
        Person B = new Person("Poznań", "Michał Komisarek", "95112002451");
        Person C = new Person("Warszawa","Emilia Nowak","95112002451");
        ArrayListDatabase database = new ArrayListDatabase();
        database.addPerson(A);
        database.addPerson(B);
        database.addPerson(C);
        assertEquals(2,database.checkSize());
    }
}