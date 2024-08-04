 import java.security.*;
 import java.util.Scanner;
 
 
 public class CollisionR {  

    public static void main(String[] args) {
      
        System.out.print("Enter the message: ");
        Scanner scanner = new Scanner(System.in);
        String inputText = scanner.nextLine();
       
        CollisionR CollisionR = new CollisionR();
        byte[] Di = CollisionR.Digest(inputText);

        CollisionR.BruteForce(Di);
    }

    
        String digestAlgorithm = "SHA-256";
        String textEncoding = "UTF-8";
        byte[] digest;
        byte[] ComDi;   //Compare digest
      
        //get digest
        //code from SampleDigest
        public byte[] Digest(String inputText){
      
        try {
            MessageDigest md = MessageDigest.getInstance(digestAlgorithm);
            byte[] inputBytes = inputText.getBytes(textEncoding);
            md.update(inputBytes);
            digest = md.digest();
       
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Algorithm \"" + digestAlgorithm  + "\" is not available");
            System.exit(1);
        } catch (Exception e) {
            System.out.println("Exception "+e);
            System.exit(1);
        }
        return digest;
    }
    

      //print out the hash value
      public static void printDigest(byte[] digest) {
        for (int i=0; i<digest.length; i++)
            System.out.format("%02x", digest[i]&0xff);
        System.out.println();
    }



    public void BruteForce(byte[] digest) {

        int counter = 0;
        System.out.println("Brute forcing...");
        
        while(true) {
            
             counter++;       //increment counter
             String inputText = Long.valueOf(counter).toString(); 
             ComDi = Digest(inputText);   //For compare create a Compare digest (ComDi)

            //check if first 24 bits is equal or not! (3byte = 3*8 = 24bits )
            if(digest[0] == ComDi[0] &&
               digest[1] == ComDi[1] &&
               digest[2] == ComDi[2]) {
                
                System.out.println("Trials needed to find matching message digest: " + counter);
                System.out.println("Orginal digest using " + digestAlgorithm + " algorithm is: " );
                printDigest(digest);
                
                System.out.println("Matching digest using " + digestAlgorithm + " algorithm is: " );
                printDigest(ComDi);   //print
                return;
            }    
        }   
    }


}
