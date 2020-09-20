Feature: This feature is to verify the new filter options on Bookings dot com website

  Scenario Outline: Verify the hotels listed as per the filter applied

    Given User launches the website "http://booking.com"
    And types location for stay is "Limerick"
    And The Number of People are 2 with number of rooms being 1
    And The booking is to be done for "3" months from today and for "1" night
    When the filter applied is for "<filter>"
    Then Expect "<hotel>" to be listed is "<IsListed>"

    Examples:
      | filter | hotel                 | IsListed |
      | Sauna  | Limerick Strand Hotel | True     |
      | Sauna  | George Limerick Hotel | False    |
      | 5 Star | The Savoy Hotel       | True     |
      | 5 Star | George Limerick Hotel | False    |

