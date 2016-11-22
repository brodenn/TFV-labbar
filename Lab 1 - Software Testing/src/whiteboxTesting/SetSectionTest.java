package whiteboxTesting;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SetSectionTest {
	private Set set;
	private Set deletionSet;

	@Before
	public void setUp() {
		set = new Set();
		deletionSet = new Set();
	}

	// Statement coverage
	@Test
	public void testSectionExists() {
		set.insert(5);
		deletionSet.insert(5);
		set.section(deletionSet);
		assertFalse(set.member(5));
		assertTrue(set.toArray().length == 0);
	}

	@Test
	public void testSectionLarger() {
		set.insert(2);
		deletionSet.insert(3);
		set.section(deletionSet);
		assertTrue(set.member(2));
		assertTrue(set.toArray().length == 1);
	}

	
	//branch coverage
	@Test
	public void testSectionMany() {
		set.insert(1);
		set.insert(2);
		set.insert(4);
		set.insert(5);
		set.insert(6);

		deletionSet.insert(1);
		deletionSet.insert(2);
		deletionSet.insert(3);
		deletionSet.insert(4);
		deletionSet.insert(6);

		set.section(deletionSet);

		assertFalse(set.member(1));
		assertFalse(set.member(2));
		assertFalse(set.member(3));
		assertFalse(set.member(4));
		assertTrue(set.member(5));
		assertFalse(set.member(6));

	}
}