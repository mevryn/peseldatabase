import Data.ArrayListDatabase;
import Element.Person;

import java.util.Scanner;

public class DatabaseManager {

    private ArrayListDatabase database;
    private Scanner input;
    private Status status;
    private String command;

    public DatabaseManager(ArrayListDatabase database, Scanner input) {
        this.database = database;
        this.input = input;
        this.status = Status.RUNNING;
        this.command = new String();
    }

    public void databaseRun() {
        while (status == Status.RUNNING) {
            System.out.println("Type 'add' to add new person to database or 'exit' to quit");
            command = input.nextLine();
            if (command.equals("add")) {
                addNewPersonInput();
            } else if (command.equals("exit")) {
                status = Status.STOP;
            }
            System.out.println(database.printDatabase());
        }
    }

    private void addNewPersonInput() {
        System.out.println("Enter city of person");
        String city = input.nextLine();
        System.out.println("Enter Name,Surname and pesel of person");
        String nameAndPesel = input.nextLine();
        String[] nameAndPeselParsed;
        nameAndPeselParsed = ParseInput(nameAndPesel);
        database.addPerson(new Person(city, nameAndPeselParsed[0] + " " + nameAndPeselParsed[1], nameAndPeselParsed[2]));
    }

    public String[] ParseInput(String input) {
        String[] separatedInput = input.split(" ");
        return separatedInput;
    }
}
