
import java.util.Scanner;

public class GalacticSenatorsVotes {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String [] votes = scanner.nextLine().split(", ");

        int counterYes = 0;
        int counterNo = 0;
        int counterAbstain = 0;

        for (String vote : votes) {
            if (vote.equals("Yes")) {
                counterYes++;
            }
            if (vote.equals("No")) {
                counterNo++;
            }
            if (vote.equals("Abstain")) {
                counterAbstain++;
            }
        }

        printVotingResults(counterYes, counterNo, counterAbstain);

    }

    public static  void printVotingResults(int counterYes, int counterNo, int counterAbstain){
        if (counterYes > counterNo) {
            System.out.println("Yes");
        }
        else if (counterNo > counterYes) {
            System.out.println("No");
        } else if (counterYes==0 && counterNo==0 && counterAbstain!=0) {
            System.out.println("Abstain");
        } else  if (counterYes == counterNo) {
            System.out.println("Tie");
        }

    }

}
