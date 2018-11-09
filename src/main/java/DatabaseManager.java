import Data.SetDatabase;
import Element.Person;
import Schedule.MyJob;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

public class DatabaseManager {

    private SetDatabase database;
    private Scanner input;
    private Status status;
    private String command;

    private File file;
    public DatabaseManager(SetDatabase database, Scanner input) {
        this.database = database;
        this.input = input;
        this.status = Status.RUNNING;
        this.command = new String();
        this.file = checkFileNumber();
    }

    public void databaseRun() {
        //saveDataToFile();
        try {
            while (status == Status.RUNNING) {
                quartzHandler();
                System.out.println("Type 'add' to add new person to database or 'exit' to quit");
                command = input.nextLine();
                if (command.equals("add")) {
                    addNewPersonInput();
                } else if (command.equals("exit")) {
                    status = Status.STOP;
                }
            }
            saveDataToFile();
        }
        catch(InterruptedException io){
            io.printStackTrace();
        }
    }
    private void addNewPersonInput() {
        try {
            System.out.println("Enter city of person");
            String city = input.nextLine();
            System.out.println("Enter Name,Surname and pesel of person");
            String nameAndPesel = input.nextLine();
            String[] nameAndPeselParsed;
            nameAndPeselParsed = ParseInput(nameAndPesel);
            database.addPerson(new Person(city, nameAndPeselParsed[0] + " " + nameAndPeselParsed[1], nameAndPeselParsed[2]));
        }catch (Exception e){
            System.out.println("Wrong amount of Exceptions try Again");
        }
    }

    public String[] ParseInput(String input) {
        String[] separatedInput = input.split(" ");
        return separatedInput;
    }
    public void saveDataToFile(){

        try {
            PrintWriter out = new PrintWriter(file);
            out.println(database.printDatabase());
            out.close();
        }catch(FileNotFoundException err){
            System.out.println("File not found Programmers Fault");
        }
    }
    public void saveDataToFileEveryHalfMinute(){
        try{
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            scheduler.start();

        }catch(SchedulerException se){
            se.printStackTrace();
        }
            }
    public File checkFileNumber(){
        File file;
        String path;
        for(Integer i = 0;;i++) {
            path = "Pesel Database "+ i.toString()+".txt";
            file=new File(path);
            if(!file.exists()){
                return file;
            }
        }
    }
     public void quartzHandler() throws InterruptedException {

       try {
            // Grab the Scheduler instance from the Factory
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

            // define the job and tie it to our SimpleJob class
            JobDetail job = newJob(MyJob.class)
                    .withIdentity("myJob", "group1") // name "myJob", group "group1"
                    .usingJobData("path", file.getPath())
                    .usingJobData("database",database.printDatabase())
                    .build();
            // Trigger the job to run now, and then repeat every 1 seconds
            Trigger   trigger = newTrigger()
                    .withIdentity("trigger3", "group1")
                    .withSchedule(cronSchedule("0 0/05 * * * ?"))
                    .forJob("myJob", "group1")
                    .build();


            // Tell quartz to schedule the job using our trigger
            scheduler.scheduleJob(job, trigger);

            Thread.sleep(6000);
            // and start it off
            scheduler.start();


            scheduler.shutdown();

        } catch (SchedulerException se) {
            se.printStackTrace();
        }
    }
}
