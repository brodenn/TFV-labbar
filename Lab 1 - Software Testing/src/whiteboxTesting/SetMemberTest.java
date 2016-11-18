package whiteboxTesting;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SetMemberTest {
	private Set set;

	@Before public void setUp() {
		set = new Set();
	}

  // Statement and branch coverage
	
	@Test public void testMemberExists() {
		set.insert(10);
		assertTrue(set.member(10));
	}
	
	@Test public void testMemberNotExists() {
		set.insert(20);
		assertFalse(set.member(10));
	}

	@Test public void testMember() {
		set.insert(1);
		set.insert(4);
		set.insert(3);

		assertFalse(set.member(2));
		assertTrue(set.member(4));
	}
}