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

    public Block(int index, String data, String previousHash) {
        this.index = index;
        this.date = new Date();
        this.data = data;
        this.previousHash = previousHash;
        this.hash = getHash(data.getBytes(),"SHA-256");
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
}

