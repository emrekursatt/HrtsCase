import exception.InvalidNumberofCharactersException;

import java.util.Scanner;

public class MergeString {
    public static void main(String[] args) throws InvalidNumberofCharactersException {


        Scanner scanner = new Scanner(System.in);

        System.out.println("Please Enter First Sentence ");
        String a = scanner.nextLine();
        int a1 = a.length();

        System.out.println("Please Enter Second Sentence");
        String b = scanner.nextLine();
        int b1 = b.length();


        if( (a1 > 1 && a1 < 2500)  && (b1 > 1 && b1 < 2500) ){

            System.out.println("New Sentence: " + a + b);

        }  else {

            throw  new InvalidNumberofCharactersException("Number of Characters must be less than 2500 and greater than 1.");

        }



    }
}