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

}
