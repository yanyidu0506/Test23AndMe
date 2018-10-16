package com.a23andMe.checkingout;

import org.testng.annotations.DataProvider;

/**
 * Test data provider for multiple test cases.
 * @author Yanyi
 *
 */
public class TestDataProvider {
	@DataProvider(name = "addressData", parallel = true)
	public static Object[][] testData() {
		return new Object[][] { 
			{ 
				//valid information
				"yy", 
				"Du", 
				"899 W Evelyn Ave",
				"Mountain View",
				"California",
				"94041",
				"testpurpose23andme@gmail.com",
				"8002395230",
				"4111111111111111",
				"12/19",
				"666"
			},
			{ 
				//invalid first name
				"", 
				"Du", 
				"899 W Evelyn Ave",
				"Mountain View",
				"California",
				"94041",
				"testpurpose23andme@gmail.com",
				"8002395230",
				"4111111111111111",
				"12/19",
				"666"
			},  
			{ 
				//invalid last name
				"yy", 
				"", 
				"899 W Evelyn Ave",
				"Mountain View",
				"California",
				"94041",
				"testpurpose23andme@gmail.com",
				"8002395230",
				"4111111111111111",
				"12/19",
				"666"
			}, 
			{ 
				//invalid email address
				"yy", 
				"Du", 
				"899 W Evelyn Ave",
				"Mountain View",
				"California",
				"94041",
				"testpurpose23andmegmail.com",
				"8002395230",
				"4111111111111111",
				"12/19",
				"666"
			}
		};
	}
}
