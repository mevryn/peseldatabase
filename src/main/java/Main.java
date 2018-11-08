import Data.Database;

import java.util.Scanner;

public class Main {
    public Main(){

    }

    public static void main(String[] args){
        DatabaseManager databaseManager = new DatabaseManager(new Database(),new Scanner(System.in));
        databaseManager.databaseRun();
    }
}
