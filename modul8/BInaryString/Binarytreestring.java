import java.util.LinkedList;
import java.util.Queue;

public class Binarytreestring {

    NodeString root;  // PERUBAHAN: Node -> NodeString

    // PERUBAHAN: parameter int -> String
    public void add(String data) {
        if (root == null) {
            root = new NodeString(data);  // PERUBAHAN: Node -> NodeString
            return;
        }
        root.add(data);
    }

    // PERUBAHAN: Node -> NodeString, [%d] -> [%s]
    public void preTraverse(NodeString node) {
        if (node == null) return;
        System.out.printf("[%s] ", node.data);  // PERUBAHAN: %d -> %s
        preTraverse(node.left);
        preTraverse(node.right);
    }

    // PERUBAHAN: Node -> NodeString, [%d] -> [%s]
    public void inTraverse(NodeString node) {
        if (node == null) return;
        inTraverse(node.left);
        System.out.printf("[%s] ", node.data);  // PERUBAHAN: %d -> %s
        inTraverse(node.right);
    }

    // PERUBAHAN: Node -> NodeString, [%d] -> [%s]
    public void postTraverse(NodeString node) {
        if (node == null) return;
        postTraverse(node.left);
        postTraverse(node.right);
        System.out.printf("[%s] ", node.data);  // PERUBAHAN: %d -> %s
    }

    // countNodes, countLeaves, treeHeight -> TIDAK BERUBAH secara logika
    public int countNodes(NodeString node) {
        if (node == null) return 0;
        return 1 + countNodes(node.left) + countNodes(node.right);
    }

    public int countLeaves(NodeString node) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) return 1;
        return countLeaves(node.left) + countLeaves(node.right);
    }

    public int treeHeight(NodeString node) {
        if (node == null) return 0;
        return 1 + Math.max(treeHeight(node.left), treeHeight(node.right));
    }

    // PERUBAHAN: Node -> NodeString, [%d] -> [%s] di level order
    public void levelTraverse(NodeString node) {
        if (node == null) return;
        Queue<NodeString> queue = new LinkedList<>();  // PERUBAHAN: Queue<Node> -> Queue<NodeString>
        queue.add(node);
        while (!queue.isEmpty()) {
            NodeString current = queue.poll();
            System.out.printf("[%s]", current.data);  // PERUBAHAN: %d -> %s
            if (current.left != null)  queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
    }

    public static void main(String[] args) {
        Binarytreestring treeStr = new Binarytreestring();

        // Memasukkan data buah-buahan (String) ke dalam tree
        String[] buah = {"Mangga", "Apel", "Pisang", "Jeruk", "Durian",
                        "Semangka", "Anggur", "Pepaya", "Rambutan", "Kelapa"};

        System.out.println("Data yang dimasukkan:");
        for (String b : buah) {
            System.out.println(b + " dimasukkan.");
            treeStr.add(b);
        }

        System.out.println("\nRoot tree : " + treeStr.root.data);

        System.out.print("\nPreorder  : ");
        treeStr.preTraverse(treeStr.root);
        System.out.println();

        System.out.print("Inorder   : ");
        treeStr.inTraverse(treeStr.root);
        System.out.println();
        System.out.println("(Inorder menghasilkan urutan ALFABET/leksikografis)");

        System.out.print("Postorder : ");
        treeStr.postTraverse(treeStr.root);
        System.out.println();

        System.out.print("LevelOrder: ");
        treeStr.levelTraverse(treeStr.root);
        System.out.println();

        System.out.println("\nTotal node  : " + treeStr.countNodes(treeStr.root));
        System.out.println("Total daun  : " + treeStr.countLeaves(treeStr.root));
        System.out.println("Tinggi tree : " + treeStr.treeHeight(treeStr.root));
    }
}