public class Shopipedia {
    public static void main(String[] args) {

        ShopiPay shopiCard = new ShopiPay();

        Customer miki = new Customer(shopiCard);
        miki.deposit(10000);
        miki.pay(2000);
        miki.pay(3000);
        miki.deposit(1000);
        miki.pay(7000);

        System.out.println("------------------");

        Opo opoCard = new Opo();

        Customer dono = new Customer(opoCard);
        dono.deposit(10000);
        dono.pay(2000);
        dono.pay(3000);
        dono.deposit(1000);
        dono.pay(7000);
        
        /*
        Soal no 4
        membuat kode anoniymous untuk menggantikan file class Kris
        */
        Emoney krisCard = new Emoney(){
            {this.name = "Kris";}
            @Override 
            public void topUp(double amount){
                System.out.println("Top op: " + amount);
                this.balance += (amount + (0.05 * amount));
                this.balance();
            }
    
            @Override
            public void pay(double amount) {
                double amountToPay = amount - (0.03 * amount);
                if (this.balance > amountToPay) {
                    this.balance -= amountToPay;
                    System.out.print("Pay " + amount);
                    System.out.println(" using " + this.name);
                } else System.out.println("Not enough balance.");
                this.balance();
            }
        };

        Customer sabrina = new Customer (krisCard);
        sabrina.deposit(10000);
        sabrina.pay(2000);
        sabrina.pay(3000);
        sabrina.deposit(1000);
        sabrina.pay(7000);

        /*
        soal no.3b bagian 1. untuk membuat objek baru dalam class
        Kris dan menampilkan atributnya
        */
        /* 
        Kris krisCard = new Kris();

        Customer sabrina = new Customer (krisCard);
        sabrina.deposit(10000);
        sabrina.pay(2000);
        sabrina.pay(3000);
        sabrina.deposit(1000);
        sabrina.pay(7000);
        */
    }
}