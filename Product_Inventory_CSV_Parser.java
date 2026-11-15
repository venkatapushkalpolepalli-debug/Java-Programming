
import java.util.Scanner;

public class Product_Inventory_CSV_Parser {

    void parseInventoryRecord(String csvLine) {
        String[] fields = csvLine.split(",");

        if (fields.length != 3) {
            System.out.println("Invalid Record");
        } else {
            System.out.println("Product: " + fields[0] +
                    " | SKU: " + fields[1] +
                    " | Qty: " + fields[2]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String csvLine = sc.nextLine();

        Product_Inventory_CSV_Parser obj = new Product_Inventory_CSV_Parser();
        obj.parseInventoryRecord(csvLine);

        sc.close();
    }
}
