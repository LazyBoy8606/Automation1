@tag2
Feature: SignIn to TestRail Trial

 @TestRail @ReilUserFields
  Scenario: Checking Error message when Signing In with invalid credentials
    Given User invokes Chrome
    And User navigates to TestRail Trial SignIn Page
    And User open privacy policy page
    And User Navigates back to SignIn Page
    When User Submit Details
      | FirstName  | LastName | Email     |  PhoneNum | Company |
      | sree 			 |   s 		  | sdf2@sdf  |  2434456  | TCS     |
      | Senthil 	 |   s 		  | asdf@sdf  |  3234234  | infy    |
      | Jerin 		 |   j 		  | sdf@sdf   |  3435345  | cape    |
      | Krishna 	 |   k 		  | sdfrw@sdf |  2343242  | qi      |
      | Sandeep		 |   s 		  | ads@sdf   |  3234234  | ey      |
      | Praveesh 	 |   p 		  | ewr@sdf   |  5435345  | ust     |
      | Jose 			 |   j 		  | dsaf@sdf  |  2343242  | test    |
      | Hashim 		 |   h 		  | adsf@sdf  |  6234234  | ho      |
    
    Then User validate the Error message
