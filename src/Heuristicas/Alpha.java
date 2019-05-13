
package Heuristicas;

import java.util.Random;

public class Alpha {
    
    Random rand;
    private double value;

    public Alpha(){
        rand = new Random();
        this.value = rand.nextDouble();
    }

    public double getValue(){
      return value;
    }

}
