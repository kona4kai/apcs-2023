package unit11.dice;
import java.util.Scanner;

public class beatThat {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int p1Score = 0, p2Score = 0;
        String p1Name = "Player1";
        String p2Name = "Player2";

        while(!(p1Score >= 5 || p2Score >= 5)) {
            int winner = startRound(p1Name, p2Name, scan);
            if(winner == 1) {
                p1Score++;
            } else if(winner == 2) {
                p2Score++;
            }

            if(!(p1Score >= 5 || p2Score >= 5)) {
                showScore(p1Name, p2Name, p1Score, p2Score);
                System.out.println(" BEAT THAT!\n");
            }
        }

        if(p1Score > p2Score) {
            System.out.println(" " + p1Name.toUpperCase() + "IS THE WINNER!!! BETTER LUCK NEXT TIME " + p2Name.toUpperCase() + "!");
        } else {
            System.out.println(" " + p2Name.toUpperCase() + " IS THE WINNER!!! BETTER LUCK NEXT TIME " + p1Name.toUpperCase() + "!");
        }

        scan.close();
    }
    
    public static void showScore(String p1Name, String p2Name, int p1Score, int p2Score) {
        if(p1Score == p2Score) {
                System.out.print(" Current score is tied " + p1Score + " - " + p2Score + ".");
            } else if(p1Score > p2Score) {
                System.out.print(" Current score " + p1Score + " - " + p2Score + " in favor of " + p1Name + ".");
            } else {
                System.out.print(" Current score " + p1Score + " - " + p2Score + " in favor of " + p2Name + ".");
            }
    }

    public static int startRound(String player1Name, String player2Name, Scanner scan) {
        int p1 = takeTurn(player1Name, scan);
        int p2 = takeTurn(player2Name, scan);
        if(p1 == p2) {
            System.out.println("TIE GAME! NO POINTS AWARDED.");
            return 0;
        } else if(p1 > p2) {
            System.out.print(player1Name.toUpperCase() + " WINS THE ROUND!");
            return 1;
        } else {
            System.out.print(player2Name.toUpperCase() + " WINS THE ROUND!");
            return 2;
        }
    }

    public static int takeTurn(String playerName, Scanner scan) {
        System.out.print("It's " + playerName + "'s turn! Click the terminal and press enter to roll.");
        scan.nextLine();

        int first = roll(6);
        int second = roll(6);
        int total = first*10 + second;
        System.out.println("\t" + playerName + " rolled a " + first + " and a " + second + " totaling " + total);

        return total;
    }

    public static int roll(int sides) {
        return (int) (Math.random()*sides) +1;
    }
}
