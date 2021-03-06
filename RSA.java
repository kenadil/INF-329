import java.math.BigInteger; 
import java.util.Random;
import java.io.*;
  
class RSA { 

    private BigInteger p; 
    private BigInteger q; 
    private BigInteger N; 
    private BigInteger phi; 
    private BigInteger e; 
    private BigInteger d; 
    private int bitlength = 1024; 
    private int blocksize = 256; //blocksize in byte 
     
    private Random r; 
     public RSA() { 
        r = new Random(); 
        p = BigInteger.probablePrime(bitlength, r); 
        q = BigInteger.probablePrime(bitlength, r); 
        N = p.multiply(q); 
           
        phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE)); 
        e = BigInteger.probablePrime(bitlength/2, r); 
         
        while (phi.gcd(e).compareTo(BigInteger.ONE) > 0 && e.compareTo(phi) < 0 ) { 
            e.add(BigInteger.ONE); 
        } 
 d = e.modInverse(phi);  
    } 
     
    public RSA(BigInteger e, BigInteger d, BigInteger N) { 
        this.e = e; 
        this.d = d; 
        this.N = N; 
    } 
   public BigInteger getE(){
	   return e;
   }
   public BigInteger getD(){
	   return d;
   }
   public BigInteger getN(){
	   return N;
   }
   public void setE(BigInteger e){
	   this.e = e;
   }
   public void setD(BigInteger d){
	   this.d = d;
   }
   public void setN(BigInteger N){
	   this.N = N;
   }
   public String bytesToString(byte[] encrypted) { 
        String test = ""; 
        for (byte b : encrypted) { 
            test += Byte.toString(b); 
        } 
        return test; 
   } 
     
 //Encrypt message
     public byte[] encrypt(byte[] message) {      
        return (new BigInteger(message)).modPow(e, N).toByteArray(); 
    } 
       
// Decrypt message
    public byte[] decrypt(byte[] message) { 
        return (new BigInteger(message)).modPow(d, N).toByteArray(); 
    }  
}