import java.util.Arrays;

public class Sort {
    public static int[] bubble(int[] list) {
        int tukarAtauGeser = 0;
        for (int i = 0; i < list.length - 1; i++) {
            for (int k = i + 1; k < list.length; k++) {
                System.out.printf("%d:%d\n", list[k], list[i]);
                if (list[k] < list[i]) { //ascending: untuk tukar jika elemen kanan lebih kecil
                    int t = list[i];
                    list[i] = list[k];
                    list[k] = t;
                    tukarAtauGeser++;
                    
                }
            }
        }
        System.out.println("Bubble Sort Jumlah Penukaran: " + tukarAtauGeser);
        return list;
    }

    //bubble sort desc no.5
    public static int[] bubbleDesc(int[] list) {
        int tukarAtauGeser = 0;
        for (int i = 0; i < list.length - 1; i++) {
            for (int k = i + 1; k < list.length; k++) {
                if (list[k] > list[i]) { // descending: tukar jika elemen kanan lebih besar
                    int t = list[i];
                    list[i] = list[k];
                    list[k] = t;
                    tukarAtauGeser++;
                }
            }
        }
        System.out.println("[Bubble Sort DESC] Jumlah penukaran: " + tukarAtauGeser);
        return list;
    }

    public static int[] insertion(int[] list) {
        int tukarAtauGeser = 0;
        for (int i = 1; i < list.length; ++i) {
            int key = list[i];
            int k = i - 1;
            //ascending: geser elemen yang lebih besar dari key ke kanan
            /*
            * Move elements of arr[0..i-1], that are greater than key,
            * to one position ahead of their current position
            */
            while (k >= 0 && list[k] > key) {
                list[k + 1] = list[k];
                k = k - 1;
                tukarAtauGeser++ ;
            }
            list[k + 1] = key;
        }
        System.out.println("Insertion Sort Jumlah Pergeseran: " +tukarAtauGeser);
        return list;
    }

    //insertion sort desc no.5
    public static int[] insertionDesc(int[] list) {
        int tukarAtauGeser = 0;
        for (int i = 1; i < list.length; ++i) {
            int key = list[i];
            int k = i - 1;
            // descending: geser elemen yang lebih kecil dari key ke kanan
            while (k >= 0 && list[k] < key) {
                list[k + 1] = list[k];
                k = k - 1;
                tukarAtauGeser++;
            }
            list[k + 1] = key;
        }
        System.out.println("[Insertion Sort DESC] Jumlah pergeseran: " + tukarAtauGeser);
        return list;
    }

    public static int[] selection(int[] list) {
        int tukarAtauGeser = 0;
        // One by one move boundary of unsorted subarray
        for (int i = 0; i < list.length - 1; i++) {
            // Find the minimum element in unsorted array
            int minIndex = i;
            for (int k = i + 1; k < list.length; k++) {
                if (list[k] < list[minIndex])
                minIndex = k;
                tukarAtauGeser++;
            }
            // Swap the found minimum element
            // with the first element
            int t = list[minIndex];
            list[minIndex] = list[i];
            list[i] = t;
        }
        System.out.println("[Selection Sort DESC] Jumlah pergeseran: " + tukarAtauGeser);
        return list;
    }

    //selection sort desc tugas.5
    public static int[] selectionDesc(int[] list) {
        int tukarAtauGeser = 0;
        for (int i = 0; i < list.length - 1; i++) {
            int maxIndex = i;
            for (int k = i + 1; k < list.length; k++) {
                if (list[k] > list[maxIndex]) // descending: cari elemen terbesar
                    maxIndex = k;
            }
            int t = list[maxIndex];
            list[maxIndex] = list[i];
            list[i] = t;
            tukarAtauGeser++;
        }
        System.out.println("[Selection Sort DESC] Jumlah penukaran: " + tukarAtauGeser);
        return list;
    }

    /*copyArray ini digunakan untuk menduplikasi array
    karena kalau array langsung dipakai berulang kali oleh ketiga fungsi sorting,
    array aslinya akan berubah setelah sorting pertama, 
    sehingga sorting kedua dan ketiga tidak dimulai dari data yang sama.
    */
    public static int[] copyArray(int[] original) {
        return Arrays.copyOf(original, original.length);
    }

    public static void main(String[] args) {
        // ubah nilai default Array ini menjadi sebanyak 30 elemen
        // acak/tidak terurut dan nilai elemennya tidak ada yang ganda.
        int[] data = { 10, 5, 15, 8, 3 };
        int[] sorted = bubble(data);
        // int[] sorted = insertion(data);
        // int[] sorted = selection(data);
        System.out.println(Arrays.toString(sorted));

        int[] arr = {
            3, 7, 12, 18, 24, 29, 35, 41, 47, 53,
            58, 63, 67, 72, 76, 80, 84, 88, 91, 94,
            5, 15, 22, 38, 44, 56, 69, 77, 85, 97
        };

        System.out.println(Arrays.toString(arr));

        System.out.println("\n--- Bubble Sort ---");
        int[] arrBubble = copyArray(arr);
        System.out.println("Sebelum: " + Arrays.toString(arrBubble));
        arrBubble = bubble(arrBubble);
        System.out.println("Sesudah: " + Arrays.toString(arrBubble));

        System.out.println("\n--- Insertion Sort ---");
        int[] arrInsertion = copyArray(arr);
        System.out.println("Sebelum: " + Arrays.toString(arrInsertion));
        arrInsertion = insertion(arrInsertion);
        System.out.println("Sesudah: " + Arrays.toString(arrInsertion));

        System.out.println("\n--- Selection Sort ---");
        int[] arrSelection = copyArray(arr);
        System.out.println("Sebelum: " + Arrays.toString(arrSelection));
        arrSelection = selection(arrSelection);
        System.out.println("Sesudah: " + Arrays.toString(arrSelection));

        //no.5
        System.out.println("Perubahan per algoritma:");
        System.out.println(" Bubble   : if (list[k] < list[i])  ->  if (list[k] > list[i])");
        System.out.println(" Insertion: while (list[k] > key)   ->  while (list[k] < key)");
        System.out.println(" Selection: if (list[k] < list[min])->  if (list[k] > list[max]) + cari max bukan min");

        System.out.println("\n--- Bubble Sort DESC ---");
        int[] arrBubbleD = copyArray(arr);
        System.out.println("Sebelum: " + Arrays.toString(arrBubbleD));
        arrBubbleD = bubbleDesc(arrBubbleD);
        System.out.println("Sesudah: " + Arrays.toString(arrBubbleD));

        System.out.println("\n--- Insertion Sort DESC ---");
        int[] arrInsertionD = copyArray(arr);
        System.out.println("Sebelum: " + Arrays.toString(arrInsertionD));
        arrInsertionD = insertionDesc(arrInsertionD);
        System.out.println("Sesudah: " + Arrays.toString(arrInsertionD));

        System.out.println("\n--- Selection Sort DESC ---");
        int[] arrSelectionD = copyArray(arr);
        System.out.println("Sebelum: " + Arrays.toString(arrSelectionD));
        arrSelectionD = selectionDesc(arrSelectionD);
        System.out.println("Sesudah: " + Arrays.toString(arrSelectionD));
        
        //no.6
        System.out.println("Jalankan ketiga sorting untuk menampilkan counter:");
        int[] t1 = copyArray(arr); bubble(t1);
        int[] t2 = copyArray(arr); insertion(t2);
        int[] t3 = copyArray(arr); selection(t3);
/* 
        System.out.println("\nAnalisis Efisiensi:");
        System.out.println("- Selection Sort: selalu tepat (n-1) kali tukar = 29 kali");
        System.out.println("  -> Jumlah swap paling sedikit dan konstan");
        System.out.println("- Insertion Sort: jumlah geser bergantung pada keterurutan data");
        System.out.println("  -> Efisien untuk data hampir terurut");
        System.out.println("- Bubble Sort: jumlah swap bisa sangat banyak (worst case n*(n-1)/2)");
        System.out.println("  -> Paling tidak efisien untuk data acak");
        System.out.println("Kesimpulan: Selection Sort paling sedikit swap, namun");
        System.out.println("Insertion Sort paling efisien untuk data hampir terurut.");
        */
    }
}
