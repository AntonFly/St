package lab1.main;

import static java.lang.Math.*;

public class Arccos {
    public double get_arccos(double x){
        if (Double.isNaN(x) || Double.isInfinite(x) || abs(x) > 1)
            return Double.NaN;
        if(x == -1)
            return PI;
        if(x == 0 )
            return PI/2;
        if(x == 1 )
            return 0;
        double sum=0;
        for(int i=0; i<=10; i++ ){
            sum= sum+factorial(2*i)/(pow(4,i)*pow(factorial(i),2)*(2*i+1))*pow(x,(2*i+1));
        }
        return PI/2-sum;

    }

    private long factorial(int n) {
        long fact = 1;
        for (int i = 2; i <= n; i++) {
            fact = fact * i;
        }
        return fact;
    }

}
