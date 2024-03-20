import static java.lang.Math.log;
import static java.lang.Math.pow;

public class Main {

    public static void println(String str){
        System.out.println(str);
    }

    public static double function(double x) {
        double result = 2-0.4809*pow(x-2,3)*log(x-2)+0.1603*pow(x,3);
//        println("Result for x = ".concat(String.valueOf(x)).concat(" = ").concat(String.valueOf(result)));
        return result;
    }

    //Портей Василий, группа ЗИТ-21, вариант 0 (зачётка 17-620)
    // f(x) = 2 - 0.4809*((x-2)^3)*ln(x-2)+0.1603*x^3
    // x=[2.5;5.5]; h=0.5; eps=0.001
    public static void main(String[] args) {

        double minX = 2.5;
        double maxX = 5.5;
        double h = 0.5;
        double eps = 0.001;

        println("\nParabolic Interpolation:");

        double minFParabolic = function(ParabolicInterpolation.findTrinityCenter(h, minX, maxX));
        println("Extremum of f(x) (parabolic interpolation) = ".concat(String.valueOf(minFParabolic)));

        println("\nGolden Ratio:");

        double minFGolden = -GoldenRatio.goldenRatioIteration(minX, maxX, eps);
        println("Extremum of f(x) (golden ratio)) = ".concat(String.valueOf(minFGolden)));

    }
}