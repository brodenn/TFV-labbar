package whiteboxTesting;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SetContainsArithTripleTest {
	private Set set;

	@Before
	public void setUp() {
		set = new Set();
	}

	// Statement and branch coverage
	@Test
	public void testNotExists() {
		set.insert(2);
		set.insert(4);
		set.insert(5);

		assertFalse(set.containsArithTriple());
	}

	@Test
	public void testExists() {
		set.insert(3);
		set.insert(4);
		set.insert(5);

		assertTrue(set.containsArithTriple());
	}

}