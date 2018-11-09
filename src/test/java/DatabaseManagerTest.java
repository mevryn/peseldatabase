import Data.SetDatabase;
import Element.Person;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DatabaseManagerTest {

    @Test
    void addNewPerson() {
        Person A = new Person("Poznań", "Michał Kwaśniewski", "90090515836");
        Person B = new Person("Poznań", "Michał Komisarek", "95112002451");
        SetDatabase database = new SetDatabase();
        database.addPerson(A);
        database.addPerson(B);
        assertEquals(new String("Person{name='Michał Kwaśniewski',"+
                " pesel='90090515836', city='Poznań'}\n"+
                "Person{name='Michał Komisarek', "+
                "pesel='95112002451', city='Poznań'}\n"),database.printDatabase());
    }

    @Test
    void addNewPersonPeselTest(){
        Person A = new Person("Poznań", "Michał Kwaśniewski", "92071314764");
        Person B = new Person("Poznań", "Michał Komisarek", "95112002451");
        Person C = new Person("Warszawa","Emilia Nowak","95112002451");
        SetDatabase database = new SetDatabase();
        database.addPerson(A);
        database.addPerson(B);
        database.addPerson(C);
        assertEquals(2,database.checkSize());
    }
}