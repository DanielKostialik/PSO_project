import java.util.Random;

public class PSO {

    public static GuiForm gui;
    public static Seeker[] seekers;
    public static int N;
    public static long delay=150;
    public static double radiusRandom;
    public static int funNumber;
    public static boolean newRound;

    public static void main(String[] args){
        delay = 50;
        radiusRandom = 5;
        funNumber = 1;
        N = 10; // number of seekers
        PlayGround playground = new PlayGround();
        gui = new GuiForm();
        gui.drawForm(0,0);
        initSeekers();
        startSearching(playground);
    }

    public static void initSeekers(){
        PSO.seekers = new Seeker[N];
        Seeker.numOfSeekers = seekers.length;
        Random rand = new Random();
        for(int i =0; i<PSO.seekers.length; i++) {
            PSO.seekers[i] = new Seeker();
            PSO.seekers[i].currentX = rand.nextDouble()*1000;
            PSO.seekers[i].currentY = rand.nextDouble()*1000;
        }
    }

    public static void startSearching(PlayGround playground){

        double gBest =  50000;
        double gBestX = 0;
        double gBestY = 0;
        double lBest = 10000;
        double tmp_best = 100000;
        Random rand = new Random();
        double k;
        double glBestX_half;
        double glBestY_half;
        double randx,randy;

        double rads;
        double a ,b;

        gui.redrawI();
        newRound = true;

        while(true){

            if(newRound) {
                gBest = 5000000;
                gBestX = 0;
                gBestY = 0;
                lBest = 1000000;

                for (int i = 0; i < Seeker.numOfSeekers; i++) {
                    seekers[i].localBest = 10000;
                    seekers[i].localBestX = seekers[i].currentX;
                    seekers[i].localBestY = seekers[i].currentY;
                }

                // the First global best
                System.out.printf("Function: %d\n",funNumber);
                for (int i = 0; i < Seeker.numOfSeekers; i++) {
                    tmp_best = playground.getZ(seekers[i].currentX, seekers[i].currentY, funNumber);
                    if (tmp_best <= gBest) {
                        gBest = tmp_best;
                        gBestX = seekers[i].currentX;
                        gBestY = seekers[i].currentY;
                    }
                    if (tmp_best <= lBest) {
                        seekers[i].localBest = tmp_best;
                        seekers[i].localBestX = seekers[i].currentX;
                        seekers[i].localBestY = seekers[i].currentY;
                    }
                }

                rand = new Random();
                gui.redrawI();
                newRound = false;

            }

            //System.out.printf("Global best: %f - %f \n",gBestX, gBestY);

            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
              e.printStackTrace();
            }

            gui.redrawI();


            for (int i = 0; i < Seeker.numOfSeekers; i++) {

                randx = rand.nextDouble()*(2*radiusRandom) - radiusRandom;
                randy = rand.nextDouble()*(2*radiusRandom) - radiusRandom;

                // random generating test velocity. This is not sufficient TODO
                seekers[i].currentX = seekers[i].currentX + randx;
                seekers[i].currentY = seekers[i].currentY + randy;

                glBestX_half = (seekers[i].localBestX + gBestX)/2;
                glBestY_half = (seekers[i].localBestY + gBestY)/2;


                k = (glBestY_half - seekers[i].currentY) / (glBestX_half - seekers[i].currentX);
                rads = Math.atan(k);
                a = 10*Math.sin(rads);
                b = 10*Math.cos(rads);


                if(seekers[i].currentX > glBestX_half) {
                    seekers[i].currentX = seekers[i].currentX - b;
                    seekers[i].currentY = seekers[i].currentY - a;
                }
                else {
                    seekers[i].currentX = seekers[i].currentX + b;
                    seekers[i].currentY = seekers[i].currentY + a;

                }

                //System.out.printf("New %f %f\n",seekers[i].currentX, seekers[i].currentY);

                if(seekers[i].currentX < 0)
                    seekers[i].currentX = 0;
                if(seekers[i].currentY < 0)
                    seekers[i].currentY = 0;


                if(playground.getZ(seekers[i].currentX,seekers[i].currentY,funNumber) <= gBest){
                    gBest =  playground.getZ(seekers[i].currentX,seekers[i].currentY,funNumber);
                    gBestX = seekers[i].currentX;
                    gBestY = seekers[i].currentY;
                }
                if(playground.getZ(seekers[i].currentX,seekers[i].currentY,funNumber) <= seekers[i].localBest){
                    seekers[i].localBest =  playground.getZ(seekers[i].currentX,seekers[i].currentY,funNumber);
                    seekers[i].localBestX = seekers[i].currentX;
                    seekers[i].localBestY = seekers[i].currentY;
                }


            }

        }

        //System.out.println("--");
    }



}
