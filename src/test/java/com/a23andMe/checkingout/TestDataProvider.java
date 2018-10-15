package com.a23andMe.checkingout;

import org.testng.annotations.DataProvider;

public class TestDataProvider {
	@DataProvider(name = "addressData", parallel = true)
	public static Object[][] testData() {
		return new Object[][] { 
			{ 
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
				"yy", 
				"Du", 
				"",
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
