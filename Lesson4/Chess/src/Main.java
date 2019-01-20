public class Main {
    public static void main(String[] args){
        Position prevPosition = new Position(3,5);
        Position testPosition = new Position(3,10);
        Queen queen = new Queen(prevPosition);
        if(queen.isValidMove(testPosition)){
            System.out.println("Yes, I can move there.");
        }
        else{
            System.out.println("Nope, can't do!");
        }
    }
}
