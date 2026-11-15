import java.util.Arrays;
import java.util.Scanner;

public class Fantasy_League_Auto_Draft_Ranking_Engine implements Comparable<Fantasy_League_Auto_Draft_Ranking_Engine> {

    private String name;
    private int matchesPlayed;
    private double battingAverage;
    private boolean injured;

    public Fantasy_League_Auto_Draft_Ranking_Engine(String name, int matchesPlayed, double battingAverage, boolean injured) {
        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.battingAverage = battingAverage;
        this.injured = injured;
    }

    static boolean isDraftable(int matchesPlayed) {
        return matchesPlayed >= 10;
    }

    static boolean isDraftable(int matchesPlayed, boolean injured) {
        return matchesPlayed >= 5 && !injured;
    }

    @Override
    public int compareTo(Fantasy_League_Auto_Draft_Ranking_Engine other) {
        return Double.compare(other.battingAverage, this.battingAverage);
    }

    static String draftAndRank(Fantasy_League_Auto_Draft_Ranking_Engine[] players) {
        Fantasy_League_Auto_Draft_Ranking_Engine[] draftable = new Fantasy_League_Auto_Draft_Ranking_Engine[players.length];
        int count = 0;

        for (Fantasy_League_Auto_Draft_Ranking_Engine player : players) {
            if (isDraftable(player.matchesPlayed) || isDraftable(player.matchesPlayed, player.injured)) {
                draftable[count++] = player;
            }
        }

        draftable = Arrays.copyOf(draftable, count);
        Arrays.sort(draftable);

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < draftable.length; i++) {
            if (i > 0) {
                result.append(" | ");
            }

            result.append(i + 1).append(". ").append(draftable[i].name);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Fantasy_League_Auto_Draft_Ranking_Engine[] players =
                new Fantasy_League_Auto_Draft_Ranking_Engine[n];

        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int matchesPlayed = sc.nextInt();
            double battingAverage = sc.nextDouble();
            boolean injured = sc.nextBoolean();

            players[i] = new Fantasy_League_Auto_Draft_Ranking_Engine(
                    name, matchesPlayed, battingAverage, injured
            );
        }

        System.out.println(draftAndRank(players));

        sc.close();
    }
}
