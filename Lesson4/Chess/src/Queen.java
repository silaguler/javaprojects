public class Queen extends Piece {
    public Queen(Position position) {
        super(position);
    }
    boolean isValidMove(Position newPosition){
        if(!super.isValidMove(newPosition)){
            return false;
        }
        if(newPosition.getColumn() == this.position.getColumn() || newPosition.getRow() == this.position.getRow() ||
        (newPosition.getColumn() == this.position.getColumn() + 1 && newPosition.getRow() == this.position.getRow()+1)||
                (newPosition.getColumn() == this.position.getColumn() + 1 && newPosition.getRow() == this.position.getRow()-1) ||
        (newPosition.getColumn() == this.position.getColumn() - 1 && newPosition.getRow() == this.position.getRow()+1)||
                (newPosition.getColumn() == this.position.getColumn() - 1 && newPosition.getRow() == this.position.getRow()-1)){
            return true;
        }
        else{
            return false;
        }
    }
}
