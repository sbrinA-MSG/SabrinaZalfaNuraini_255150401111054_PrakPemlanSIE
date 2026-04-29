import java.util.Queue;
import java.util.LinkedList;

public class BinaryTree {

    Node root;


    public void add(int data) {
        if (root == null) {
            root = new Node(data);
            return;
        }
        root.add(data);
    }

    public void preTraverse(Node node) {
        if (node == null) return;
        System.out.printf("[%d] ", node.data);
        preTraverse(node.left);
        preTraverse(node.right);
    }

    public void inTraverse(Node node) {
        if (node == null) return;
        inTraverse(node.left);
        System.out.printf("[%d] ", node.data);
        inTraverse(node.right);
    }

    public void postTraverse(Node node) {
        if (node == null) return;
        postTraverse(node.left);
        postTraverse(node.right);
        System.out.printf("[%d] ", node.data);
    }

    public int countNodes(Node node) {
        if (node == null) return 0;                                    
        return 1 + countNodes(node.left) + countNodes(node.right); 
    }
    //no6
    public int countLeaves(Node node) {
        if (node == null) 
            return 0; //tidak ada node
        if (node.left == null && node.right == null) 
            return 1;            
        return countLeaves(node.left) + countLeaves(node.right);
    }
    //no7
    public int treeHeight(Node node) {
        if (node == null) 
            return 0;                                           
        int leftHeight  = treeHeight(node.left); // Tinggi subtree kiri
        int rightHeight = treeHeight(node.right); // Tinggi subtree kanan
        return 1 + Math.max(leftHeight, rightHeight);    
    }
    
    public void levelTraverse(Node node) {
        if (node == null) return;

        Queue<Node> queue = new LinkedList<>();

        queue.add(node);

        while (!queue.isEmpty()) {
            //Ambil (dequeue) node terdepan dari queue
            Node current = queue.poll();
            System.out.printf("[%d]", current.data);

            //Jika child kiri ada, masukkan ke queue
            if (current.left != null) {
                queue.add(current.left);
            }

            //Jika child kanan ada, masukkan ke queue
            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        // Simpan nilai yang dimasukkan agar bisa ditampilkan ulang
        int[] nilaiMasuk = new int[10];
        for (int i = 0; i < 10; i++) {
            int nilai = (int) (Math.random() * 100);
            nilaiMasuk[i] = nilai;
            System.out.printf("Nilai %d dimasukkan.\n", nilai);
            tree.add(nilai);
        }

        // no.4: Tiga metode traversal
        System.out.println("========================================");

        System.out.print("Preorder  (Root-Left-Right) : ");
        tree.preTraverse(tree.root);
        System.out.println();

        System.out.print("Inorder   (Left-Root-Right) : ");
        tree.inTraverse(tree.root);
        System.out.println();

        System.out.print("Postorder (Left-Right-Root) : ");
        tree.postTraverse(tree.root);
        System.out.println();

        //no5
        System.out.println("========================================");
        int totalNode = tree.countNodes(tree.root);
        System.out.println("Total node dalam tree : " + totalNode);

        //no6
        System.out.println("========================================");
        int totalLeaf = tree.countLeaves(tree.root);
        System.out.println("Total daun (leaf) dalam tree : " + totalLeaf);

        //no7
        System.out.println("========================================");
        int height = tree.treeHeight(tree.root);
        System.out.println("Tinggi tree : " + height);

        //no9
        System.out.println("========================================");
        System.out.print("Level Order (per level, kiri ke kanan) : ");
        tree.levelTraverse(tree.root);
        System.out.println();

        // Perbandingan semua traversal sekaligus
        System.out.println("\n--- Perbandingan Semua Traversal ---");
        System.out.print("Preorder  : "); tree.preTraverse(tree.root);  System.out.println();
        System.out.print("Inorder   : "); tree.inTraverse(tree.root);   System.out.println();
        System.out.print("Postorder : "); tree.postTraverse(tree.root); System.out.println();
        System.out.print("LevelOrder: "); tree.levelTraverse(tree.root); System.out.println();

    }
}
