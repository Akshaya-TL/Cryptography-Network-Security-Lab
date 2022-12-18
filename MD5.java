import java.security.*;
import java.math.*;

public class MD5{
    public static void main(String[] a) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");

            String input = "";
            byte[] output = md.digest(input.getBytes());
            System.out.println();
            System.out.println("MD5(\""+input+"\") = " +bytesToHex(output));

            input = "abc";
            output = md.digest(input.getBytes());
            System.out.println();
            System.out.println("MD5(\""+input+"\") = " +bytesToHex(output));

            input = "abcdefghijklmnopqrstuvwxyz";
            output = md.digest(input.getBytes());
            System.out.println();
            System.out.println("MD5(\"" +input+"\") = " +bytesToHex(output));
        }
        catch (Exception e) {
            System.out.println("Exception: " +e);
        }
    }
    public static String bytesToHex(byte[] messageDigest) {
        //Convert byte array into signum representation
			BigInteger no = new BigInteger(1, messageDigest);

	    // Convert message digest into hex value
			String hashtext = no.toString(16);

	    // Add preceding 0s to make it 32 bit
			while (hashtext.length() < 32) {
				hashtext = "0" + hashtext;
			}
        return hashtext;
    }
}