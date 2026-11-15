import java.util.Scanner;

interface Room {
    double calculateBill();
}

class SingleRoom implements Room {
    int units;

    SingleRoom(int units) {
        this.units = units;
    }

    public double calculateBill() {
        return units * 8.0;
    }
}

class SharedRoom implements Room {
    int units;
    int occupants;

    SharedRoom(int units, int occupants) {
        this.units = units;
        this.occupants = occupants;
    }

    public double calculateBill() {
        return (units * 6.0) / occupants;
    }
}

class AcRoom implements Room {
    int units;

    AcRoom(int units) {
        this.units = units;
    }

    public double calculateBill() {
        return (units * 10.0) + 200;
    }
}

public class HostelElectricityBill {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();

            Room room;

            switch (type) {
                case "SINGLE":
                    room = new SingleRoom(sc.nextInt());
                    break;

                case "SHARED":
                    room = new SharedRoom(sc.nextInt(), sc.nextInt());
                    break;

                case "AC":
                    room = new AcRoom(sc.nextInt());
                    break;

                default:
                    continue;
            }

            double bill = room.calculateBill();
            System.out.printf("%s: %.2f%n", type, bill);

            total += bill;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}
