import java.util.Scanner;
import java.util.Random;

public class matrisSifreleme {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Sifrelenecek metni giriniz: ");
        String text = scan.nextLine();
        String cipherText = "";
        int n = text.length();
        int ascii;
        int changed;
        /**************************************ŞİFRELEME**************************************/
        for(int i = 0; i < n; i++){
            ascii = (int) text.charAt(i);
            changed = ascii + 2;
            
            if(changed == 124){
                changed = 98;
                cipherText += Character.toString((char) changed);
            }
            else if(changed == 34) //boşluk geldiğini belirtme...
                cipherText += "#";
            else if(changed == 123){
                changed = 97;
                cipherText += Character.toString((char) changed);
            }
            else
                cipherText += Character.toString((char) changed);
        }
        System.out.println("Sifreli metin: " + cipherText);
        char [][] matris = new char[n][n];
        Random random = new Random();
        char[] harfler = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','x','w','v','y','z'};
        int ascii_2;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                ascii_2 = random.nextInt(26);
                if(i == j)
                    matris[i][j] = cipherText.charAt(i);
                else
                    matris[i][j] = harfler[ascii_2];
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.print((char) matris[i][j] + "    ");
            }
            System.out.println();
        }
        /*************************************DEŞİFRELEME*************************************/
        String tempCipherText = "";
        String normalText = "";
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i == j)
                    tempCipherText += matris[i][j];
            }
        }
        for(int i = 0; i < n; i++){
            ascii = (int) tempCipherText.charAt(i);
            changed = ascii - 2;
            if(changed == 95){
                changed = 121;
                normalText += Character.toString((char) changed);
            }
            else if(changed == 96){
                changed = 122;
                normalText += Character.toString((char) changed);
            }
            else if(tempCipherText.charAt(i) == '#')
                normalText += " ";
            else
                normalText += Character.toString((char) changed);
        }
        System.out.println("Duz metin: " + normalText);
    }
}
