import java.util.ArrayList;

public class BlockChain {
    public ArrayList<Block> chain;
    String difficulty;

    public BlockChain(String genesis,String difficulty) {
        chain=new ArrayList<>();
        this.difficulty=difficulty;
        chain.add(createFirstBlock(genesis));
    }

    public Block createFirstBlock(String genesis) {
        Block firstBlock = new Block(0,genesis,"");
        return firstBlock;
    }

    public Block getLastBlock(){
        Block lastBlock = chain.get(chain.size()-1);
        return lastBlock;
    }

    public void addBlock(String data){
        Block previousBlock=getLastBlock();
        Block block=new Block(previousBlock.index+1,data,previousBlock.hash);
        block.mine(difficulty);
        System.out.println("MINADO!!! "+block.hash+" con nonce="+block.nonce);
        chain.add(block);
    }

    public int getSize(){
        return chain.size();
    }

    public Block getItem(int pos){
        return chain.get(pos);
    }
}
