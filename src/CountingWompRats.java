import java.util.Scanner;

public class CountingWompRats {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int h = scanner.nextInt();

        int totalRats = 0;

        for (int i = 1; i <=h ; i++) {

            totalRats +=n;
            n += m;
        }
        System.out.println(totalRats);
    }
}
