import java.util.ArrayList;
import java.util.Scanner;


public class theNearNumbersProblem {
    // Sayının mutlak değerini döndürür.
    public static int abs(int num){
        if(num < 0) return -num;
        return num;
    }

    // Bir Integer içeren ArrayList'teki en küçük sayının bulunmasını sağlar.
    public static int findMin(ArrayList<Integer> arrayList){
        if(arrayList.isEmpty())
            return -1;
        int min = arrayList.get(0);
        for (Integer integer: arrayList) {
            if(min > integer)
                min = integer;
        }
        return min;
    }

    // Bir String içeren ArrayList'teki en küçük Stringin bulunmasını sağlar.
    // Tasarlamış olduğum getAscii fonksiyonuyla beraber, iki Stringin ascii değerleri karşılaştırılıyor.

    public static String findMinString(ArrayList<String> stringList){
        String min = stringList.get(0);
        for (String string: stringList) {
            if(getAscii(min) > getAscii(string)){
                min = string;
            }
        }
        return min;
    }

    // Bir Stringin toplam ascii değerini döndürür.
    public static int getAscii(String string){
        int asciiTotal = 0;
        for (int i = 0; i < string.length(); i++) {
            asciiTotal += string.charAt(i);
        }
        return asciiTotal;
    }

    // Bir String içeren ArrayList'in küçükten büyüğe sıralanmasını sağlar.
    // Bunu yaparken oluşturulan yeni ArrayList'e, parametre olarak gelen arrayListten küçükten büyüğe olacak şekilde eklenir.
    // Bunu yaparken listedeki en küçük String'i bulma fonksiyonu çağrılır.
    // Aynı zamanda her loop iteration'unda, parametre arraylistinden diğer listeye eklenen eleman çıkartılır.
    // Parametre listesinde eleman bittiği zaman, output listesi döndürülür.

    public static ArrayList<String> sortStringArr(ArrayList<String> arrayList){
        ArrayList<String> output = new ArrayList<>();
        while(!arrayList.isEmpty()){
            String concat = findMinString(arrayList);
            output.add(concat);
            arrayList.remove(concat);
        }
        return output;
    }



    // Problemi çözen fonksiyon
    // Öncelikli olarak her elemanın diğer elemanlarla olan farklarının mutlak değerleri absoluteValuesOfI adlı bir listeye eklenir.
    // Ardından absoluteValuesOfI listesindeki en küçük mutlak değer elde edilir.
    // Eğer bu değer, 1 ise; bu tam sayılar için en küçük mutlak değer anlamına geliyor; direkt loop sonlandırılır.
    // Öteki türlü, tüm mutlak değerler absoluteValues adlı bir listede listelenir

    // Liste dolaşıldıktan sonra, absoluteValues listesinin en küçük değeri bulunur, yani en küçük mutlak değer verisi çekilir.
    // Ardından absolutePairs diye bir arraylist oluşturuyoruz. Bu listenin içine mutlak değer farkları, en küçük mutlak değere eşit olan sayı çiftlerini ekleyeceğim..
    // Loopla tararken küçük olan sayı başa gelecek şekilde çiftleri bir stringte birleştirip listeye ekliyorum.
    // Ardından pairların bulunduğu bu String ArrayList'i sıralanır. Sıralanan bu liste outputumuz olur.


    public static String[] solve(int[] arr){

        ArrayList<Integer> absoluteValues = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            ArrayList<Integer> absoluteValuesOfI = new ArrayList<>();
            for (int j = i + 1; j < arr.length && j + 1 < arr.length; j++) {

                absoluteValuesOfI.add( abs(arr[i] - arr[j]) );

            }

            int minNumber = findMin(absoluteValuesOfI);

            if(minNumber == 0)
                continue;

            if(minNumber == 1){
                absoluteValues.add(1);
                break;
            } else if(minNumber != -1){
                absoluteValues.add(minNumber);
            }

        }

        int minAbsolute = findMin(absoluteValues);
        ArrayList<String> absolutePairs = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {

            for (int j = i + 1; j < arr.length; j++) {

                if(! (abs(arr[i] - arr[j]) == minAbsolute) ){
                    continue;
                }

                String concatStr = "";
                if(arr[i] > arr[j]){
                    concatStr += arr[j] + " " + arr[i];
                } else {
                    concatStr += arr[i] + " " + arr[j];
                }

                if(absolutePairs.contains(concatStr))
                    continue;

                absolutePairs.add(concatStr);

            }

        }

        ArrayList<String> sorted = sortStringArr(absolutePairs);

        String[] output = new String[sorted.size()];
        for (int i = 0; i < sorted.size(); i++) {
            output[i] = sorted.get(i);
        }
        return output;

    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("How Many Elements Should the Array Have ? ");
        int listLength = scanner.nextInt(); // Listeye eklenecek eleman sayısı
        int[] numberList = new int[listLength]; // Kullanıcıdan alınan eleman sayısında yeni liste oluşturma.

        int temp; // Dizi Değişkeni


        if (listLength > 1 && listLength < 1000 ) {
            for (int i = 0; i < numberList.length; i++) { //Eleman sayısı kadar dönecek for döngüsü.

                System.out.print((i + 1) + ". Enter Element: "); // i+1 ' in sebebi 0. eleman değil 1. eleman yazmasını istediğim için.
                numberList[i] = scanner.nextInt(); // Kullanıcıdan veri alma işlemi.
                if(-20000 >= numberList[i] || 20000 <= numberList[i]){
                    throw new RuntimeException("Invalid element size.");
                }
            }

        } else {
            throw new RuntimeException("Invalid list size.");
        }

        String[] result = solve(numberList);
        for (String string: result) {
            System.out.println(string);
        }
    }
}