import java.util.Scanner;

abstract class Student {
    String name;
    static final double TRANSPORT_FEE = 12000.0;

    Student(String name) {
        this.name = name;
    }

    abstract double calculateFee();
}

interface BusUser {
    double getTransportFee();
}

class DayScholar extends Student implements BusUser {
    DayScholar(String name) {
        super(name);
    }

    public double getTransportFee() {
        return TRANSPORT_FEE;
    }

    double calculateFee() {
        return 40000 + getTransportFee();
    }
}

class Hosteller extends Student {
    Hosteller(String name) {
        super(name);
    }

    double calculateFee() {
        return 40000 + 60000;
    }
}

class ScholarshipStudent extends Student implements BusUser {
    ScholarshipStudent(String name) {
        super(name);
    }

    public double getTransportFee() {
        return TRANSPORT_FEE;
    }

    double calculateFee() {
        return 20000 + getTransportFee();
    }
}

public class CollegeFeeCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double totalCollected = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();

            Student student;

            switch (type) {
                case "DAY_SCHOLAR":
                    student = new DayScholar(name);
                    break;

                case "HOSTELLER":
                    student = new Hosteller(name);
                    break;

                case "SCHOLAR":
                    student = new ScholarshipStudent(name);
                    break;

                default:
                    continue;
            }

            double fee = student.calculateFee();

            System.out.printf("%s: %.2f%n", student.name, fee);
            totalCollected += fee;
        }

        System.out.printf("Total Collected: %.2f%n", totalCollected);

        sc.close();
    }
}
