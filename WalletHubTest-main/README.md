# WalletHubTest

This project is created using Selenium , Java and TestNg.

To run the test cases please follow belo steps :

1. There is a AppConfig file in src/main/resources , use this file to set username and password for WallteHub application and facebook
2. TestNg.xml file has two classes added for running test cases , use this xml file to run the test cases 
3. Test cases are present in src/test/java/org/walletHub/tests package by the name of ValidationApplicationReview and ValidateFaceBookPost.
    These same classes are mentioned in TestNg.xml file
4. For running any test case user has to comment the other one in testNg.xml , currently only one test case can be run at a time.  
5. Testdata for the tests can be changes by using properties file TestData present under src/test/resources

    
