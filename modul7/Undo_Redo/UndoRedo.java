import java.util.Scanner;
import java.util.Stack;

public class UndoRedo {
    Stack<String> undoStack = new Stack<>();
    Stack<String> redoStack = new Stack<>();

    public void action(String command) {
        System.out.println("Action: " + command);
        undoStack.push(command); //setiap action baru -> redoStack dikosongkan
        redoStack.clear();
        printBothInstance();
    }

    //percobaan 1 - melengkapi undo();
    //command di atas undoStack dikeluarkan dan masuk ke redoStack
    public void undo() {
        if (undoStack.isEmpty())
            System.out.println("Nothing to undo.");
        else {
            String cmd = undoStack.pop(); //keluarkan dari undoStack
            redoStack.push(cmd); //masukkan ke redoStack
            System.out.println("Undo: " + cmd);
        }
        printBothInstance();
    }

    //percobaan 1 - melengkapi undo();
    //command di atas redoStack dikeluarkan dan masuk ke UndoStack
    public void redo() {
        if (redoStack.isEmpty())
            System.out.println("Nothing to redo.");
        else {
            String cmd = redoStack.pop();
            undoStack.push(cmd);
            System.out.println("Redo: " + cmd);
        }
        printBothInstance();
    }

    //percobaan 2
    public static void printBoth(){
        //(method lama print() digani/ditambah printBoth() agar redo juga tampil) 
    }
    public static void print(Stack<String> stack) {
        System.out.print("Stack Undo: ");
        for(String s: stack)
            System.out.print(s + " ");
        System.out.println();
    }

    public static void printRedo(Stack<String> stack) {
        System.out.print("Stack Redo: ");
        for(String s: stack)
            System.out.print(s + " ");
        System.out.println();
    } 

    /*override printBoth agar memanggil kedua print
    diinisialisasi sebagai instance method agar bisa akses field
    */
    public void printBothInstance(){
        print(undoStack);
        printRedo(redoStack);
    }

    public static void main(String[] args) {
        UndoRedo app = new UndoRedo();
        Scanner scanner = new Scanner(System.in);
        String command;

        while (true) {
            System.out.println("---------------------------------");
            System.out.println("Ketikkan teks sebagai command.");
            System.out.println("Ketik U untuk melakukan Undo");
            System.out.println("Ketik R untuk melakukan Redo");
            System.out.println("Ketik X untuk mengakhiri program.");
            System.out.print("Command: ");
            command = scanner.nextLine();
            if (command.equalsIgnoreCase("x")) break;
            if (command.equalsIgnoreCase("u")) { app.undo(); }
            else if (command.equalsIgnoreCase("r")) { app.redo(); }
            else app.action(command);
            System.out.println();
        }

        scanner.close();
        System.out.println("Program selesai.");
    }
}