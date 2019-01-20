package game;

public class Cell {
	private int row;
	private int col;
	private boolean isAlive;
	private boolean willBeAlive;
	private Cell[] neighbors;

	public boolean isAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	public boolean isWillBeAlive() {
		return willBeAlive;
	}

	public void setWillBeAlive(boolean willBeAlive) {
		this.willBeAlive = willBeAlive;
	}
	
	public Cell[] getNeighbors() {
		return neighbors;
	}

	public void setNeighbors(Cell[] neighbors) {
		//Copy values of the neighbors
		for (int neighborIdx = 0; neighborIdx < 8; neighborIdx++) {
			this.neighbors[neighborIdx] = neighbors[neighborIdx];
		}
	}

	public Cell(int row, int col) {
		this.row = row;
		this.col = col;
		isAlive = false; // Attribute for current generation
		willBeAlive = false; // Attribute for next generation
		neighbors = new Cell[8];

	}

	/**
	 * Applies Game of life rules and sets the boolean willBeAlive
	 * 
	 * @param cell Cell object
	 */
	public void applyRules(Cell cell) {
		int sum = 0;
		for (Cell neighbor : cell.neighbors) {
			if (neighbor.isAlive == true)
				sum++;
		}

		if (cell.isAlive && (sum < 2)) { // Underpopulation
			cell.willBeAlive = false;
		} else if (cell.isAlive && (sum > 3)) { // Overpopulation
			cell.willBeAlive = false;
		} else if ((cell.isAlive == false) && (sum != 3)) { // Reproduction
			cell.willBeAlive = false;
		} else { // Lives on to next generation
			cell.willBeAlive = true;
		}
	}


	/**
	 * Updates the current state of the cell (isAlive)
	 * 
	 * @param cell Cell object
	 */
	public void updateState(Cell cell) {
		cell.isAlive = cell.willBeAlive;
	}
}
