import java.util.Scanner;

public class SuperDigit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // TODO: Read n (as String) and k
        // n is read as a String because it can be up to 10^100000 digits long
        if (!sc.hasNext()) return;
        String n = sc.next();
        long k = sc.nextLong();

        // TODO: Calculate the initial sum of digits of n
        long initialSum = 0;
        for (int i = 0; i < n.length(); i++) {
            initialSum += Character.getNumericValue(n.charAt(i));
        }

        // TODO: Multiply that sum by k to account for concatenation
        long totalSum = initialSum * k;

        // TODO: Find the super digit of the resulting value
        System.out.println(calculateSuperDigit(totalSum));
        
        sc.close();
    }

    // Recursive helper function to find the super digit
    public static long calculateSuperDigit(long x) {
        if (x < 10) {
            return x;
        }
        
        long sum = 0;
        while (x > 0) {
            sum += x % 10;
            x /= 10;
        }
        
        return calculateSuperDigit(sum);
    }
}
