package Data;

import Element.Person;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SetDatabaseTest {

    @Test
    void checkIfPeselIsCorrect() {
        Person person  = new Person("Poznan","Michał Komisarek","95112002451");
            Database database = new SetDatabase();
        assertEquals(((SetDatabase) database).checkIfPeselIsCorrect(person),true);
    }
}