import java.util.*;

import java.io.*;

public class CountSB {
	public static void main(String[] args){
		String md5= "8ec3921c9b9eb35a371332cd675ca830";
		String md5n= "8a18d6da56cecf677a1f8452174467b2";
		
	String sha="781bb141acb19c19ea8d13df0f146029ebd0350d194d5b31cb2ff5e2eb85313b"; 
	String shan= "896fc0ea300f5ef7dd450f7fa67867688e90ac874a5a549077cbf3c75fa38b40";
		
        int c1 = Compare(md5,md5n);
        int c2 = Compare(sha,shan);
        
		System.out.println("MD5: " + c1);
		System.out.println("SHA256: " + c2);
	}



     static int Compare(String s1, String s2) {
     
        int count = 0;

        for (int i = 0; i < s1.length(); i++)
        {
        long a = Character.digit(s1.charAt(i), 16);
        long b = Character.digit(s2.charAt(i), 16);
       
       //compareChars
        for(int j = 0; j < 4; j++){  
       //chartoBinary 
          if((0x01&(a>>j)) == (0x01&(b>>j))){
              count++;
          }
        }
    }

        return count;
    }

}
