# Overview of Project - The 'Peak' of Food Delivery
Futuristic food assessment and delivery
-	Makes user take Questionnaire to assess which cuisine/restaurant they'd like 
-	Decides which food to order using an MCQBot
-	Generates a bill by adding the food and then running the order through an offer finder. 
-	Allows you to divide the payment by guessing which of you comes the closest to the price. The tip, and the amount of money used will     be a function of the amounts guessed 
-	Sets the ordering location by taking your location from Google coordinates
-	Places the order on a connected phone

## Specifics of sections
### 1. Using the Questionnaire to assess cuisine/ restaurant
   The goal of this section is to assess a person's current cravings through an innoccuous Questionnaire of easy to answer choices

An array of cuisine choices is created and answers to each question determine the number of tally-marks added to or removed from each possible cuisine. 

Here's an example of one of the questions.
```
Do you feel like visiting the seaside?
1.) Never
2.) Occassionally but only when forced to
3.) I'd like to.
4.) The sea is my one true passion. Dry land is death
```
The more a person visits the seaside, the more likely they are to like seafood. Thus, the tally marks would be added to Sushi and any other cuisine tha does involve fish.  

### 2. Details of the MCQBot
   This is the implementation of a simple bot to answer multiple choice question. The idea is pretty simple - design a function that    takes as input a question, and a list of choices (number of choices is not fixed), and that returns the index of the choice believed to be the right/ most popular one. 
   
```
Do you feel like visiting the seaside?
1.) Never
2.) Occassionally but only when forced to
3.) I'd like to.
4.) The sea is my one true passion. Dry land is death
```
#### How the data scraper Works   
   This particular bot focusses on semantic analysis for NLP to answer pseudo open field questions. It looks through google results and
   uses the information it receives to make the best choice.
   This is taken from an open source API on github. There is a simple API that lets you make some research in google, which has been wrapped in python, [Google-Search-API](https://github.com/abenassi/Google-Search-API). 
   Here's the syntax of the python statements I've used to search for stuff on Google.
    
```
from google import google
my_search = google.search('Search terms')
```
   This Google API software uses screen scraping to retreive search results from google.com. 
   
   **my_search** will contain a list of GoogleResult objects. To this, I **add the name of the user so as to search specifically within their social media, their postings etc.**
   
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
After cleaning the text extracted from the search, I concatenate all the text together as one really long string that represents all the text available on first pages of google. I then score each of my search results in order to determine which one would be the best. 

#### How the NLP syntax analysis Works
In order to find the answer, I use n-grams. For example, if the search term is 'How often visit sea FName LName', then,
```
1-grams = ["How", "often", "visit", "sea", "FName", "LName"]
2-grams = ["How often", "visit sea", "Kylie Jenner"]
etc.
```

Rather that counting in the google search result the entire choice string (preprocessed), we look for the 1-grams, 2-grams and the full string (preprocessed as method 1).
The score is thus the sum of these sub scores, each sub score having a multiplier:

```
total_score = 1*(1-grams occurences) + 3*(2-grams occurences) + 10*(full string occurences)
```

In that way, if only one word of the choice occurs, it only adds 1 point to the total score, if a 2-gram is found is found, adds 3 points, and if the full string is found, it adds 10 points. 

#### Results of the MCQBot
 The counter measures the number of entries (i,e the one with the highest score) and chooses the relevant answer. In the case of Kylie Jenner, the answer would be 3 since her social media contains multiple references to the seaside.
 This would select the cuisine and then add in food from the restaurant and add it into the checkout using the same principles.   

### 3. Generating and determining the final bill
   The food selected by the MCQBot is put into the cart. We then use the [Honey-Coupon-API](https://developer.honey.is/docs) to run a series of discount checks on the cart.
   The final price, along with taxes but excluding the tip is calculated and sent to the DividingPayment function to help distribute and figure out the bill (for groups of people).  

### 4. Dividing the Payment - The price is right

   To make the process of ordering food even more entertaining, we thought it was necessary to implement a way to choose who gets to pay.

We felt it was necessary to make everyone pay at least a percentage of the meal, so we devised a clever (possibly evil) game to decide how the meal will be paid for. 

## The premise of our game is simple:

**1) The computer will ask how many people are ordering food.**

Example Input/Output Using 4 persons:
```
How many people are there?
4
```

**2) Given the price, the computer will then ask each person to input a value that THEY think is the price of the total meal (including taxes, not including tips).**

Example Input/Output:
```
Person 1, enter your guess:
50.50
Person 2, enter your guess:
73.40
Person 3, enter your guess:
45.60
Person 4, enter your guess:
50.60
```

**3) Then the difference between each of the guesses and the actual price will be calculated.**
**The person with the largest price difference will be chosen to pay that difference as the tip.** 

Example Output:
```
Person 3, you must pay the difference of $14.90 as the tip.
```


**4) The remaining person(s) will then split the total bill for the meal (not including tips).**
**The computer will output the split value as well as the total cost of the meal.**

Example Output with example meal price of $60.50:
```
The rest of you must pay $20.17 each, for the total meal price of $60.50
```

### 6. Placing the order

