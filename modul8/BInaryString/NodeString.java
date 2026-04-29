class NodeString {
    String data;              // PERUBAHAN 1: int -> String
    NodeString left, right;  // Pointer ke child kiri dan kanan (tipe sesuai class)

    NodeString(String data) { // PERUBAHAN 2: parameter int -> String
        this.data = data;
    }

    public void add(String data) {
        // PERUBAHAN 3: Ganti operator > dengan compareTo() > 0
        // compareTo() membandingkan String secara leksikografis (urutan alfabet)
        if (data.compareTo(this.data) > 0) {
            if (this.right == null) {
                this.right = new NodeString(data);
            } else this.right.add(data);
        }
        // PERUBAHAN 3: Ganti operator < dengan compareTo() < 0
        if (data.compareTo(this.data) < 0) {
            if (this.left == null) {
                this.left = new NodeString(data);
            } else this.left.add(data);
        }
    }
}