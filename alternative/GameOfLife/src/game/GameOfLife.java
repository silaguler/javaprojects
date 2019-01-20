package game;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class GameOfLife {
	private final int ROWMAX = 20;
	private final int COLMAX = 20;
	private Cell[][] grid = new Cell[ROWMAX][COLMAX];
	private TimerTask task;
	
	public GameOfLife() {
		
		Random random = new Random();

		// Creation of Grid where every cell in the grid is an instantiation of the Cell
		for (int rowIdx = 0; rowIdx < ROWMAX; rowIdx++) {
			for (int colIdx = 0; colIdx < COLMAX; colIdx++) {
				grid[rowIdx][colIdx] = new Cell(rowIdx, colIdx);
				grid[rowIdx][colIdx].setAlive(random.nextBoolean());

			}
		}

	}

	public void getNextGeneration() {
		//Apply Rules
		for (int rowIdx = 0; rowIdx < ROWMAX; rowIdx++) {
			for (int colIdx = 0; colIdx < COLMAX; colIdx++) {
				grid[rowIdx][colIdx].applyRules(grid[rowIdx][colIdx]);
			}
		}

		//Update State
		for (int rowIdx = 0; rowIdx < ROWMAX; rowIdx++) {
			for (int colIdx = 0; colIdx < COLMAX; colIdx++) {
				grid[rowIdx][colIdx].updateState(grid[rowIdx][colIdx]);
			}
		}
	}
	
	public void displayGeneration(){
		StdDraw.setXscale(0, COLMAX);
		StdDraw.setYscale(0, ROWMAX);
		StdDraw.enableDoubleBuffering();
		for (int rowIdx = 0; rowIdx < ROWMAX; rowIdx++) {
			for (int colIdx = 0; colIdx < COLMAX; colIdx++) {
				if(grid[rowIdx][colIdx].isAlive())
					StdDraw.setPenColor(StdDraw.BLACK);
				else
					StdDraw.setPenColor(StdDraw.WHITE);

				StdDraw.filledSquare(rowIdx + 0.5, colIdx + 0.5, 0.5);
			}
		}
		StdDraw.show();
	}

	public static void main(String args[]) {

		Cell[] toBeNeighbors = new Cell[8];
		GameOfLife gol = new GameOfLife();
//		Random random = new Random();
//
//		// Creation of Grid where every cell in the grid is an instantiation of the Cell
//		for (int rowIdx = 0; rowIdx < gol.ROWMAX; rowIdx++) {
//			for (int colIdx = 0; colIdx < gol.COLMAX; colIdx++) {
//				gol.grid[rowIdx][colIdx] = new Cell(rowIdx, colIdx);
//				gol.grid[rowIdx][colIdx].setAlive(random.nextBoolean());
//
//			}
//		}
//
		// Determine neighbors for every grid cell
		for (int rowIdx = 0; rowIdx < gol.ROWMAX; rowIdx++) {
			for (int colIdx = 0; colIdx < gol.COLMAX; colIdx++) {
				int toBeNeighborsIdx = 0;
				for (int neighborRowIdx = -1; neighborRowIdx < 2; neighborRowIdx++) {
					for (int neighborColIdx = -1; neighborColIdx < 2; neighborColIdx++) {
						// Wrap around for edge cells
						int neighborRow = (rowIdx + neighborRowIdx + gol.ROWMAX) % gol.ROWMAX;
						int neighborCol = (colIdx + neighborColIdx + gol.COLMAX) % gol.COLMAX;

						if (!((neighborRow == rowIdx) && (neighborCol == colIdx))) // Exclude the current cell while determining neighbors
						{
							toBeNeighbors[toBeNeighborsIdx] = gol.grid[neighborRow][neighborCol];
							toBeNeighborsIdx++;
						}

					}	
				}
				gol.grid[rowIdx][colIdx].setNeighbors(toBeNeighbors);
			}
		}
		
		//Timer Task
		gol.task = new TimerTask() {
			@Override
			public void run() {
				gol.displayGeneration(); // On tick display generation
				gol.getNextGeneration(); // Compute next generation
			}
		};
		
		new Timer().schedule(gol.task, 0, 500); //Schedule timer task to run every 500ms
	}
}
