import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JediArchivesSearch {
    public static void main(String[] args) {

        Scanner scanner =new Scanner(System.in);
        String[] input =scanner.nextLine().split(", ");
        String name = scanner.nextLine();

        List<String> archives = new ArrayList<>(List.of(input));

        checkForOccurrences(archives, name);
    }

    public static void checkForOccurrences(List<String> archives, String name) {
        int firstOccurrence = -1;
        int lastOccurrence = -1;

        for (int i = 0; i < archives.size(); i++) {
            if (archives.get(i).equals(name)){
                if (firstOccurrence == -1) {
                    firstOccurrence =i;
                }
                lastOccurrence=i;
            }
        }

        if (firstOccurrence == -1){
            System.out.println("Record not found");
        }
        else {
            System.out.println("First Occurrence: " + firstOccurrence);
            System.out.println("Last Occurrence: " + lastOccurrence);
        }
    }
}
