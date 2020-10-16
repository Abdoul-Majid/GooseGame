package goosegame.random;
import java.util.Random;

/**
 */
public class RandomDice{

    public static Random rand = new Random();

    public static int generate(int min,int max){

        return rand.nextInt(max-min)+1;
    }
}