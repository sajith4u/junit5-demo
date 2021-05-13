package io.arimac.demo.repeated;

import java.util.Random;

public class RandomNumberGenerator {

    public int getRandomNumber() {
        Random r = new Random();
        int low = 0;
        int high = 10;
        return r.nextInt(high - low) + low;
    }
}
