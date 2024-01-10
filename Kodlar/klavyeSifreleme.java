import java.util.Scanner;
import java.util.Random;

import javax.swing.text.StyledEditorKit;
public class klavyeSifreleme {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Şifrelenecek metni giriniz: ");
        String text = scan.nextLine();
        //ŞİFRELEME...
        char[] q = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        char[] f = {'u','ç','v','e','ğ','a','ü','t','ş','k','m','l','s','z','h','p','f','ı','i','o','r','c','g','ö','d','j'};
       
       String cipherText = "";
        Random rnd = new Random();
        for(int i = 0; i < text.length(); i++){
            int index = rnd.nextInt(26);
            cipherText += q[index];
        }
        for(int i = 0; i < text.length(); i++){
            if(text.charAt(i) == ' ')
                cipherText += "x";
            else
                cipherText += Character.toString(f[returnIndex(q, text.charAt(i))]);  
        }
        for(int i = 0; i < text.length(); i++){
            int index = rnd.nextInt(26);
            cipherText += q[index];
        }
        System.out.println(cipherText);
        //DEŞİFRELEME...
        System.out.print("Deşifrelenecek metni giriniz: ");
        String sifreliMetin = scan.nextLine();      //mueşı
        String realCipherText = sifreliMetin.substring(text.length(),text.length() * 2);
        String realText = "";
        for(int i = 0; i < realCipherText.length(); i++){
            if(realCipherText.charAt(i) == 'x')
                realText += " ";
            else
                realText += Character.toString(q[returnIndex(f,realCipherText.charAt(i))]);
            
        }
        System.out.println(realText);
        





    }
    public static int returnIndex(char[] dizi, char harf){
        for(int i = 0; i < dizi.length; i++){
            if(dizi[i] == harf){
                return i;
            }
        }
        return -1;
    }
    
}
