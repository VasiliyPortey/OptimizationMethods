public class GoldenRatio {
    private static final double F = 0.618;
    private static int iterationsCount = 0;

    private static double findMax(double f1, double f2,
                                   double u, double v) {
        if (f1>f2){
            Main.println("Value of x for max f(x) = ".concat(String.valueOf(u)));
            return f1;
        }
        else {
            Main.println("Value of x for max f(x) = ".concat(String.valueOf(v)));
            return f2;
        }
    }

    public static double goldenRatioIteration(double a, double b, double eps) {

        iterationsCount++;


        double u = b-F*(b-a);
        double v = a+F*(b-a);

        double f1 = -Main.function(u);
        double f2 = -Main.function(v);

        if (f1<=f2){
            b = v;
            v = u;
            f2 = f1;
            u = b - F*(b-a);
            f1 = -Main.function(u);
        }
        else {
            a = u;
            u = v;
            f1 = f2;
            v = a + F*(b-a);
            f2 = -Main.function(v);
        }

        if (iterationsCount==3) {
            Main.println("3rd iteration:\n"
                    .concat("f1 = ").concat(String.valueOf(-f1))
                    .concat("\nf2 = ").concat(String.valueOf(-f2))
                    .concat("\na = ").concat(String.valueOf(a))
                    .concat("\nb = ").concat(String.valueOf(b)));
            double extF = findMax(f1, f2, a, b);
            Main.println("Extremum of f(x) = ".concat(String.valueOf(-extF)));
        }

        if (b-a<eps){
            Main.println("\nAll needed Golden Ratio iterations count for (b-a)<esp = ".concat(String.valueOf(iterationsCount)));
            return findMax(f1, f2, a, b);
        }
        else
            return goldenRatioIteration(a, b, eps);

    }
}
