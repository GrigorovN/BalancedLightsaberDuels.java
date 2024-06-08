import java.util.Stack;

public class BracketSequenceChecker {
    public static boolean isBalanced(String message) {
        Stack<Character> stack = new Stack<>();

        for (char character : message.toCharArray()) {
            if (character == '(' || character == '{') {
                stack.push(character);
            } else if (character == ')' || character == '}') {
                if (stack.isEmpty()) {
                    return false; // Closing bracket with no corresponding opening bracket
                }

                char top = stack.pop();
                if ((character == ')' && top != '(') || (character == '}' && top != '{')) {
                    return false; // Mismatched opening and closing brackets
                }
            }
        }

        return stack.isEmpty(); // Check if all brackets are balanced
    }

    public static void main(String[] args) {
        String message1 = "((!!)(({!!})))";
        String message2 = "()()(()())";
        String message3 = "((())";
        String message4 = "({(!!}))";

        System.out.println("Message 1 is " + (isBalanced(message1) ? "ok" : "not ok"));
        System.out.println("Message 2 is " + (isBalanced(message2) ? "ok" : "not ok"));
        System.out.println("Message 3 is " + (isBalanced(message3) ? "ok" : "not ok"));
        System.out.println("Message 4 is " + (isBalanced(message4) ? "ok" : "not ok"));
    }
}