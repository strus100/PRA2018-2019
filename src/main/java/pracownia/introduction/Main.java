package pracownia.introduction;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static Map<String, String> data = new TreeMap<>();
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);


        //Main loop
        while (true) {
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

    public static void saveToTable(String cityName, String line){

        data.put(cityName,line);
    }

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

    public static String regex(String line) {

        // Create a Pattern object
        Pattern r = Pattern.compile("[0-9]{11}");

        // Create matcher object.
        Matcher m = r.matcher(line);
        if (m.find())
            System.out.println();
        else
            System.out.println("NO MATCH");

        return m.group(0);
    }
}
