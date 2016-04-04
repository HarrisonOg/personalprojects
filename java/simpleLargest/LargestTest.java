import static org.junit.Assert.*;

import org.junit.Test;

public class LargestTest {

	@Test
	public void test() {
		int[] arr = new int[3];
		arr[0] = 8;
		arr[1] = 9;
		arr[2] = 7;
		
		assertEquals(9, Largest.largest(arr));
	}

	@Test
    public void testOrder() {
        assertEquals(9, Largest.largest(new int[] {9,8,7}));
        assertEquals(9, Largest.largest(new int[] {8,9,7}));
        assertEquals(9, Largest.largest(new int[] {7,8,9}));
	}
	
	@Test
	public void testNegative(){
		int[] negList = new int[] {-9,-8,-7};
		assertEquals(-7, Largest.largest(negList));
	}
}
