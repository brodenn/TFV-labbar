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
	
	
	@Test public void testInsertLarger() {
		set.insert(50);
		set.insert(60);

		assertTrue(set.toArray()[0] == 50);
		assertTrue(set.toArray()[1] == 60);
		assertTrue(set.toArray().length == 2);
	}

	// Branch coverage
	@Test public void testInsert() {
		set.insert(30);
		set.insert(40);
		set.insert(40);
		set.insert(20);

		assertTrue(set.toArray().length == 3);
		assertTrue(set.toArray()[0] == 20);
		assertTrue(set.toArray()[1] == 30);
		assertTrue(set.toArray()[2] == 40);
	}
}