
import java.util.Scanner;

public class Word_Reversal_Encoder {

    String reverseEachWord(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            StringBuilder reverse = new StringBuilder(words[i]);
            result.append(reverse.reverse());

            if (i < words.length - 1) {
                result.append(" ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String sentence = sc.nextLine();

        Word_Reversal_Encoder obj = new Word_Reversal_Encoder();
        System.out.println(obj.reverseEachWord(sentence));

        sc.close();
    }
}
