import java.math.BigInteger;
import java.security.SecureRandom;

public class DiffieHellman{
    private final static SecureRandom random = new SecureRandom();
    private BigInteger agreedPrimeP;
    private BigInteger agreedPrimitiveRootG;
    private BigInteger publicKey;
    private BigInteger privateKey;

    // constructor
    public DiffieHellman(int keySize, BigInteger base, BigInteger modulus){
        agreedPrimeP = modulus;
        agreedPrimitiveRootG = base;
        privateKey = new BigInteger(keySize, random);
        publicKey = agreedPrimitiveRootG.modPow(privateKey, agreedPrimeP);
    }

    // get public key 
    BigInteger getPublicKey(){
        return publicKey;
    }

    // get shared key
    BigInteger getSharedKey(BigInteger receivedPublicKey){
        return receivedPublicKey.modPow(privateKey, agreedPrimeP);
    }

    public static void main(String args[]){

        // create 2 diffie-hellman key pairs
        DiffieHellman alice = new DiffieHellman(512, new BigInteger("23"), new BigInteger("19"));
        DiffieHellman bob = new DiffieHellman(512, new BigInteger("23"), new BigInteger("19"));

        // get public keys generated by Alice and Bob
        BigInteger alicePublicKey = alice.getPublicKey();
        BigInteger bobPublicKey = bob.getPublicKey();

        // generate shared secret key for each of them
        BigInteger aliceSharedSecretKey = alice.getSharedKey(bobPublicKey);
        BigInteger bobSharedSecretKey = bob.getSharedKey(alicePublicKey);

        // check if they have the same shared secret key
        if(aliceSharedSecretKey.equals(bobSharedSecretKey)){
            System.out.println("Shared secret keys match!\nShared Secret key = " + aliceSharedSecretKey);
        }
        else{
            System.out.println("Shared keys do not match");
        }
    }
}