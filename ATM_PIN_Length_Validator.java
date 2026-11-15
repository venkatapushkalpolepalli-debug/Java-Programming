
import java.util.Scanner;

public class ATM_PIN_Length_Validator {

    void checkPinLength(String pin) {
        if (pin.length() != 4) {
            System.out.println("Invalid PIN — must be exactly 4 digits.");
        } else {
            System.out.println("PIN length OK.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String pin = sc.nextLine();

        ATM_PIN_Length_Validator obj = new ATM_PIN_Length_Validator();
        obj.checkPinLength(pin);

        sc.close();
    }
}
