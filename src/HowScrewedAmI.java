import java.util.InputMismatchException;
import java.util.Scanner;

public class HowScrewedAmI {
    private int midterm;
    private int webwork;
    private int expectedMark;
    Scanner input;

    public HowScrewedAmI() {
        input = new Scanner(System.in);
        run();
    }

    private void run() {
        while (true) {
            try {
                System.out.println("Please input your midterm mark 0-100:");
                midterm = input.nextInt();
                if (0 <= midterm && midterm <= 100) {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("That is not a integer!");
                input.next();
            } catch (Exception e) {
                e.printStackTrace();
                break;
            }
        }
        while (true) {
            try {
                System.out.println("Please input your webwork mark 0-100:");
                webwork = input.nextInt();
                if (0 <= webwork && webwork <= 100) {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("That is not a integer!");
                input.next();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        while (true) {
            System.out.println("Please input the mark you want 0-100:");
            try {
                expectedMark = input.nextInt();
                if (0 <= expectedMark && expectedMark <= 100) {
                    break;
                }

            } catch (InputMismatchException e) {
                System.out.println("That is not a integer!");
                input.next();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        double scheme1 = (expectedMark - webwork * 0.35 - midterm * 0.6) / 0.05;
        double scheme2 = (expectedMark - webwork * 0.30 - midterm * 0.4) / 0.3;

        double maxScheme1 = webwork * 0.35 + midterm * 0.6 + 0.05 * 100;
        double maxScheme2 = webwork * 0.30 + midterm * 0.4 + 0.3 * 100;

        double minScheme1 = webwork * 0.35 + midterm * 0.6;
        double minScheme2 = webwork * 0.30 + midterm * 0.4;

        if (scheme1 < 0 || scheme2 < 0) {
            System.out.println("You already have that mark by default. The maximum mark you can get is " + Math.max(maxScheme1, maxScheme2) +
                    ". The minimum mark you can get is " + Math.max(minScheme1, minScheme2));
        } else if (scheme1 > 100 && scheme2 > 100) {
            System.out.println("That mark is impossible to achieve. The maximum mark you can get is " + Math.max(maxScheme1, maxScheme2) +
                    ". The minimum mark you can get is " + Math.max(minScheme1, minScheme2));
        } else {
            System.out.println("You need a mark of " + Math.min(scheme1, scheme2) +
                    ". The maximum mark you can get is " + Math.max(maxScheme1, maxScheme2) +
                    ". The minimum mark you can get is " + Math.max(minScheme1, minScheme2));
        }

        if (minScheme1 < 50 && minScheme2 < 50) {
            double passScheme1 = (50 - webwork * 0.35 - midterm * 0.6) / 0.05;
            double passScheme2 = (50 - webwork * 0.30 - midterm * 0.4) / 0.3;
            if (maxScheme1 > 100 && maxScheme2 > 100) {
                System.out.println("Just give up. You can't even pass the course any more.");
            } else {
                System.out.println("You need " + Math.min(passScheme1,passScheme2) + "% minimum to pass the course at exactly 50%.");
            }
        }
    }
}
