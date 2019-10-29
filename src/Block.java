import com.sun.org.apache.xml.internal.security.algorithms.MessageDigestAlgorithm;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import javax.xml.bind.DatatypeConverter;

public class Block {
    int index;
    Date date;
    String data;
    String previousHash;
    String hash;
    int nonce;

    String hashRequirements;

    public Block(int index, String data, String previousHash) {
        this.index = index;
        this.data = data;
        this.date = new Date();
        this.previousHash = previousHash;
        this.nonce=0;
        hashRequirements = index+data+date+previousHash+nonce;
        this.hash = getHash(hashRequirements.getBytes(),"SHA-256");
    }

    public static String getHash(byte[] inputBytes, String algorithm){
        String hashValue = "";
        try{
            MessageDigest messageDigest = MessageDigest.getInstance((algorithm));
            messageDigest.update(inputBytes);
            byte[] digestedBytes = messageDigest.digest();
            hashValue=DatatypeConverter.printHexBinary(digestedBytes).toLowerCase();
        }catch (Exception e){
            System.out.println("error "+ e);
        }
        return hashValue;
    }

    public void mine(String difficulty){
        while(!this.hash.startsWith(difficulty)){
            this.nonce++;
            hashRequirements = index+data+date+previousHash+nonce;
            this.hash=getHash(hashRequirements.getBytes(),"SHA-256");
        }
    }
}

