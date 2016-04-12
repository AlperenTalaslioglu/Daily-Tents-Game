package dailyTents;

import java.util.Random;

public class Board {
	private Item[][] board;
	private boolean isGameCreated = false;

	public Board(int dimension) {
		if (dimension <= 0) {throw new IllegalArgumentException();}
		// Board size is 1 bigger than dimension to store numbers
		// Numbers tell us how many tents there are in the Rows and Columns
		this.board = new Item[dimension + 1][dimension + 1];
		createModel();
	}

	public Board() {
		this(8); // default size 8
	}

	/*
	 * 
	 * My Algorithm : The algorithm is starting with placing tents validly. Then
	 * add trees to these tents.
	 * 
	 * Steps: 1 - Random and validly place tents to empty board until completion
	 * of placement of all tents 
     * Step 2 - After placement of tents, add trees to
	 * all of these trees one by one
	 * 
	 * 
	 */
	private void createModel() {
		initializeBoard();
		placeRandomlyTentsOnBoard();
		placeTreesOnBoard();
		generateTentCountsCells();
		isGameCreated = true;
	}

	private void placeRandomlyTentsOnBoard() {
		Random rn = new Random();
		for (int i = 1; i < board.length; i++) {
			int x = rn.nextInt(board.length - 1) + 1;
			int y = rn.nextInt(board.length - 1) + 1;
			if (isCellEmpty(x, y) && !hasAdjacentTent(x, y)) {
				placeItem(new Tent(), x, y);
			} else {
				i--; // to randomize this tent again and again
			}
		}
	}

	private void placeTreesOnBoard() {
		for (int i = 1; i < board.length; i++) {
			for (int j = 1; j < board[0].length; j++) {
				Coordinate currentCoord = new Coordinate(i, j);
				if (!currentCoord.toString().equals(getPlacableTreeCoordOfTent(i, j).toString())) {
					Tree tree = new Tree();
					// Place tree on board
					placeItem(tree, i, j);
					// Set tent for this tree
					((Tent) getItem(getPlacableTreeCoordOfTent(i, j).getX(), getPlacableTreeCoordOfTent(i, j).getY())).setTreeToTent(tree);
				}
			}
		}
	}

	private Coordinate getPlacableTreeCoordOfTent(int x, int y) {
		// LEFT CHECK
		if (isInsideBoard((x), (y - 1))) {
			if (getItem((x), (y - 1)) instanceof Tent) {
				// Tent formerly have to be free to set a tree
				if (((Tent) getItem((x), (y - 1))).hasNotTree()) {return new Coordinate((x), (y - 1));}
			}
		}
		// TOP CHECK
		if (isInsideBoard((x - 1), (y))) {
			if (getItem((x - 1), (y)) instanceof Tent) {
				// Tent formerly have to be free to set a tree
				if (((Tent) getItem((x - 1), (y))).hasNotTree()) {return new Coordinate((x - 1), (y));}
			}
		}
		// RIGHT CHECK
		if (isInsideBoard((x), (y + 1))) {
			if (getItem((x), (y + 1)) instanceof Tent) {
				// Tent formerly have to be free to set a tree
				if (((Tent) getItem((x), (y + 1))).hasNotTree()) {return new Coordinate((x), (y + 1));}
			}
		}
		// BOTTOM CHECK
		if (isInsideBoard((x + 1), (y))) {
			if (getItem((x + 1), (y)) instanceof Tent) {
				// Tent formerly have to be free to set a tree
				if (((Tent) getItem((x + 1), (y))).hasNotTree()) {return new Coordinate((x + 1), (y));}
			}
		}
		return new Coordinate(x, y);
	}

	private void generateTentCountsCells() {
		// Vertically count
		generateVerticallyTentCounts();
		// Horizontally count
		generateHorizontallyTentCounts();
		// top left corner of board
		getItem(0, 0).setType(" ");
	}

	private void generateHorizontallyTentCounts() {
		for (int x = 1; x < board.length; x++) {
			int counter = 0;
			for (int y = 1; y < board[0].length; y++) {
				if (getItem(x, y).toString().equals("T")) {counter++;}
			}
			getItem(x, 0).setType("" + counter);
		}
	}

	private void generateVerticallyTentCounts() {
		for (int x = 1; x < board.length; x++) {
			int counter = 0;
			for (int y = 1; y < board[0].length; y++) {
				if (getItem(y, x).toString().equals("T")) {counter++;}
			}
			getItem(0, x).setType("" + counter);
		}
	}

	/*
	 * To check tent has an adjacent tent for valid tent placements Method is
	 * checking all directions of current coordinate for adjacency check
	 * 
	 */
	public boolean hasAdjacentTent(int x, int y) {
		int[][] directions = { { -1, -1, }, { -1, 0, }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };
		for (int i = 0; i < directions.length; i++) {
			int xCoord = x + directions[i][0];
			int yCoord = y + directions[i][1];
			if (isInsideBoard(xCoord, yCoord)) {
				if (getItem(xCoord, yCoord).type.equals("T")) {return true;}
			}
		}
		return false;
	}

	private boolean isInsideBoard(int x, int y) {
		boolean horizontalCheck = (x >= 1 && x < board[0].length);
		boolean verticalCheck = (y >= 1 && y < board.length);
		return horizontalCheck && verticalCheck;
	}

	private void initializeBoard() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				// initially empty items placed
				placeItem(new Item(), i, j);
			}
		}
	}

	public Item[][] getBoard() {
		return board;
	}

	public void placeItem(Item item, int x, int y) {
		board[x][y] = item;
	}

	public Item getItem(int x, int y) {
		return board[x][y];
	}

	public boolean isCellEmpty(int x, int y) {
		return board[x][y].type.equals("X");
	}

	public int getBoardDimension() {
		return board.length;
	}
}