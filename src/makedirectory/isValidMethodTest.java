package makedirectory;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests isVlaid() method with multiple cases
 * @author Vladimirs Ivanovs
 *
 */
public class isValidMethodTest {

	@Test
	public void testValidName() {
		assertTrue(MakeDirectory.isValid("Folder 1 two"));
	}
	
	@Test
	public void testInvalidName() {
		assertFalse(MakeDirectory.isValid("Name^"));
	}
	
	@Test
	public void testEmptyName() {
		assertFalse(MakeDirectory.isValid(""));
	}
	
	@Test
	public void testNameStartsWithSpace() {
		assertFalse(MakeDirectory.isValid(" Name"));
	}
	
	@Test
	public void testNameEndsWithSpace() {
		assertFalse(MakeDirectory.isValid("Name "));
	}

}
