Feature: Add to cart

  Scenario Outline: Add one item to the cart
    Given I'm on the Store page
    When I add a "<product_name>" to the cart
    Then I see 1 "<product_name>" in the cart

    Examples:
    | product_name                    |
    | Anchor Bracelet                 |
    | Black Over-the-shoulder Handbag |