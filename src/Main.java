public class Main {
    public static void main(String[] args){

        BlockChain kvnCoin=new BlockChain("GENESIS");
        kvnCoin.addBlock("primer bloque");
        kvnCoin.addBlock("segundo bloque");

        for (int i = 0; i < kvnCoin.getSize()-1; i++) {
            System.out.println("Index: "+kvnCoin.getItem(i).index);
            System.out.println("Date: "+kvnCoin.getItem(i).date);
            System.out.println("Data: "+kvnCoin.getItem(i).data);
            System.out.println("Previous Hash: "+kvnCoin.getItem(i).previousHash);
            System.out.println("Hash: "+kvnCoin.getItem(i).hash);
            System.out.println();
        }
    }
}
