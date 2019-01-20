import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;

public class Game {

    private Movie[] movies;
    private Movie theMovie;
    private int numLetters;
    private int numWrong;
    private String guessed = new String();

    Game() throws FileNotFoundException {
        File file = new File("movies.txt");
        Scanner scanner = new Scanner(file);
        this.movies = new Movie[25];
        int idx = 0;
        while(scanner.hasNextLine()){
            movies[idx] = new Movie(scanner.nextLine());
            idx ++;
        }
        // random selection of a movie
        Random r = new Random();
        int index = r.nextInt((25 - 1) + 1) + 1;
        theMovie = movies[index];
        System.out.println(theMovie.getName());

        this.numWrong = 0;
        this.numLetters = theMovie.getName().length();
        this.guessed = "";
    }

    public int getNumofLetters(){
        return this.numLetters;
    }

    public int checkWrongLetter(){
        return this.numWrong;
    }

    private List checkLetter(char inputLetter){
        String str = theMovie.getName();
        int idx = str.indexOf(inputLetter);
        List idx_list = new ArrayList();
        while(idx>=0){
            idx_list.add(idx);
            str = str.substring(0, idx) + str.substring(idx+1);
            idx = str.indexOf(inputLetter);
        }
        return idx_list;

    }

    public String getString(){
        for(int i = 0; i< this.numLetters; i++){
            this.guessed += '_';
        }
        return this.guessed;
    }
    // TO-DO: I need to write a method for returning the string itself
    public String getString(char inputLetter){

        List idx_list = checkLetter(inputLetter);
        if(idx_list.size() == 0 ){
            this.numWrong ++;
        }
        else{
            for(int i = 0; i< this.numLetters; i++){
                if(idx_list.contains(i)){
                    char[] guessChars = guessed.toCharArray();
                    guessChars[i] = inputLetter;
                    this.guessed = String.valueOf(guessChars);
                }
            }
        }
        return this.guessed;
    }


}
