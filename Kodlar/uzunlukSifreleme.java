import java.util.Scanner;
import java.util.Random;

public class uzunlukSifreleme {
	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
		
		//ŞİFRELEME...
		System.out.print("metin giriniz: ");
		String text = scan.next();
		int length = text.length();
		String cipher = "";
		char[] harfler = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','x','w','v','y','z'};
		Random rnd = new Random();
		int ascii;
		int changed;
		for(int i = 0; i < text.length(); i++) {
			ascii = (int) text.charAt(i);
			changed = ascii + length;
			int rndLetter = rnd.nextInt(26);
			int rndLetter2 = rnd.nextInt(26);
			if(changed == 127) {
				changed = 33;
				cipher += Character.toString((char) changed) + harfler[rndLetter] + harfler[rndLetter2];
			}else if(127 < changed) {
				changed = 33 + (changed - 127);
				cipher += Character.toString((char) changed) + harfler[rndLetter] + harfler[rndLetter2];
			}else
				cipher += Character.toString((char) changed) + harfler[rndLetter] + harfler[rndLetter2];
		}
		System.out.println(cipher);
		//DEŞİFRELEME...
		System.out.print("sifreli metni giriniz: ");
		String encryptedText = scan.next();
		int newLength =encryptedText.length() - 2 * text.length();
		String realText = "";
		for(int i = 0; i < encryptedText.length(); i++) {
			if(i % 3 == 0) {
				ascii = (int) encryptedText.charAt(i);
				changed = ascii - newLength;
				if(changed == 33) {
					changed = 97;
					realText += Character.toString((char) changed);	
				}else if(changed < 33) {
					changed = 127 - (33 - changed);
					realText += Character.toString((char) changed); 
				}else
					realText += Character.toString((char) changed);
			}
			
		}
		System.out.println(realText);
	}
}
