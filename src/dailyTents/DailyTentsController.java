package dailyTents;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class DailyTentsController {
	private Board gameBoard;
	private int gameSize;
	private int foundTentCount = 0;
	private int stepCount = 0;
	private MainFrame view;

	public DailyTentsController(Board gameBoard) {
		this.gameBoard = gameBoard;
		this.gameSize = gameBoard.getBoardDimension();
	}

	public void startGame() {
		this.view = new MainFrame(gameBoard, this);
	}

	public void getBoardSizeSelection(int gameSize) {
		this.gameSize = gameSize + 1;
	}

	public int getBoardSize() {
		return gameSize;
	}

	public void startNewGame() {
		BoardView boardView = clearPreviousBoard();		
		createNewBoard(boardView);
	}

	private void createNewBoard(BoardView boardView) {
		gameBoard = new Board(gameSize - 1);
		boardView.setBoard(gameBoard);
		boardView.drawBoard(gameSize);
		boardView.revalidate();
	}

	private BoardView clearPreviousBoard() {
		BoardView boardView = BoardView.boardView;
		boardView.removeAll();
		boardView.repaint();
		return boardView;
	}

	public void exitGame() {
		System.exit(0);
	}

	public Board getBoard() {
		return gameBoard;
	}

	public void clickCell(int row, int col, JButton cell) {
		stepCount++;
		checkCoordinate(row, col, cell);
		if (checkGameStatus()) {
			JOptionPane.showMessageDialog(view, "!!!Winner!!! - " + stepCount + " steps.");
		}
	}

	private void checkCoordinate(int x, int y, JButton cell) {
		if (gameBoard.getItem(x, y).toString().equals("T")) {
			setTentFound(x, y, cell);
		} else if ((gameBoard.getItem(x, y)).toString().equals("X")) {
			setGrassFound(cell);
		}
	}

	private void setGrassFound(JButton cell) {
		Icon cellIcon = new ImageIcon("grass.png");
		cell.setIcon(cellIcon);
	}

	private void setTentFound(int x, int y, JButton cell) {
		foundTentCount++;
		Icon cellIcon = new ImageIcon("tent.png");
		cell.setIcon(cellIcon);
		((Tent) gameBoard.getItem(x, y)).setFoundTent();
	}

	private boolean checkGameStatus() {
		return (foundTentCount == gameBoard.getBoardDimension() - 1);
	}
}
