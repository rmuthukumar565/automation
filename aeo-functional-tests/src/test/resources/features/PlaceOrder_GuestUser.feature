Feature: Place Order feature
  Verify if user is able to place an order in ae site

  Scenario Outline: Place Order with different payment type and verify the free shipping threshold as a Guest User
    Given user is on homepage
    When user navigate to category as "<CATEGORY>",sub category as "<SUBCATEGORY>"
    Then user is on "<SUBCATEGORY>" results page
    When user click the product as "<PRODUCT>"
    When user select the size as "<SIZE>" and qty as "<QTY>"
    And user click the Add To Bag
    And user click View bag
    Then user is on Shopping Bag Page
     And user click to proceed to checkout
    Then user is on checkout page
    When user enter shipping address
    And user select the "<SHIPPINGOPTIONS>"
    When user enter "<CREDITCARDNUM>","<EXPDATE>","<CVV>" and "<PHONENUMBER>" in the payment section
    And user enter the "<CONTACTEMAIL>"
    Then user review the "<MERCHANDISE>","<SHIPPINGCHARGE>","<TAX>" and "<ORDERTOTAL>"
    And user click the place order
    Then user should see the order number in the order confirmation page
    
    
    Examples:
    |CATEGORY|SUBCATEGORY     |PRODUCT                 |SIZE              		|QTY|PRICE|SHIPPINGOPTIONS|CREDITCARDNUM   |EXPDATE|CVV|PHONENUMBER|CONTACTEMAIL     |MERCHANDISE|SHIPPINGCHARGE|TAX|ORDERTOTAL|TestDesc|
    |Women   |Shoes           |AEO Leopard Chelsea Boot|5 - Online Only  		|1  |44.96|STANDARD       |4111111111111111|12/23  |222|6692743224 |aeotest@gmail.com|$44.96|$7.00|0.00|$51.96|Order Total less than free shipping threshold and verify shipping charge|
    |Men     |Bottoms         |Dad Jean                |26 X 28 - Online Only   |1  |59.95|STANDARD       |4111111111111111|12/23  |222|5103961085 |aeotest@gmail.com|$59.95|FREE |0.00|$59.95|Order Total greater than free shipping threshold and verify Free shipping|
    |Women   |Perfume & Beauty|Be True 1.7oz EDT       |One Size                |1  |29.95|STANDARD       |4111111111111111|12/23  |222|5103961085 |aeotest@gmail.com|$29.95|$7.00 |$2.77|$36.95|Order Total less than free shipping threshold and verify shipping charge|
    
    
    
    