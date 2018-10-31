import java.util.Vector;

public class Seeker {

    public static int numOfSeekers;
    public double globalBest;
    public double globalBestX;
    public double globalBestY;

    public double current;
    public double currentX;
    public double currentY;

    public double localBest;
    public double localBestX;
    public double localBestY;

    public Vector vGlobalBest;
    public Vector vLocalBest;
    public Vector vRandom;


    public void Seeker(double currentX, double currentY){
        this.currentX = currentX;
        this.currentY = currentY;

    }
}
