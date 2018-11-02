package pracownia.introduction;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class thirdThread extends Thread {

    public static int timeCounter(int hourNow, int minutesNow, int hourTest, int minutesTest){
        int timeNow = hourNow * 60 + minutesNow;
        int timeTest = hourTest * 60 + minutesTest;

         return timeTest - timeNow;
    }

    public void run() {
        try {
            ThreadStarter.threadStarter();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        while (true){
        LocalTime localTime1 = LocalTime.now();

        int hourNow = localTime1.getHour();
        int minutesNow = localTime1.getMinute();

        timer(hourNow,minutesNow);
        }

    }

    public static void timer (int hourNow, int minutesNow){

            int[] hourTest = {8,9,10,11,11,13,13,15,15,17,99};
            int[] minutesTest = {15,45,0,30,45,15,45,15,30,0,99};

            for (int i = 0; i < hourTest.length ; i++) {
                if((LocalDateTime.now().getDayOfWeek()==DayOfWeek.FRIDAY)&&(i == hourTest.length -1)){
                    System.out.println("Do rozpoczęcia zajęć zostało: ");
                    System.out.println(24 * 60 + timeCounter(hourNow, minutesNow, 8, 15)+48 * 60);
                    System.out.println(" minut");
                }
                else
                if(LocalDateTime.now().getDayOfWeek()== DayOfWeek.SATURDAY){
                    System.out.println("Do rozpoczęcia zajęć zostało: ");
                    System.out.println(24 * 60 + timeCounter(hourNow, minutesNow, 8, 15)+24 * 60);
                    System.out.println(" minut");
                }
                else if (LocalDateTime.now().getDayOfWeek()== DayOfWeek.SUNDAY){
                    System.out.println("Do rozpoczęcia zajęć zostało: ");
                    System.out.println(24 * 60 + timeCounter(hourNow, minutesNow, 8, 15)+24 * 60);
                    System.out.println(" minut");

                }else if((hourTest[i] > hourNow)){
                    if(i%2==0)
                        System.out.print("Do końca przerwy zostało: ");
                    else
                        System.out.print("Do końca wykładu zostało: ");
                    System.out.println( timeCounter(hourNow,minutesNow,hourTest[i],minutesTest[i]) + " minut");
                    break;
                }else {
                    if ((hourTest[i] == hourNow) && (minutesTest[i] > minutesNow)) {
                        if (i % 2 == 0)
                            System.out.print("Do końca przerwy zostało: ");
                        else
                            System.out.print("Do końca wykładu zostało: ");
                        System.out.println(timeCounter(hourNow, minutesNow, hourTest[i], minutesTest[i]) + " minut");
                        break;
                    }else if (i == hourTest.length - 1) {
                        System.out.println("Do rozpoczęcia zajęć zostało: ");
                        System.out.println(24 * 60 + timeCounter(hourNow, minutesNow, 8, 15) + " minut");
                    }
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
