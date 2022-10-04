
import java.util.Scanner;

public class MergeString {

    // Problemi çözen fonksiyon
    // İki stringin lengthlerini karşılaştırdıktan sonra, en küçük olan stringin lengthini belirledim.
    // İlk yaptığım loopta, stringlerin karakterlerini sırayla, en küçük string bitene kadar sıralıyorum.
    // Ardından geri kalanı, büyük stringlerin karakterleriyle doldurduktan sonra, çıktıyı döndürüyorum.

    public static String mergeStrings(String a, String b)
    {
        String output = "";

        int aLength = a.length();
        int bLength = b.length();

        int minLength;
        if(aLength > bLength){
            minLength = bLength;
        } else {
            minLength = aLength;
        }

        for (int i = 0; i < minLength; i++) {
            output += a.charAt(i) + "" + b.charAt(i);
        }

        if(minLength == bLength){
            for (int i = 0; i < a.length() - minLength; i++) {
                output += a.charAt(i);
            }
        } else {
            for (int i = 0; i < b.length() - minLength; i++) {
                output += b.charAt(i);
            }
        }

        return output;


    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter two strings\nA: ");
        String A = scanner.next();
        System.out.print("B: ");
        String B = scanner.next();

        if( ! ( (A.length() > 1 && A.length() < 2500) && (B.length() > 1 && B.length() < 2500) ) ){
            throw new RuntimeException("Invalid string sizes.");
        }

        System.out.println("Output: " + mergeStrings(A, B));
    }
}