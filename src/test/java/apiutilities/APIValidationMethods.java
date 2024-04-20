package apiutilities;

import org.testng.Assert;

public class APIValidationMethods {
	public static void statusValidation(int actualStatusCode, int expectedStatusCode, String actualStatus,
			String expectedStatus) {
		Assert.assertEquals(actualStatusCode, expectedStatusCode);
		Assert.assertEquals(actualStatus, expectedStatus);
	}
}
