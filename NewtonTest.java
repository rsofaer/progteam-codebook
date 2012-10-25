public class NewtonTest{
  public static void main(String[] args){
    double[][] coeffs = {
      {1.000000, -12.904762, 40.476190, -28.571429,},
      {3.000000, 11.607143, -34.424603, 22.817460,},
      {2.000000, -10.845238, 16.964286, -10.119048,},
      {3.000000, 4.190476, -3.571429,  2.380952,}};
    Poly p = new Poly(coeffs[0]);
    double answer = Newton.newton(p,0.0);
    System.out.println(p);
    System.out.println(answer);

  }
  static class Poly implements Newton.ContinuousFunction{
    double[] c;
    public Poly(double[] cin){
      c = cin;
    }
    public double function(double x){
      double r = 0;
      for(int i = 0; i < c.length; i++){
        r+= Math.pow(x,i)*c[i];
      }
      return r;
    }
    public double derivative(double x){
      double r = 0;
      for(int i = 1; i < c.length; i++){
        r+= Math.pow(x,i-1)*c[i]*i;
      }
      return r;
    }
    public String toString(){
      String str = "";
      String var = "x";
      String sep = " + ";
      str += c[0] + sep;
      if(c.length > 1)
        str += c[1] + var;
      for(int i = 2; i < c.length; i++){
        str += sep;
        str += c[i] + var + "^" + i;
      }
      return str;
    }
  }
}
