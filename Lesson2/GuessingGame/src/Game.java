import java.util.Random;
public class Game {

    private int randomNum;
    private int numOfGuess;
    // 0 if they are equal, -1 if guess is smaller, + 1 if guess is larger
    private int comparison;

    Game(){
        Random r = new Random();
        this.randomNum = r.nextInt((100 - 1) + 1) + 1;
        this.comparison = 0;
        this.numOfGuess = 10;
    }

    public int checkNumber(int num){
        if(this.randomNum > num){
            this.comparison = -1;
        }
        else if(this.randomNum == num){
            this.comparison = 0;
        }
        else {
            this.comparison = 1;
        }
        this.numOfGuess --;
        return this.comparison;
    }

    public int getNumOfGuess(){
        return this.numOfGuess;
    }

}
