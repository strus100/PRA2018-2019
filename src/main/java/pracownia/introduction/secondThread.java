package pracownia.introduction;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.Collator;
import java.time.LocalTime;
import java.util.*;

public class secondThread extends Thread {

    private static Map<String, String> cities;

    public secondThread(Map<String, String> cities) {
        this.cities = cities;
    }


    public void run() {

        try {
            ThreadStarter.threadStarter();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        while (true) {
                PrintWriter zapis = null;
                try {
                    zapis = new PrintWriter("Data.txt");
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

                final Collator col = Collator.getInstance(new Locale("pl"));

                List<Map.Entry<String, String>> list = new ArrayList<Map.Entry<String, String>>(cities.entrySet());

                Collections.sort(list, new Comparator<Map.Entry<String, String>>() {
                    @Override
                    public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
                        return col.compare(o1.getKey(), o2.getKey());
                    }

                });


                for(Map.Entry<String, String> entry: list){
                    for (int i = list.size() - 2; i >= 0; i--) {
                        if( list.get(i+1).getValue().equalsIgnoreCase( list.get(i).getValue())){
                            list.get(i+1).setValue(" ");

                        }
                    }


                    zapis.println(entry.getValue() + " " + entry.getKey());
                }


                zapis.close();

                //usypiamy wątek na 30 sekund
                try {
                    Thread.sleep(30000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                            }
        }
    }


