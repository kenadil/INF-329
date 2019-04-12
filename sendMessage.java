import java.math.BigInteger; 
import java.util.*;
import java.io.*;
public class sendMessage{
	public static void main(String[] args)throws IOException{
		
        DataInputStream in=new DataInputStream(System.in);
		PrintWriter writer = new PrintWriter("Alice.txt", "UTF-8");
		RSA rsa = new RSA(); 
		writer.println(rsa.getE());
		writer.println(rsa.getD());
		writer.println(rsa.getN());
        String teststring ;
        System.out.println("Enter the plain text:");
        teststring=in.readLine();
		writer.close();
        // encrypt 
        byte[] encrypted = rsa.encrypt(teststring.getBytes()); 
		writer = new PrintWriter("Alice_pub.txt", "UTF-8");	
 
	writer.println(Arrays.toString(encrypted).replaceAll("[\\[\\](){}]", ""));		
        writer.println(rsa.bytesToString(encrypted));
         writer.close();
        // decrypt 
        /*byte[] decrypted = rsa.decrypt(encrypted);       
        System.out.println("Decrypted String in Bytes: " +  bytesToString(decrypted)); 
         
        System.out.println("Decrypted String: " + new String(decrypted)); */
         
    } 
}