//Oguzhan Terzioglu S003329
package dailyTents.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import dailyTents.Coordinate;

public class CoordinateTest {

	// Constructor test
	@Test(expected = IllegalArgumentException.class)
	public void testConstructor() {

		Coordinate coord = new Coordinate(-50, -50);

	}

	// Constructor test
	@Test(expected = IllegalArgumentException.class)
	public void testConstructor2() {

		Coordinate coord = new Coordinate(50, -50);

	}

	// Constructor test
	@Test(expected = IllegalArgumentException.class)
	public void testConstructor3() {

		Coordinate coord = new Coordinate(-50, 50);

	}

	// Constructor test
	@Test
	public void testConstructor4() {

		Coordinate coord = new Coordinate(50, 50);

		assertEquals(50, coord.getX());
		assertEquals(50, coord.getY());
	}

	// Setter and Getter Method Test
	@Test(expected = IllegalArgumentException.class)
	public void testSetterAndGetterMethod1() {

		Coordinate coord = new Coordinate(10, 7);

		coord.setX(-10);
		coord.setY(-20);

	}

	// Setter and Getter Method Test
	@Test(expected = IllegalArgumentException.class)
	public void testSetterAndGetterMethod2() {

		Coordinate coord = new Coordinate(10, 7);

		coord.setX(10);
		coord.setY(-20);

	}

	// Setter and Getter Method Test
	@Test(expected = IllegalArgumentException.class)
	public void testSetterAndGetterMethod3() {

		Coordinate coord = new Coordinate(10, 7);

		coord.setX(-10);
		coord.setY(20);

	}

	// Setter and Getter Method Test
	@Test
	public void testSetterAndGetterMethod4() {

		Coordinate coord = new Coordinate(10, 7);

		coord.setX(10);
		coord.setY(20);

		assertEquals(10, coord.getX());
		assertEquals(20, coord.getY());
	}

	// toStringMethod Test
	@Test(expected = IllegalArgumentException.class)
	public void testToString1() {

		Coordinate coord = new Coordinate(-10, -5);

		assertEquals("Coordinate [x=-10, y=-5]", coord.toString());
	}

	// toStringMethod Test
	@Test(expected = IllegalArgumentException.class)
	public void testToString2() {

		Coordinate coord = new Coordinate(10, -5);

		assertEquals("Coordinate [x=10, y=-5]", coord.toString());
	}

	// toStringMethod Test
	@Test(expected = IllegalArgumentException.class)
	public void testToString3() {

		Coordinate coord = new Coordinate(-10, 5);

		assertEquals("Coordinate [x=-10, y=5]", coord.toString());
	}

	// toStringMethod Test
	@Test(expected = IllegalArgumentException.class)
	public void testToString4() {

		Coordinate coord = new Coordinate(-10, -5);

		assertEquals("Coordinate [x=10, y=5]", coord.toString());
	}
	


}
