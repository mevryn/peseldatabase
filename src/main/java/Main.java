import Data.ArrayListDatabase;

import java.util.Scanner;

public class Main {
    public Main() {

    }

    public static void main(String[] args) {
        DatabaseManager databaseManager = new DatabaseManager(new ArrayListDatabase(), new Scanner(System.in));
        databaseManager.databaseRun();
    }
}
