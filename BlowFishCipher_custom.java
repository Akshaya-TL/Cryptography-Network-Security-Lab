import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.swing.JOptionPane;
public class BlowFishCipher_custom {
    public static void main(String[] args) throws Exception {

        // get message to encrypt
        String inputText = JOptionPane.showInputDialog("Input your message:");
        byte[] msgToEncrypt = inputText.getBytes();

        // generate secret key using java key tool
        KeyGenerator keygenerator = KeyGenerator.getInstance("Blowfish");
        SecretKey secretkey = keygenerator.generateKey();

        // ENCRYPTION
        Cipher cipher = Cipher.getInstance("Blowfish");
        cipher.init(Cipher.ENCRYPT_MODE, secretkey);
        byte[] encrypted = cipher.doFinal(msgToEncrypt);

        // DECRYPTION
        cipher.init(Cipher.DECRYPT_MODE, secretkey);
        byte[] decrypted = cipher.doFinal(encrypted);

        // OUTPUT
        JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"\nEncrypted text: " + new String(encrypted) + "\n" + "\nDecrypted text: " + new String(decrypted));
        System.exit(0);
} }