import static java.lang.Math.abs;
import static java.lang.StrictMath.cos;
import static java.lang.StrictMath.sin;

public class PlayGround {

    public PlayGround(){

    }

    public double getZ(double x,double y, int funcNumber){

        if(funcNumber == 1)
            return (((x-500)*(x-500))+((y-500)*(y-500)));

        if(funcNumber == 2)
            return (abs(x-500)+abs(y-500));

        if(funcNumber == 3)
            return sin(x/100+y/100);



        return (abs(x-800)+abs(y-800));


    }

}
