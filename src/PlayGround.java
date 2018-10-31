import static java.lang.Math.abs;
public class PlayGround {

    public PlayGround(){

    }

    public double getZ(double x,double y, int funcNumber){

        if(funcNumber == 1)
            return (abs(x-500)+abs(y-500));
        if(funcNumber == 2)
            return (abs(x-300)+abs(y-300));
        if(funcNumber == 3)
            return (abs(x-100)+abs(y-100));


        return (abs(x-800)+abs(y-800));


    }

}
