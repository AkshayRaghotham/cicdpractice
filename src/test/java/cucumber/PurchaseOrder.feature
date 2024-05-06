
@tag
Feature: Purchase Order From Ecommerce
  I want to use this template for my feature file


  @Background:
  Given I landed on Ecommerce Page
  

  @tag2
  Scenario Outline: Positive Test of Submitting the Order
    Given Logged in with username <name> and <password>
    When I add product <productName> TO cart
    And checkout <productName> and submit the order
    Then "Thankyou for the order." message is displayed on ConfirmationPage

    Examples: 
      | name                 | password     | productName |
      | akshay1999@gmail.com | Akshay123    | ZARA COAT 3 |
      
