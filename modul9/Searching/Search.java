import java.util.Arrays;

public class Search {
    public static int linearSearch(int[] arr, int search) {
        int check = 0;
        for (int i = 0; i < arr.length; i++) {
            check++;
            if (arr[i] == search) {
                System.out.println("[Linear Search] Jumlah pemeriksaan: " + check);
                return i;
            }
        }
        System.out.println("[Linear Search] Jumlah pemeriksaan: " + check);
        return -1;
    }
    public static int binarySearch(int[] arr, int search ) {
        int low = 0, high = arr.length - 1;
        int check = 0;
        while (low < high) {
            check++;
            int mid = low + (high - low) / 2;
            if (arr[mid] == search) {
                System.out.println("[Binary Search] Jumlah pemeriksaan: " + check);
                return mid;
            }
            if (arr[mid] < search) low = mid + 1;
            else high = mid - 1;
        }
        System.out.println("[Binary Search] Jumlah pemeriksaan: " + check);
        return -1;
    }
    public static void main(String[] args) {
        int[] data = {
            2, 5, 9, 13, 17, 21, 26, 31, 36, 40,
            44, 48, 52, 57, 61, 65, 70, 75, 79, 83,
            88, 90, 92, 93, 94, 95, 96, 97, 98, 100
        }; // Array terurut ascending, 30 elemen unik antara 1-100, mengandung 88

        System.out.println("============================================");
        System.out.println("Array data (terurut ascending):");
        System.out.println(Arrays.toString(data));
        System.out.println("Panjang array: " + data.length);

        //no.2
        int hasilLinear88 = linearSearch(data, 88);
        System.out.println("Hasil: index = " + hasilLinear88);
        System.out.println("Penjelasan: Nilai 88 ditemukan di index " + hasilLinear88
                + " (data[" + hasilLinear88 + "] = " + data[hasilLinear88] + ")");
        
        //no.3 (panggil linearSearch() mencari nilai 99 (tidak ada))
        int hasilLinearTidakAda = linearSearch(data, 99);
        System.out.println("Hasil: index = " + hasilLinearTidakAda);
        System.out.println("Penjelasan: Nilai 99 tidak ditemukan, fungsi mengembalikan -1.");
        //Linear search memeriksa SEMUA 30 elemen sebelum menyerah.

        //no4
        int hasilBinary88 = binarySearch(data, 88);
        System.out.println("Hasil: index = " + hasilBinary88);
        System.out.println("Penjelasan: Nilai 88 ditemukan di index " + hasilBinary88
                + " (data[" + hasilBinary88 + "] = " + data[hasilBinary88] + ")");

        //no.5
        int hasilBinaryTidakAda = binarySearch(data, 99);
        System.out.println("Hasil: index = " + hasilBinaryTidakAda);

        //no.6
        System.out.println("Mencari 88 (ada di index 20 dari 30 elemen):");
        System.out.print("  Linear Search -> "); linearSearch(data, 88);
        System.out.print("  Binary Search -> "); binarySearch(data, 88);

        //no7
        System.out.println("\nMencari 99 (TIDAK ada dalam array):");
        System.out.print("  Linear Search -> "); 
        linearSearch(data, 99);
        System.out.print("  Binary Search -> "); 
        binarySearch(data, 99);


    }
}
