# Overview of Project - The 'Peak' of Food Delivery
Futuristic food assessment and delivery
-	Makes user take Questionnaire to assess which cuisine/restaurant they'd like 
-	Decides which food to order using an MCQBot
-	Generates a bill by adding the food and then running the order through an offer finder. 
-	Allows you to divide the payment by guessing which of you comes the closest to the price. The tip, and the amount of money used will     be a function of the amounts guessed 
-	Sets the ordering location by gradually narrowing down onto your location from Google coordinates
-	Places the order on a connected phone

## Specifics of sections
### 1. Using the Questionnaire to assess cuisine/ restaurant
   The goal of this section is to assess a person's current cravings through an innoccuous Questionnaire of easy to answer questions
### 2. Details of the MCQBot
   This is the implementation of a simple bot to answer multiple choice question. The idea is pretty simple - design a function that    takes as input a question, and a list of choices (number of choices is not fixed), and that returns the index of the choice you believe is the right one. 
    ```
    How often do you visit the seaside?
    1.) Never been
    2.) Occassionally when forced to
    3.) Whenever I can. 
    4.) The sea is my one true passion. Dry land is death
    ```
   This particular bot focusses on semantic analysis for NLP to answer pseudo open field questions. It looks through google results and
   uses the information it receives to make the best choice.
   This is taken from an open source API on github. There is a simple API that lets you make some research in google, which has been wrapped in python, [Google-Search-API](https://github.com/abenassi/Google-Search-API). 
   Here's the syntax of the python statements I've used to search for stuff on Google.
    
      ```
      from google import google
      my_search = google.search('Search terms')
      ```
   This Google API software uses screen scraping to retreive search results from google.com. After cleaning the text extracted from the search, I concat all the text together as one really long string that represents all the text available on first pages of google. I then score each of my search results in order to determine which one would be the best. 
   
   **my_search** will contain a list of GoogleResult objects
      ```
      GoogleResult:
          self.name # The title of the link
          self.link # The link url
          self.description # The description of the link
          self.thumb # The link to a thumbnail of the website (not implemented yet)
          self.cached # A link to the cached version of the page
          self.page # What page this result was on (When searching more than one page)
          self.index # What index on this page it was on
      ```   
### 3. Generating and determining the final bill

### 4. Dividing the Payment - The price is right

### 5. Setting the ordering location

### 6. Placing the order
