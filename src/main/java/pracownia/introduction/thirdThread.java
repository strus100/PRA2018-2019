package pracownia.introduction;

import java.time.LocalTime;

public class thirdThread extends Thread {

    public static int timeCounter(int hourNow, int minutesNow, int hourTest, int minutesTest){
        int timeNow = hourNow * 60 + minutesNow;
        int timeTest = hourTest * 60 + minutesTest;

         return timeTest - timeNow;

    }

    public static void threadStarter(LocalTime localTime1){

        while(true) {

            if(localTime1.getSecond()==0)
                break;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public void run() {

      // threadStarter(LocalTime.now());

       while (true){
           LocalTime localTime1 = LocalTime.now();

           int hourNow = localTime1.getHour();
           int minutesNow = localTime1.getMinute();

           int[] hourTest = {8,9,10,11,11,13,13,15,15,17};
           int[] minutesTest = {15,45,0,30,45,15,45,15,30,0};



           for (int i = 0; i < hourTest.length ; i++) {
               if((hourTest[i] > hourNow)){
                   if(i%2==0)
                       System.out.print("Do przerwy zostało: ");
                   else
                       System.out.print("Do końca wykładu zostało: ");
                   System.out.println( timeCounter(hourNow,minutesNow,hourTest[i],minutesTest[i]) + " minut");
                   break;
               }else{
                   if((hourTest[i] == hourNow) && (minutesTest[i] > minutesNow)){
                       if(i%2==0)
                           System.out.print("Do przerwy zostało: ");
                       else
                           System.out.print("Do końca wykładu zostało: ");
                       System.out.println(timeCounter(hourNow,minutesNow,hourTest[i],minutesTest[i]) + " minut");
                       break;
                   }
                   System.out.println("Do rozpoczęcia zajęć zostało: ");
                   System.out.println(24 * 60 + timeCounter(hourNow,minutesNow,8,15) + " minut");
               }


           }




           try {
                //usypiamy wątek na 60 sekund
                Thread.sleep(60000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}