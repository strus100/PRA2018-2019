package pracownia.introduction;

import java.time.LocalTime;

import static java.lang.Thread.currentThread;
import static pracownia.introduction.Main.cities;

public class ThreadStarter {

    public static void threadStarter() throws InterruptedException {

        while(true) {

            if((LocalTime.now().getSecond() == 0))
                break;

            currentThread().sleep(1000);


        }



    }

}
