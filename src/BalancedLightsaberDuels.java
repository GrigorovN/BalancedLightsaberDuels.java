import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedLightsaberDuels {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        String result = isLegendary(input)? "Legendary" : "Not Legendary";
        System.out.println(result);
    }

    public static boolean isLegendary (String input){

        ArrayDeque<Character> fight = new ArrayDeque<>();
        boolean isCountered = isCounteredPowerStrike(input);

        for (char character : input.toCharArray()) {
            if (character == '(' || character == '{' ) {
                fight.push(character);
            } else if (character == ')' || character == '}') {
                if (fight.isEmpty()) {
                    return false;
                }
                char top = fight.pop();

                if ((character == ')' && top != '(') || (character == '}' && top != '{')) {
                    return false;
                }
            }
        }
        return isCountered && fight.isEmpty();
    }

    public static boolean isCounteredPowerStrike (String input){
        int consecutivePowerStrikes = 0;
        boolean hasPowerStrikes = false;

        for (char character : input.toCharArray()) {
            if (character == '!') {
                consecutivePowerStrikes++;
                hasPowerStrikes = true;
            } else {
                consecutivePowerStrikes = 0;
            }

            if (consecutivePowerStrikes >= 2) {
                return true;
            }
        }
        return !hasPowerStrikes;
    }
    }

