Feature: BlankFactor Automation challenge
  1. Navigate to “http://blankfactor.com”
  2. Open Insights menu and then click on “Blog” section
  3. Scroll down to and click on Load More button until the article with title “Why Fintech in Latin America Is Having a Boom” is displayed and click the post by Sofia Gonzalez
  4. Make validation (that the user  is on the correct page, by verifying URL, some of the text on the page)
  5. Subscribe to the newsletter using the subscribe form
  6. Go back to the Blog section and print a list of the all posts titles with related links.


  Scenario: search blog and subscribe user
    Given the user alejandro go to blankFactor page and go to blogs section
    When try to search the blog Why Fintech in Latin America Is Having a Boom By Sofia Gonzalez
    Then should be in the correct URL and have main title equal to the blog name
    And Subscribe to the newsletter using the subscribe form with the email
    Then Go back to the Blog section and print a list of the all posts titles with related links.


