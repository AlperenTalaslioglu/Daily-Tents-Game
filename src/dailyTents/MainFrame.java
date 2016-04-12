package dailyTents;

import java.awt.BorderLayout;
import javax.swing.JFrame;

public class MainFrame extends JFrame {
	public MainFrame(Board gameBoard, DailyTentsController dailyTentsController) {
		super("!!!Daily Tents Game!!!");
		setSize(600, 600);
		setLayout(new BorderLayout());
		add(new ControlButtonsView(dailyTentsController),BorderLayout.NORTH);
		add(new BoardView(dailyTentsController),BorderLayout.CENTER);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
