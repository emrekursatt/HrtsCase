import exception.InvalidNumberofCharactersException;

import java.util.Scanner;

public class MergeString {
    public static void main(String[] args) throws InvalidNumberofCharactersException {


        Scanner scanner = new Scanner(System.in); //Kullanıcıdan veri almak.

        System.out.print("Please Enter First Sentence: ");
        String a = scanner.nextLine();//Kullanıcıdan veri almak.
        int a1 = a.length(); // String ifadenin karakter sayısını buluyoruz.

        System.out.print("Please Enter Second Sentence: ");
        String b = scanner.nextLine();//Kullanıcıdan veri almak.
        int b1 = b.length();// String ifadenin karakter sayısını buluyoruz.


        if( (a1 > 1 && a1 < 2500)  && (b1 > 1 && b1 < 2500) ){ //Karakter sayısı için limir belirliyoruz.

            System.out.println("New Sentence: " + a + b);

        }  else {

            throw  new InvalidNumberofCharactersException("Number of Characters must be less than 2500 and greater than 1.");// Yanlış karakter sayısı adında bir hata çıktısı alıyoruz.

        }



    }
}