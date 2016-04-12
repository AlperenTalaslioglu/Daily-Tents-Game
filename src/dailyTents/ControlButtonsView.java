package dailyTents;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ControlButtonsView extends JPanel {
	private DailyTentsController dailyTentsController;

	public ControlButtonsView(DailyTentsController dailyTentsController) {
		this.dailyTentsController = dailyTentsController;
		addSizeSelector();
		addNewGameButton();
		addExitButton();
	}

	private void addExitButton() {
		JButton exitGameButton = new JButton("Exit Game"); // this is for after size selection										 
		addExitButtonListener(exitGameButton);
		add(exitGameButton);
	}

	private void addExitButtonListener(JButton exitGameButton) {
		exitGameButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dailyTentsController.exitGame();
			}
		});
	}

	private void addNewGameButton() {
		JButton newGameButton = new JButton("New Game"); // this is for after size selection
		addNewGameButtonListener(newGameButton);
		add(newGameButton);
	}

	private void addNewGameButtonListener(JButton newGameButton) {
		newGameButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dailyTentsController.startNewGame();
			}
		});
	}

	private void addSizeSelector() {
		String[] sizeList = getBoardSizes();
		JComboBox sizeSelector = new JComboBox(sizeList);
		addSizeSelectorListener(sizeSelector);
		add(sizeSelector);
	}

	private void addSizeSelectorListener(JComboBox sizeSelector) {
		sizeSelector.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox comboBox = (JComboBox) e.getSource();
				String selected = comboBox.getSelectedItem().toString();
				int selectedSize = Integer.parseUnsignedInt(selected);
				dailyTentsController.getBoardSizeSelection(selectedSize);
			}
		});
	}

	private String[] getBoardSizes() {
		String[] sizeList = new String[4];
		sizeList[0] = "8";
		sizeList[1] = "12";
		sizeList[2] = "16";
		sizeList[3] = "20";
		return sizeList;
	}
}
