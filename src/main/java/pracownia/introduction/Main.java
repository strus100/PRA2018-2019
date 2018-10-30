package pracownia.introduction;


import java.time.Duration;
import java.time.LocalTime;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main extends Thread {
    public static Map<String, String> cities = new HashMap<>();



    public static void main(String[] args)  {



        //zapis
    //    secondThread t1 = new secondThread(cities);
   //     t1.start();
        //zegar
      thirdThread  t2 = new thirdThread();
      t2.start();


   //     mainLoop();
    }


    public static String mainLoop(){
        Scanner s = new Scanner(System.in);
        //Main loop
        while (true) {
            System.out.println(cities);
            System.out.println("Podaj miasto: ");
            String cityName = s.nextLine();

            System.out.println("Podaj imię nazwisko i PESEL: ");
            String line = s.nextLine();//user wpisuje

            if(checkPESEL(regex(line)))

                saveToTable(cityName,line);
            else
                System.out.println("Błędny PESEL");

        }
    }
//Zapisuje do mapy
    public static void saveToTable(String cityName, String line){

        //key line  value cityName
        String dataPESEL = regex(line);
        for (Map.Entry<String, String> entry : cities.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (dataPESEL.equals(regex(key))){
                cities.remove(key,value);
            }
        }
        cities.put(line,cityName);
    }

    //Sprawdza sumę kontrolną oddaje boolean
    public static boolean checkPESEL(String dataPESEL) {

        char[] chars = dataPESEL.toCharArray();
        int[] PESELControl = {1, 3, 7, 9, 1, 3, 7, 9, 1, 3, 0};
        int[] intChars = new int[11];
        int checkSum = 0;
        int tempCheckSum = 0;
        for (int i = 0; i < chars.length; i++) {
            String s = chars[i] + "";
            intChars[i] = Integer.parseInt(s);
            checkSum += intChars[i] * PESELControl[i];
        }

        tempCheckSum = checkSum % 10;
        checkSum = tempCheckSum;

        tempCheckSum = 10 - checkSum;
        checkSum = tempCheckSum;

        tempCheckSum = checkSum % 10;
        checkSum = tempCheckSum;

        if(checkSum == intChars[10])
            return true;
        else
            return false;
    }

    // Oddziela PESEL od reszty linii oddaje String
    public static String regex(String line) {

        // Create a Pattern object
        Pattern r = Pattern.compile("[0-9]{11}");

        // Create matcher object.
        Matcher m = r.matcher(line);
        if (!m.find()){
            System.out.println("NO MATCH");
            return Main.mainLoop();
        }
        else
            return m.group(0);

    }
}
