package Schedule;
import Data.Database;
import org.quartz.*;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

@PersistJobDataAfterExecution
public class MyJob implements Job {
    public MyJob() {
    }
      public void execute(JobExecutionContext context) throws JobExecutionException {
        {
            JobKey key = context.getJobDetail().getKey();

            JobDataMap dataMap = context.getJobDetail().getJobDataMap();
            System.err.println(dataMap.getString("database"));
            System.err.println(dataMap.getString("path"));
            try {
                String database = dataMap.getString("database");
                PrintWriter writer = new PrintWriter(dataMap.getString("path"));
                writer.println("database");
                writer.close();
            }catch(FileNotFoundException exception)
            {
                exception.printStackTrace();
            }
        }
    }
}
