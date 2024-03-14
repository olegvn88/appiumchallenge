Feature: SamplesList

  Background:
    Given user is logged to application as admin user

  Scenario: Native View
    When user opening native view page
    Then list of three view items should be displayed

  Scenario: Slider
    When user opening slider page
    Then sliders position should be at the 0
    When setting slider to the end position
    Then sliders position should be at the 100

  Scenario: Vertical swiping
    When user opening swipe page
    And user swiping the page to the  Karma item
    Then the  Karma item is visible in the bottom of screen

  Scenario: Drag & Drop
    When user opening drag and drop page
    And user drag and drop Drag me! item to the Drop here
    Then the Circle dropped text is displayed on drag and drop success screen

  Scenario: Double Tap
    When user opening double tap page
    And user making a double tap on Double Tap Me
    Then the Double tap successful! message is displayed when double tap is succeed

  Scenario: Long Press
    When user opening long press page
    And user making long press on Long Press Me
    Then the you pressed me hard :P message is displayed after long pressing

  Scenario: Photo View
    When user opening photo view page
    Then the image is present

  Scenario: Web View
    When user opening web view
    And user navigating to submit page
    Then the submit page on web view is displayed

  Scenario: Carousel
    When user opening carousel page
    And user making horizontal left swipe to 3
    Then the 3 item after swiping is displayed

  Scenario: Wheel Picker
    When user opening wheel picker page
    Then the current color is Current Color: red
    And user choosing green color from dropdown menu
    Then the current color is Current Color: green
    And user choosing blue color from dropdown menu
    Then the current color is Current Color: blue
    And user choosing black color from dropdown menu
    Then the current color is Current Color: black