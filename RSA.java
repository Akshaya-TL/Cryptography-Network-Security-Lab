import java.math.*;
import java.util.*;

class RSA{
    static BigInteger p, q, n, phi, d, e;
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        
        // get prime numbers of p, q
        System.out.print("Input a prime number, p = ");
        p = sc.nextBigInteger();
        
        System.out.print("Input another prime number, q = ");
        q = sc.nextBigInteger();
        
        // calculate n, phi
        n = p.multiply(q);
        phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));

        // calculate e, d
        e = generateE(phi);
        d = e.modInverse(phi);

        // print the public and private key pairs
        System.out.print("Encryption key pair = n: " + n + ", e = " + e);
        System.out.print("Decryption key pair = n: " + n + ", d = " + d);
    }

    public static BigInteger generateE(BigInteger phi){
        int y, gcdInt;
        BigInteger e, gcdBI;
        Random rnd = new Random();
        do{
            y = rnd.nextInt(phi.intValue() - 1);
            e = new BigInteger(Integer.toString(y));
            gcdBI = e.gcd(phi);
            gcdInt = gcdBI.intValue();

        }while(y <= 2 || gcdInt != 1);

        return e;
    }
}