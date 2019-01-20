import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Game game = new Game();
        int guess;
        int result;

        System.out.println("I have randomly chosen a number between [1, 100]");
        System.out.println("Try to guess it");
        System.out.println("You have " + game.getNumOfGuess() + " guess(es) left:");

        while(game.getNumOfGuess()>0){
            Scanner scanner = new Scanner(System.in);
            guess = scanner.nextInt();

            System.out.println("Your guess is "+guess);
            result = game.checkNumber(guess);
            if(result==0){
                System.out.println("CORRECT ... YOU WIN!");
                break;
            }
            else if(result==1){
                System.out.println("It is smaller than " + guess);
            }
            else{
                System.out.println("It is greater than " + guess);
            }
            System.out.println("You have " + game.getNumOfGuess() + " guess(es) left:");
        }
    }
}
