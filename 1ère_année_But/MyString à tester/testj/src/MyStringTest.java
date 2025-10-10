import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class MyStringTest {

	@Test
	public void testConstructeurArrayNotSameAndRecopieEquals() {
		String str = "abc";
		char[] value = str.toCharArray();
		MyString test = new MyString(value);
		assertNotSame(value,test.value);
		assertArrayEquals(value,test.value);
	}
	
	@Test
	public void testConstructeurArrayNotSame() {
		String str = "abc";
		char[] value = str.toCharArray();
		MyString test = new MyString(value);
		value[0] = 'z';
		assertEquals('a',test.charAt(0));
	}
	
	@Test
	public void testConstructeurStringBufferRecopie() {
		StringBuffer sb = new StringBuffer("abc");
		MyString test = new MyString(sb);
		assertArrayEquals(sb.toString().toCharArray(),test.value);
	}
	
	@Test(expected=StringIndexOutOfBoundsException.class)
	public void testCharAtIndiceNegatif() {
		String str = "abc";
		char[] value = str.toCharArray();
		MyString test = new MyString(value);
		test.charAt(-1);
	}
	
	@Test(expected=StringIndexOutOfBoundsException.class)
	public void testCharAtIndiceSuperieurOuEgalALength() {
		String str = "abc";
		char[] value = str.toCharArray();
		MyString test = new MyString(value);
		test.charAt(3);
	}
	
	@Test
	public void testLength() {
		String str = "abcdef";
		char[] value = str.toCharArray();
		MyString test = new MyString(value);
		assertEquals(6,test.length());
	}
	
	@Test
	public void testIsEmptyStringVide() {
		String str = "";
		char[] value = str.toCharArray();
		MyString test = new MyString(value);
		assertTrue(test.isEmpty());
	}
	
	@Test
	public void testIsEmptyStringNonVide() {
		String str = "abc";
		char[] value = str.toCharArray();
		MyString test = new MyString(value);
		assertFalse(test.isEmpty());
	}
	
	@Test 
	public void testCharAt() {
		String str = "abc";
		char[] value = str.toCharArray();
		MyString test = new MyString(value);
		char[] obtained = {test.charAt(0), test.charAt(1), test.charAt(2)};
		assertArrayEquals(value,obtained);
	}
	
	@Test
	public void testEqualsSameString() {
		String str = "abc";
		char[] value = str.toCharArray();
		MyString test = new MyString(value);
		assertTrue(test.equals(test));
	}
	
	@Test
	public void testNotEqualsNullString() {
		String str = "abc";
		char[] value = str.toCharArray();
		MyString test = new MyString(value);
		assertFalse(test.equals(null));
	}
	
	@Test
	public void testNotEqualsStringsWithNonEqualLengths() {
		String str = "abc";
		char[] value = str.toCharArray();
		MyString test = new MyString(value);
		String anotherStr = "abcd";
		char[] anotherValue = anotherStr.toCharArray();
		MyString anotherTest = new MyString(anotherValue);
		assertFalse(test.equals(anotherTest));
	}
	
	@Test
	public void testEqualsStringsWithEqualSequences() {
		String str = "abc";
		char[] value = str.toCharArray();
		MyString test = new MyString(value);
		String anotherStr = "abc";
		char[] anotherValue = anotherStr.toCharArray();
		MyString anotherTest = new MyString(anotherValue);
		assertTrue(test.equals(anotherTest));
	}
	
	@Test
	public void testEqualsStringsWithNotEqualSequences() {
		String str = "abc";
		char[] value = str.toCharArray();
		MyString test = new MyString(value);
		String anotherStr = "cba";
		char[] anotherValue = anotherStr.toCharArray();
		MyString anotherTest = new MyString(anotherValue);
		assertFalse(test.equals(anotherTest));
	}
	
	@Test
	public void testEqualsStringsWithNotEqualSequencesForTheLast() {
		String str = "abc";
		char[] value = str.toCharArray();
		MyString test = new MyString(value);
		String anotherStr = "abd";
		char[] anotherValue = anotherStr.toCharArray();
		MyString anotherTest = new MyString(anotherValue);
		assertFalse(test.equals(anotherTest));
	}
	
	@Test
	public void testFirstOccurenceOfACharacter() {
		String str = "abcabc";
		char[] value = str.toCharArray();
		MyString test = new MyString(value);
		assertEquals(0,test.indexOf('a'));
		assertEquals(1,test.indexOf('b'));
		assertEquals(2,test.indexOf('c'));
	}
	
	@Test
	public void testFirstOccurenceOfAInexistentCharacter() {
		String str = "abcabc";
		char[] value = str.toCharArray();
		MyString test = new MyString(value);
		assertEquals(-1,test.indexOf('d'));
	}
	
	@Test
	public void testLastOccurenceOfACharacter() {
		String str = "abcabc";
		char[] value = str.toCharArray();
		MyString test = new MyString(value);
		assertEquals(3,test.lastIndexOf('a'));
		assertEquals(4,test.lastIndexOf('b'));
		assertEquals(5,test.lastIndexOf('c'));
	}
	
	@Test
	public void testLastOccurenceOfAnInexistentCharacter() {
		String str = "abcabc";
		char[] value = str.toCharArray();
		MyString test = new MyString(value);
		assertEquals(-1,test.lastIndexOf('d'));
	}
	
	@Test
	public void testConcatenationWithEmptyString() {
		String str = "cares";
		char[] value = str.toCharArray();
		MyString test = new MyString(value);
		String anotherStr = "";
		char[] anotherValue = anotherStr.toCharArray();
		MyString anotherTest = new MyString(anotherValue);
		assertSame(test,test.concat(anotherTest));
	}
	
	@Test
	public void testConcatenationWithString() {
		String strTo = "to";
		char[] valueTo = strTo.toCharArray();
		MyString to = new MyString(valueTo);
		String strGet = "get";
		char[] valueGet = strGet.toCharArray();
		MyString get = new MyString(valueGet);
		String strHer = "her";
		char[] valueHer = strHer.toCharArray();
		MyString her = new MyString(valueHer);
		String strExpected = "together";
		char[] valueExpected = strExpected.toCharArray();
		assertArrayEquals(valueExpected,to.concat(get).concat(her).value);
	}
	
	@Test(expected=StringIndexOutOfBoundsException.class)
	public void testSubstringIndiceFirstNegatif() {
		String str = "hamburger";
		char[] value = str.toCharArray();
		MyString test = new MyString(value);
		test.substring(-1,0);
	}
	
	@Test(expected=StringIndexOutOfBoundsException.class)
	public void testSubstringIndiceLastSuperieuerALength() {
		String str = "hamburger";
		char[] value = str.toCharArray();
		MyString test = new MyString(value);
		test.substring(0,10);
	}
	
	@Test(expected=StringIndexOutOfBoundsException.class)
	public void testSubstringIndiceFirstSuperieuerAIndiceLast() {
		String str = "hamburger";
		char[] value = str.toCharArray();
		MyString test = new MyString(value);
		test.substring(3,2);
	}
	
	@Test
	public void testSubstringSame() {
		String str = "hamburger";
		char[] value = str.toCharArray();
		MyString test = new MyString(value);
		assertSame(test,test.substring(0,9));
	}
	
	@Test
	public void testSubstringEnd() {
		String str = "hamburger";
		char[] value = str.toCharArray();
		MyString test = new MyString(value);
		String strExpected = "urger";
		char[] expectedValue = strExpected.toCharArray();
		assertArrayEquals(expectedValue,test.substring(4,9).value);
	}
	
	@Test
	public void testSubstringStart() {
		String str = "hamburger";
		char[] value = str.toCharArray();
		MyString test = new MyString(value);
		String strExpected = "hamb";
		char[] expectedValue = strExpected.toCharArray();
		assertArrayEquals(expectedValue,test.substring(0,4).value);
	}
}

