//Oguzhan Terzioglu S003329
package dailyTents.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import dailyTents.Coordinate;
import dailyTents.Tent;
import dailyTents.Tree;

public class TentTest {
	
	// Initial Object Test
	@Test
	public void testTreeOfTent() {
		Tent tent = new Tent();
		assertEquals(null,tent.getTreeOfTent());
	}

	// Initial Object Test
	@Test
	public void testTreeOfTent2() {
		Tent tent = new Tent();
		Tree tree = new Tree();
		tent.setTreeToTent(tree);
		assertEquals(tree,tent.getTreeOfTent());
	}
	
	// Initial Object Test
	@Test(expected = NullPointerException.class)
	public void testSetTreeOfTent1() {
		Tent tent = new Tent();
		tent.setTreeToTent(null);
		assertEquals(null,tent.getTreeOfTent());
	}
	
	// Initial Object Test
	@Test(expected = NullPointerException.class)
	public void testSetTreeOfTent2() {
		Tent tent = new Tent();
		tent.setTreeToTent(null);
		assertEquals(null,tent.getTreeOfTent());
	}

}
