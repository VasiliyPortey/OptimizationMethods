import static java.lang.Math.pow;

public class ParabolicInterpolation {

    private static double kramer(double x0, double y0,
                                 double x1, double y1,
                                 double x2, double y2) {
        double delA = y0*(x1-x2)-y1*(x0-x2)+y2*(x0-x1);
        double delB = pow(x0,2)*(y1-y2)-pow(x1,2)*(y0-y2)+pow(x2,2)*(y0-y1);
        return -delB/(2*delA);
    }

    public static double findTrinityCenter(double h, double minX, double maxX){

        double result = 0;

        int count = 0;
        for (double i = minX; i<=maxX; i+=h){
            count++;
        }
        double[] values = new double[count];

        double x = minX;
        for (int i = 0; i<count; i++){
            values[i] = Main.function(x);
            x+=h;
        }

        for (int i = 1; i<count-1; i++){
            if (values[i]<values[i-1]&&values[i]<values[i+1]
                    ||values[i]>values[i-1]&&values[i]>values[i+1]) {
                //||values[i]>values[i-1]&&values[i]>values[i+1]
                // TODO: 20.03.2024
                double x0 = (double)(i-1)*h+minX;
                double x1 = (double) (i) * h + minX;
                double x2 = (double)(i+1)*h+minX;
                result = kramer(x0, values[i-1],
                              x1, values[i],
                              x2, values[i+1]);
                Main.println("Found extremum x (parabolic interpolation) = ".concat(String.valueOf(result)));
            }
        }
        return result;
    }

}
