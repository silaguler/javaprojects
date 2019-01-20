public class Piece {
    protected Position position;

    public Piece(Position position) {
        this.position = position;
    }
    boolean isValidMove(Position newPosition){
        if(newPosition.getColumn()>0 && newPosition.getColumn()<8 && newPosition.getRow()>0 && newPosition.getRow()<8){
            return true;
        }
        else
            return false;
    }
}
