import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class StarfighterFormation {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> starfighters = new ArrayList<>();
        String[] input = scanner.nextLine().split(", ");

        for (String number : input) {
            starfighters.add(Integer.parseInt(number));
        }

        String command= "";
        while (!command.equals("end")){
            command = scanner.nextLine();
            performCommands(starfighters, command);
        }
    }

    public static void performCommands(ArrayList<Integer> starfighters, String command){
        String[] parts = command.split(" ");

        String action = parts[0].toLowerCase();

        switch (action) {
            case "add":
                if (parts.length == 2) {
                    int valueToAdd = Integer.parseInt(parts[1]);
                    starfighters.add(valueToAdd);
                    System.out.println(printArray(starfighters));
                }
                break;
            case "destroy":
                if (parts.length == 2) {
                    int indexToRemove = Integer.parseInt(parts[1]);
                    if (indexToRemove >= 0 && indexToRemove < starfighters.size()) {
                        starfighters.remove(indexToRemove);
                        System.out.println(printArray(starfighters));
                    }
                }
                break;
            case "swap":
                if (parts.length == 3) {
                    int index1 = Integer.parseInt(parts[1]);
                    int index2 = Integer.parseInt(parts[2]);
                    if (index1 >= 0 && index1 < starfighters.size() && index2 >= 0 && index2 < starfighters.size() && index2!=index1) {
                        Collections.swap(starfighters, index1, index2);
                        System.out.println(printArray(starfighters));
                    }
                }
                break;
            case "insert":
                if (parts.length == 3) {
                    int valueToInsert = Integer.parseInt(parts[1]);
                    int indexToInsert = Integer.parseInt(parts[2]);
                    if (indexToInsert >= 0 && indexToInsert <= starfighters.size()) {
                        starfighters.add(indexToInsert, valueToInsert);
                    }
                    System.out.println(printArray(starfighters));
                }
                break;
            case "center":
                if (!starfighters.isEmpty()) {
                    int middleIndex = starfighters.size() / 2;
                    if (starfighters.size() % 2 == 0) {

                        int middleValue1 = starfighters.get(middleIndex - 1);
                        int middleValue2 = starfighters.get(middleIndex);
                        System.out.println(middleValue1 + " " + middleValue2);
                    } else {

                        int middleValue = starfighters.get(middleIndex);
                        System.out.println(middleValue);
                    }
                }
                break;
            default:
                break;
        }
    }

    public static String printArray (ArrayList<Integer> arrayList) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i <arrayList.size() ; i++) {
            if (i == arrayList.size() - 1) {
                stringBuilder.append(arrayList.get(i));
            }
            else {
                stringBuilder.append(arrayList.get(i));
                stringBuilder.append(" ");
            }
        }
        return stringBuilder.toString();
    }
}
