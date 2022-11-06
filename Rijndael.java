import java.util.*;
import javax.crypto.*;
import javax.crypto.spec.*;

public class Rijndael{
    public static void main(String args[]) throws Exception{
        Scanner sc = new Scanner(System.in);

        // take message to encrypt
        System.out.print("Enter message to encrypt: ");
        String msg = sc.nextLine();
        byte[] message = msg.getBytes();

        // take custom key for blowfish and prepare key
        System.out.print("Enter custom key: ");
        String key = sc.nextLine();
        byte[] keyData = key.getBytes();
        SecretKeySpec skeySpec = new SecretKeySpec(keyData, "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");

        // ENCRYPTION
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
        byte[] encrypted = cipher.doFinal(message);

        //DECRYPTION
        cipher.init(Cipher.DECRYPT_MODE, skeySpec);
        byte[] decrypted = cipher.doFinal(encrypted);
        String decryptedMsg = new String(decrypted);

        // OUTPUT
        System.out.println("Message: " + msg);
        System.out.println("Encrypted: " + encrypted);
        System.out.println("Decrypted: " + decryptedMsg);

    }

}

