public class Newton{
  interface ContinuousFunction{
    public double function(double x);
    public double derivative(double x);
  }
  final static int MAX_IT = 100000;
  final static double PRECISION = 1*Math.pow(10,-8);
  public static double newton(ContinuousFunction f, double guess, double precision, int maxIt){
    double curX = guess;
    double curVal = f.function(curX);
    int it = 0;
    //Xn+1 = Xn - f(xn)/f'(xn)
    while(Math.abs(curVal) > precision && it < maxIt){
      curX = curX - curVal/f.derivative(curX);
      curVal = f.function(curX);
      it++;
    }
    if(it >= maxIt)
      System.err.println("Newton's method: Too many iterations.");
    return curX;
  }
  public static double newton(ContinuousFunction f, double guess){
    return newton(f, guess, PRECISION, MAX_IT);
  }
  public static double newton(ContinuousFunction f, double guess, double precision){
    return newton(f, guess, precision, MAX_IT);
  }
  public static double newton(ContinuousFunction f, double guess, int maxIt){
    return newton(f, guess, PRECISION, maxIt);
  }
}
