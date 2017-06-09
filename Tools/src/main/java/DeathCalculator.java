/**
 * Created by rvillules on 09/06/17.
 */
public class DeathCalculator {


    public static void calcDeath(int baseStat, int loosingPerSecond){
        int second = 0;

        while (baseStat > 0){
            baseStat -= loosingPerSecond;
            second ++;
        }
        System.out.println("Your pet will die in " + second + " seconds");
        second = second / 60;
        System.out.println("Your pet will die in " + second + " minutes");
        second = second / 60;
        System.out.println("Your pet will die in " + second + " hours");
        second = second / 24;
        System.out.println("Your pet will die in " + second + " days");


    }


    public static void main(String[] args) {
        calcDeath(100000, 1);
    }

}
