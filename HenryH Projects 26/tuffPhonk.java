import java.util.Scanner;
// BOOOIIIIIII WHAT DID YOU JUST SAY ABOUT PHONK
public class tuffPhonk {
    public static void main(String[] args) {
        Scanner scanny = new Scanner(System.in);
        System.out.println("tikki tikki or yara yara phonk");
        String input = scanny.nextLine();
        if (input.equals("tikki tikki phonk")){
            System.out.println("next time use tikki tikki phonk capiche?");
        }
        else if (input.equals("yara yara phonk")){
            System.out.println("boiiiiii what did you just say about tikki tikki phonk");
        }
        scanny.close();
    }
}