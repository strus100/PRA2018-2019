package pracownia.introduction;

import java.time.LocalTime;
import java.util.Map;

public class secondThread extends Thread {

    private Map<String, String> cities;

    public Map<String, String> getCities() {
        return cities;
    }

    public void setCities(Map<String, String> cities) {
        this.cities = cities;
    }

    public secondThread(Map<String, String> cities) {


            }

    public void run() {
        while (true) {
            LocalTime localTime1 = LocalTime.now();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (localTime1.getSecond() == 0) {
                break;
            }


            while (true) {
                Map<String, String> temp = getCities();
                System.out.println("Watek zapisywarka: " + temp);


                //usypiamy wątek na 30 sekund
                try {
                    Thread.sleep(30000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //Zapis do pliku


            }
        }
    }
}

