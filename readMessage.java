import java.math.BigInteger; 
import java.util.Random;
import java.util.Scanner;
import java.io.*;
public class readMessage{
	public static void main(String[] args)throws IOException{
		Scanner scan = new Scanner(new File("Alice.txt"));
		BigInteger intLine;
		RSA rsa = new RSA(); 
		rsa.setE(new BigInteger(scan.nextLine()));
		rsa.setD(new BigInteger(scan.nextLine()));
		rsa.setN(new BigInteger(scan.nextLine()));
        // decrypt 
		scan = new Scanner(new File("Alice_pub.txt"));
		String text = scan.nextLine();
		String[] teststring = text.split(", ");
		byte[] decrypted = new byte[teststring.length];
		for (int i = 0; i<teststring.length; i++){
			decrypted[i] = (byte)Integer.parseInt(teststring[i]);
		}
		decrypted = rsa.decrypt(decrypted);
        System.out.println("Decrypted String: " + new String(decrypted)); 
        /*byte[] decrypted = rsa.decrypt(encrypted);       
        System.out.println("Decrypted String in Bytes: " +  bytesToString(decrypted)); 
         
        System.out.println("Decrypted String: " + new String(decrypted)); */
         
    } 
}