public class Main {
    public static void main(String[] args){

        BlockChain kvnCoin=new BlockChain("GENESIS","0");
        String[] dif= {"0","00","000","0000","00000","000000","0000000"};

        for (int i = 0; i < dif.length; i++) {
           
            //Assign to each new block a new difficulty
            kvnCoin.setDifficulty(dif[i]);

            //data could be a contract, a bill, etc.
            String data= "Bloque"+i;

            //mining block
            kvnCoin.addBlock(data);
        }

        //show all chain blocks info
        for (int i = 0; i < kvnCoin.getSize(); i++) {
            System.out.println();
            System.out.println("Index: "+kvnCoin.getItem(i).index);
            System.out.println("Date: "+kvnCoin.getItem(i).date);
            System.out.println("Data: "+kvnCoin.getItem(i).data);
            System.out.println("Previous Hash: "+kvnCoin.getItem(i).previousHash);
            System.out.println("Hash: "+kvnCoin.getItem(i).hash);
            System.out.println("Nonce: "+kvnCoin.getItem(i).nonce);
        }
    }
}
