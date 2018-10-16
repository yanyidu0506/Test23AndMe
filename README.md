# Automation test for 23andMe.

**How to run the test cases:**

Prerequisite: need jdk and maven installed on the machine. Run commands are as below:

```git clone https://github.com/yanyidu0506/Test23AndMe.git```

```cd Test23AndMe```

For run with firefox browser:

```mvn clean package -DbrowserType=firefox```

For run with chrome browser:

```mvn clean package -DbrowserType=chrome```



**Test Cases:**

There are 4 test automation tests for cart and checkout page.

1. positive case with all valid checkout information and a test credit card number. The test can go to order button click. Since it is test credit card and the order confirmation cannot pass through. Verify if the page go to next page of order button click.

2. negative cases with empty first name for checkout. Verify if the error message is "invalid first name" when click button of go shipping.

3. negative cases with empty last name for checkout. Verify if the error message is "invalid last name" when click button of go shipping.

4. negative cases with empty invalid email address (missing @) for checkout. Verify if the error message is "invalid email" when click button of go shipping.

Test cases can be run with Chrome or firefox browser types on mac/unix platform. There are multiple threads to run test cases for time saving.




