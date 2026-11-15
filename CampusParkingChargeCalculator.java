import java.util.Scanner;

interface Vehicle {
    double calculateCharge(int hours);
}

class Bike implements Vehicle {
    public double calculateCharge(int hours) {
        return hours * 10;
    }
}

class Car implements Vehicle {
    public double calculateCharge(int hours) {
        return 30 + (hours - 1) * 20;
    }
}

class Truck implements Vehicle {
    public double calculateCharge(int hours) {
        return Math.max(100, hours * 50);
    }
}

public class CampusParkingChargeCalculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int hours = sc.nextInt();

            Vehicle vehicle = switch (type) {
                case "BIKE" -> new Bike();
                case "CAR" -> new Car();
                case "TRUCK" -> new Truck();
                default -> null;
            };

            if (vehicle != null) {
                double charge = vehicle.calculateCharge(hours);
                total += charge;

                System.out.printf("%s: %.2f%n", type, charge);
            }
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}
