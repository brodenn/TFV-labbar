package whiteboxTesting;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SetMemberTest {
	private Set set;

	@Before public void setUp() {
		set = new Set();
		set.insert(10);
		set.insert(20);
		set.insert(30);
	}

  // Statement coverage
	
	@Test public void testMemberExists() {
		assertTrue(set.member(10));
		
	}
	
	@Test public void testMemberLargerExists() {
		assertTrue(set.member(20));
	}
	
	//branch coverage
	@Test public void testMember() {
		assertFalse(set.member(5));
		assertTrue(set.member(10));
		assertTrue(set.member(20));
		assertFalse(set.member(40));
	}
}