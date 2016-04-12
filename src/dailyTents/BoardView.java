package dailyTents;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class BoardView extends JPanel {
	private DailyTentsController dailyTentsController;
	private Board board;
	public static BoardView boardView;

	public BoardView(DailyTentsController dailyTentsController) {
		this.dailyTentsController = dailyTentsController;
		this.board = dailyTentsController.getBoard();
		this.boardView = this;
		drawBoard(dailyTentsController.getBoardSize());
	}

	public void drawBoard(int boardSize) {
		setLayout(new GridLayout(boardSize, boardSize));
		drawGrid(boardSize);
	}

	private void drawGrid(int boardSize) {
		for (int i = 0; i < boardSize; i++) {
			for (int j = 0; j < boardSize; j++) {
				JButton cell = new JButton();
				cell.setIcon(handleCell(i, j, cell));
				addListenerToCell(i, j, cell);
				add(cell);
			}
		}
	}

	private void addListenerToCell(int i, int j, JButton cell) {
		final int row = i;
		final int col = j;
		cell.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dailyTentsController.clickCell(row, col, cell);
			}
		});
	}
	
	/*
	 * T = TENT
	 * E = TREE
	 * X = EMPTY
	 */
	private Icon handleCell(int i, int j, JButton cell) {
		Icon cellIcon = null;
		if (board.getItem(i, j).toString().equals("T")) {
			Tent currentTemp = (Tent) board.getItem(i, j);
			if (currentTemp.isTentFound()) {
				cellIcon = new ImageIcon("tent.png");
			}
		} else if (board.getItem(i, j).toString().equals("E")) {
			cellIcon = new ImageIcon("tree.png");
		} else if (!(board.getItem(i, j)).toString().equals("X")) {
			cell.setText(board.getItem(i, j).toString());
		}
		return cellIcon;
	}

	public void setBoard(Board board) {
		this.board = board;
	}
}
