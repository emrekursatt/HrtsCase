import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        System.out.print("How Many Elements Should the Array Have ? ");
        int listLenght = scanner.nextInt(); // Listeye eklenecek eleman sayısı

        int[] numberList = new int[listLenght]; // Kullanıcıdan alınan eleman sayısında yeni liste oluşturma.

        int temp; // Dizi Değişkeni

        int min = numberList[0];

        if (listLenght > 1 && listLenght < 1000  ) {
            for (int i = 0; i < numberList.length; i++) { //Eleman sayısı kadar dönecek for döngüsü.

                System.out.print((i + 1) + ". Enter Element: "); // i+1 ' in sebebi 0. eleman değil 1. eleman yazmasını istediğim için.
                numberList[i] = scanner.nextInt(); // Kullanıcıdan veri alma işlemi.
            }

            for (int i = 0; i < numberList.length; i++) { // 0 ile dizi uzunluğu arasında değişen bir dış for döngüsü oluşturma

                for (int j = i + 1; j < numberList.length; j++) { //  i+1 ile dizi uzunluğu arasında değişen bir iç for döngüsü oluşturma
                    if (numberList[j] < numberList[i]) { //geçici bir değişken kullanarak iki sayıyı değiştirme
                        temp = numberList[i];
                        numberList[i] = numberList[j];
                        numberList[j] =temp;
                    }
                }
            }
        } else {
            System.out.println("hata");
        }


    }
}





