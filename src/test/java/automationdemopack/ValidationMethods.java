package automationdemopack;

import org.testng.Assert;

public class ValidationMethods {
	public static void statusValidation(int actualStatusCode, int expectedStatusCode, String actualStatus,
			String expectedStatus) {
		Assert.assertEquals(actualStatusCode, expectedStatusCode);
		Assert.assertEquals(actualStatus, expectedStatus);
	}
}
