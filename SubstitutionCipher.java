import java.util.*;

public class SubstitutionCipher{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a word to encrypt: ");
        String word = sc.nextLine();
        String encryptedWord = "", decryptedWord = "";
        for(int i=0; i<word.length(); i++){
            int r = (int)(word.charAt(i)) - 97;
            r = (25-r) + 97;
            encryptedWord += (char)(r);
        }

        for(int i=0; i<word.length(); i++){
            int r = (int)(encryptedWord.charAt(i)) - 97;
            r = (25-r) + 97;
            decryptedWord += (char)(r);
        }
        System.out.println("Encrypted Word: " + encryptedWord);
        System.out.println("Decrypted Word: " + decryptedWord);
    }
}