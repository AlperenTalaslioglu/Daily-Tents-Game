package dailyTents;

public class DailyTentsGame {
	public static void main(String[] args){
		Board gameBoard = new Board();
        DailyTentsController controller = new DailyTentsController(gameBoard);
        controller.startGame();
	}
}