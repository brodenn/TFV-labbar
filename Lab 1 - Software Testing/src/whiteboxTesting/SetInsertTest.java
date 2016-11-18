package whiteboxTesting;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SetInsertTest {
	private Set set;

	@Before public void setUp() {
		set = new Set();
	}

	// Statement coverage
	

	@Test public void testInsertExists() {
		set.insert(100);
		set.insert(100);

		assertTrue(set.toArray().length == 1);
		assertTrue(set.toArray()[0] == 100);
	}
	
	
	@Test public void testInsertNonEmpty() {
		set.insert(50);
		set.insert(60);
		set.insert(70);

		assertTrue(set.toArray()[0] == 50);
		assertTrue(set.toArray()[1] == 60);
		assertTrue(set.toArray()[2] == 70);
		assertTrue(set.toArray().length == 3);
	}

	
	@Test public void testInsertEmpty() {
		set.insert(5);
		assertTrue(set.toArray()[0] == 5);
		assertTrue(set.toArray().length == 1);
	}
	
	// Branch coverage
	@Test public void testInsert() {
		set.insert(32);
		set.insert(67);
		set.insert(56);
		set.insert(56);

		assertTrue(set.toArray().length == 3);
		assertTrue(set.toArray()[0] == 32);
		assertTrue(set.toArray()[1] == 56);
		assertTrue(set.toArray()[2] == 67);
	}
}