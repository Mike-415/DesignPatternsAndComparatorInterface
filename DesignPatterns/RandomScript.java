package DesignPatterns;

import java.util.Random;

public class RandomScript implements Programmable
{
    @Override
    public String getScript()
    {
        Random random = new Random();
        return "Random number generated: \n\t\t\t\t\t"+random.nextInt(100)+1;
    }
}
