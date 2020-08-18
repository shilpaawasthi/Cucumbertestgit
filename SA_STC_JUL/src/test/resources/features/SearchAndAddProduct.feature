Feature: Feature: Search valid product and Add into Basket
  
  As a user
  I want to see the Product
  So that I can add into Basket

  @ForSearchScenario
  Scenario Outline: Verify that when a user searches for a valid product and adds to the basket – product should be available in the basket.
    Given that user is on the search page
    When the user enters "<searchproduct>" into "searchLocationText"
    And user clicks "searchButton"
    And checks "headerTitleLabel"
    And user clicks "productname"
    And checks product "logo1"
    And user clicks "addbasketbutton"
    And checks basket "icon"
    And user clicks "viewbasket"
    Then the added product for result page "finalLable" should show "<Expected>"

    Examples: 
      | searchproduct | Expected |
      | Battery       |        1 |
