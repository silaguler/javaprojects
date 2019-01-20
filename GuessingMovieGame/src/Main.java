import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Game game = new Game();
            System.out.print("You are guessing: ");
            System.out.println(game.getString());
            while (game.checkWrongLetter() != 10) {
                Scanner scanner = new Scanner(System.in);
                String line = "";
                System.out.print("Guess a letter: ");
                while((line=scanner.nextLine()).length()!=1)
                {
                    System.out.print("Enter only one letter: ");
                }
                char inputLetter = line.charAt(0);
                // print out the result after letter guess
                System.out.print("You are guessing: ");
                System.out.println(game.getString(inputLetter));
                System.out.println("You have guessed (" +  game.checkWrongLetter() + ") wrong letters");
                if (game.checkWrongLetter() != 10) {
                    System.out.println("You are guessing: ");
                }
                //System.out.println(game.checkLetter(inputLetter));
            }
            System.out.println("Game over");
        } catch (FileNotFoundException e) {
            System.out.println("File is not found");
        }




    }

}
