//Oguzhan Terzioglu S003329
package dailyTents.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import dailyTents.Board;
import dailyTents.Coordinate;
import dailyTents.Item;
import dailyTents.Tree;

public class BoardTest {

	// Dimension test
	@Test(expected = NullPointerException.class)
	public void testConstructor1() {

		Board board = new Board((Integer) null);
	}

	// Dimension test
	@Test(expected = IllegalArgumentException.class)
	public void testConstructor2() {

		Board board = new Board(-5);
	}

	// Dimension test
	@Test(expected = IllegalArgumentException.class)
	public void testConstructor3() {

		Board board = new Board(-55);
	}

	// Dimension test
	@Test(expected = IllegalArgumentException.class)
	public void testConstructor4() {

		Board board = new Board(0);
	}

	// Size validity Test
	@Test(expected = IllegalArgumentException.class)
	public void testBoardSize1() {

		Board board = new Board(0);
	}

	// Size validity Test
	@Test(expected = IllegalArgumentException.class)
	public void testBoardSize2() {

		Board board = new Board(-5);
	}

	// Size validity Test
	@Test
	public void testBoardSize3() {

		Board board = new Board(5);

		assertEquals(5, board.getBoard().length - 1);
		assertEquals(5, board.getBoard()[0].length - 1);
	}

	// Size validity Test
	@Test
	public void testBoardSize4() {

		Board board = new Board(5);

		assertNotEquals(7, board.getBoard().length);
		assertNotEquals(8, board.getBoard()[0].length);
	}

	// Size validity Test
	@Test
	public void testBoardSize5() {

		Board board = new Board(5);

		assertNotEquals(7, board.getBoard().length);
		assertEquals(5, board.getBoard()[0].length - 1);
	}

	// Size validity Test
	@Test
	public void testBoardSize6() {

		Board board = new Board(5);

		assertEquals(5, board.getBoard().length - 1);
		assertNotEquals(7, board.getBoard()[0].length - 1);
	}

	// Set Item On Board Test
	@Test
	public void setItemTest1() {

		Board board = new Board(6);
		Item tree = new Tree();

		board.placeItem(tree, 1, 5);

		assertEquals(tree, board.getItem(1, 5));
	}

	// Set Item On Board Test | x out of bound
	@Test(expected = RuntimeException.class)
	public void setItemTest2() {

		Board board = new Board(6);
		Item tree = new Tree();

		board.placeItem(tree, 7, 5);

		assertEquals(tree, board.getItem(7, 5));
	}

	// Set Item On Board Test | x out of bound
	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void setItemTest3() {

		Board board = new Board(6);
		Item tree = new Tree();

		board.placeItem(tree, -7, 5);

		assertEquals(tree, board.getItem(-7, 5));
	}

	// Set Item On Board Test | y out of bound
	@Test(expected = RuntimeException.class)
	public void setItemTest4() {

		Board board = new Board(6);
		Item tree = new Tree();

		board.placeItem(tree, 4, 9);

		assertEquals(tree, board.getItem(4, 9));
	}

	// Set Item On Board Test | y out of bound
	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void setItemTest5() {

		Board board = new Board(6);
		Item tree = new Tree();

		board.placeItem(tree, 4, -9);

		assertEquals(tree, board.getItem(4, -9));
	}

	// Set Item On Board Test
	@Test
	public void setItemTest6() {

		Board board = new Board(10);
		Item tree = new Tree();

		board.placeItem(tree, 7, 5);

		assertEquals(tree, board.getItem(7, 5));
	}

	// on x,y Item Test
	@Test
	public void getItemTest1() {

		Board board = new Board(10);
		Item tree = new Tree();

		board.placeItem(tree, 7, 5);

		assertEquals(tree, board.getItem(7, 5));
	}

	// on x,y Item Test | x out of bound
	@Test(expected = RuntimeException.class)
	public void getItemTest2() {

		Board board = new Board(10);
		Item tree = new Tree();

		board.placeItem(tree, 7, 5);

		assertEquals(tree, board.getItem(11, 5));
	}

	// on x,y Item Test | x out of bound
	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void getItemTest3() {

		Board board = new Board(10);
		Item tree = new Tree();

		board.placeItem(tree, 7, 5);

		assertEquals(tree, board.getItem(-22, 5));
	}

	// on x,y Item Test | y out of bound
	@Test(expected = RuntimeException.class)
	public void getItemTest4() {

		Board board = new Board(10);
		Item tree = new Tree();

		board.placeItem(tree, 7, 5);

		assertEquals(tree, board.getItem(7, 33));
	}

	// on x,y Item Test | y out of bound
	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void getItemTest5() {

		Board board = new Board(10);
		Item tree = new Tree();

		board.placeItem(tree, 7, 5);

		assertEquals(tree, board.getItem(7, -13));
	}

	// cell empty check test
	@Test
	public void checkCellOccupationTest1() {

		Board board = new Board(10);
		initBoard(board);

		Item tree = new Tree();

		board.placeItem(tree, 7, 5);

		assertEquals(true, board.isCellEmpty(7, 4));
	}

	// cell empty check test
	@Test
	public void checkCellOccupationTest2() {

		Board board = new Board(10);
		initBoard(board);

		Item tree = new Tree();

		board.placeItem(tree, 7, 5);

		assertEquals(true, board.isCellEmpty(6, 5));
	}

	// cell empty check test
	@Test
	public void checkCellOccupationTest3() {

		Board board = new Board(10);
		Item tree = new Tree();

		board.placeItem(tree, 7, 5);

		assertEquals(false, board.isCellEmpty(7, 5));
	}

	private static void initBoard(Board board) {
		for (int i = 0; i < board.getBoardDimension(); i++) {
			for (int j = 0; j < board.getBoardDimension(); j++) {
				// initially empty items placed
				board.placeItem(new Item(), i, j);
			}
		}
	}

}
