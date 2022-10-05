import java.util.ArrayList;
import java.util.Scanner;

public class shoppingCart {

    // Bir Integer içeren ArrayList'in küçükten büyüğe sıralanmasını sağlar.
    // Bunu yaparken küçük olan sayı ile büyük olan sayının yeri değiştirilerek; küçük sayıların listenin başına yığılması sağlanır.
    // Bu yığılma yapılırken, liste ortalama olarak n^2 kere de dolaşıldığı için, başa alınan küçük sayılar da kendi aralarında sıralanmış olur.
    // Eğer listede geride bulunan array elemanı, sonradan gelen array elemanından büyükse, yerlerini değiştiriyoruz.
    // Bu işlemi iç içe 2 loopla yaptığımız için, sıralamalar tüm arrayin tamamının sıralanması için yeterli oluyor.

    public static void sortList(ArrayList<Integer> arrayList)
    {
        int temp;
        for (int i = 0; i < arrayList.size(); i++) { // 0 ile dizi uzunluğu arasında değişen bir dış for döngüsü oluşturma

            for (int j = i + 1; j < arrayList.size(); j++) { //  i+1 ile dizi uzunluğu arasında değişen bir iç for döngüsü oluşturma
                if (arrayList.get(j) < arrayList.get(i)) { //geçici bir değişken kullanarak iki sayıyı değiştirme
                    temp = arrayList.get(i);
                    arrayList.set(i, arrayList.get(j));
                    arrayList.set(j, temp);
                }
            }
        }


    }


    // Problem çözümü için fonksiyon
    // Öncelikli olarak indirim yapılacak fiyatlar listeden belirleniyor.
    // Listedeki loop takibi yapılırken, i = 1 olacak şekilde başlatıyoruz ve bir önceki elemanla karşılaştırma yapıyoruz.
    // Karşılaştırmada önceki gelen eleman büyük ise, önceki elemandan; bulunulan eleman kadar düşülüyor. Bu sayede indirim gerçekleşiyor.
    // Eğer indirim gerçekleşmemişse, daha önce yaratmış olduğumuz notDiscounted adlı bir Integer Arraylist'ine, indirim görmemiş fiyatı yerleştiriyoruz.
    // Loopumuz bittikten sonra, prices listesindeki total fiyatı çıkartıp ekrana basıyoruz.
    // Ardından notDiscounted (yani indirim görmemiş fiyatları) sıraladıktan sonra, onları da ekrana basıyoruz.

    public static void solveProblem(int[] prices){

        if(prices.length < 1)
            return;

        ArrayList<Integer> notDiscounted = new ArrayList<>();


        for (int i = 1; i < prices.length; i++) {
            if(prices[i] >= prices[i - 1]){
                notDiscounted.add(prices[i - 1]);
                continue;
            }

            prices[i - 1] -= prices[i];

            if(prices[i - 1] < 0){
                prices[i - 1] = 0;
            }

        }
        notDiscounted.add(prices[prices.length - 1]);


        int total = 0;
        for (int discountedPrice: prices) {
            total += discountedPrice;
        }


        System.out.print("Total amount: " + total + ", Non-discounted items, C = {");

        sortList(notDiscounted);

        for (int i = 0; i < notDiscounted.size(); i++) {
            if(i == notDiscounted.size() - 1){
                System.out.print(notDiscounted.get(i) + "}");
                continue;
            }

            System.out.print(notDiscounted.get(i) + ", ");
        }

    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("How Many Elements Should the Array Have ? ");
        int listLength = scanner.nextInt(); // Listeye eklenecek eleman sayısı
        int[] numberList = new int[listLength]; // Kullanıcıdan alınan eleman sayısında yeni liste oluşturma.

        
        if (listLength > 1 && listLength < 200 ) {
            for (int i = 0; i < numberList.length; i++) { //Eleman sayısı kadar dönecek for döngüsü.

                System.out.print((i + 1) + ". Enter Element: "); // i+1 ' in sebebi 0. eleman değil 1. eleman yazmasını istediğim için.
                numberList[i] = scanner.nextInt(); // Kullanıcıdan veri alma işlemi.
                if(0 >= numberList[i] || 2000 <= numberList[i]){
                    throw new RuntimeException("Invalid element size.");
                }
            }

        } else {
            throw new RuntimeException("Invalid list size.");
        }

        solveProblem(numberList);
    }
}