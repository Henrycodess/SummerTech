public class Recursion {
    public static int factorialCool(int n){
        if (n < 1){

            return 1;
            
        }
        return n * factorialCool(n - 1);
    }
    public static int multiply(int i, int j){
        if (j < 1){
            return 0;
        }
        return i + multiply(i, j - 1);
    }
    public static int sumDigits(int n){
        if (n < 10){
            return n;
        }
        return n % 10 + sumDigits(n / 10);
    }
    public static int fibbonacci(int n){
        if (n <= 1){
            return n;
        }
        return fibbonacci(n - 1) + fibbonacci(n - 2);
    }
    public static void main(String[] args) {
        System.out.println(factorialCool(10));
        System.out.println(multiply(4, 7));
        System.out.println(sumDigits(118));
        System.out.println(fibbonacci(7));
    }
}
