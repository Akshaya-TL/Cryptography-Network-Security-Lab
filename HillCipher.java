import java.util.*;

public class HillCipher{
    public static void main(String args[]){
        // input the key - 3x3
        Scanner sc = new Scanner(System.in);
        int [][]keyMatrix = new int[3][3];
        for(int i = 0; i<3; i++){
            for(int j=0; j<3; j++){
                System.out.print("Enter value at " + i + ", " + j + ": ");
                keyMatrix[i][j] = sc.nextInt();
            }
        }

        // input the string
        String word = "";
        System.out.print("Enter string of size 3 to encrypt: ");
        sc.nextLine();
        word = sc.nextLine();
        System.out.println(word);
        // convert string to vector of size 3x1
        int [][]text = new int[3][1];
        for(int i=0; i<3; i++){
            text[i][0] = (int)(word.charAt(i))-97;
        }

        // multiply key with above vector with %26
        int[][] encryptedTextN = new int[3][1];
        for(int i=0; i<3; i++){
            encryptedTextN[i][0] = (keyMatrix[i][0]*text[0][0] + keyMatrix[i][1]*text[1][0] + keyMatrix[i][2]*text[2][0])%26;
        }

        // convert to text - encrypted message
        String encryptedText = "";
        for(int i=0; i<3; i++){
            encryptedText += (char)(encryptedTextN[i][0] + 97);
        }
        System.out.println("Encrypted Text: " + encryptedText);

        // find inverse of matrix
        int determinant;
        determinant = (keyMatrix[0][0]*(keyMatrix[1][1]*keyMatrix[2][2] - keyMatrix[1][2]*keyMatrix[2][1])) -
                    - (keyMatrix[0][1]*(keyMatrix[1][0]*keyMatrix[2][2] - keyMatrix[1][2]*keyMatrix[2][1]))
                    + (keyMatrix[0][0]*(keyMatrix[1][1]*keyMatrix[2][2] - keyMatrix[1][2]*keyMatrix[2][1]));
          
        int[][] helperMatrix = new int[5][5];          
        int[][] inverseMatrix = new int[3][3];
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                helperMatrix[i][j] = keyMatrix[i][j];
            }
        }
        helperMatrix[0][3] = keyMatrix[0][0];
        helperMatrix[1][3] = keyMatrix[0][1];
        helperMatrix[2][3] = keyMatrix[0][2];
        helperMatrix[0][4] = keyMatrix[1][0];
        helperMatrix[1][4] = keyMatrix[1][1];
        helperMatrix[2][4] = keyMatrix[1][2];
        
        for(int i=3; i<5; i++){
            for(int j=0; j<5; j++){
                helperMatrix[i][j] = helperMatrix[i-3][j];
            }
        }

        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                inverseMatrix[i][j] = helperMatrix[j+1][i]*helperMatrix[j+2][i+1]
                                    - helperMatrix[j+1][i+1]*helperMatrix[j+2][i];
            }
        }

        // multiply it with encrypted numeric vector %26
        int[][] resultMatrix = new int[3][1];
        for(int i=0; i<3; i++){
            resultMatrix[i][0] = ((inverseMatrix[i][0]*encryptedTextN[0][0] 
                               + inverseMatrix[i][1]*encryptedTextN[1][0] 
                               + inverseMatrix[i][2]*encryptedTextN[2][0])/determinant)%26;
        }

        // add 97 this becomes Decrypted text
        String decryptedText = "";
        for(int i=0; i<3; i++){
            decryptedText += (char)(resultMatrix[i][0] + 97);
        }
        System.out.println("Decrypted Text: " + decryptedText);
    }
}
