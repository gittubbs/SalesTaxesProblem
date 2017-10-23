# Sales taxes problem
This problem requires some kind of input. You are free to implement any mechanism for feeding input into your solution (for example, using hard coded data within a unit test). You should provide sufficient evidence that your solution is complete by, as a minimum, indicating that it works correctly against the supplied test data.

## PROBLEM: SALES TAXES

**Basic sales tax** is applicable at a rate of **10%** on all goods, **except** books, food, and medical products that are exempt. **Import duty** is an additional sales tax applicable on all imported goods at a rate of 5%, with no exemptions.

When I purchase items I receive a receipt which lists the name of all the items and their price (including tax), finishing with the total cost of the items, and the total amounts of sales taxes paid. The rounding rules for sales tax are that for a tax rate of n%, a shelf price of p contains (np/100 rounded up to the nearest 0.05) amount of sales tax.

Write an application that prints out the receipt details for these shopping baskets...

```
INPUT:

Input 1:
1 book at 12.49
1 music CD at 14.99
1 chocolate bar at 0.85

Input 2:
1 imported box of chocolates at 10.00
1 imported bottle of perfume at 47.50

Input 3:
1 imported bottle of perfume at 27.99
1 bottle of perfume at 18.99
1 packet of headache pills at 9.75
1 box of imported chocolates at 11.25

OUTPUT

Output 1:
1 book: 12.49
1 music CD: 16.49
1 chocolate bar: 0.85
Sales Taxes: 1.50
Total: 29.83

Output 2:
1 imported box of chocolates: 10.50
1 imported bottle of perfume: 54.65
Sales Taxes: 7.65
Total: 65.15

Output 3:
1 imported bottle of perfume: 32.19
1 bottle of perfume: 20.89
1 packet of headache pills: 9.75
1 imported box of chocolates: 11.85
Sales Taxes: 6.70
Total: 74.68
```

## General requirements
- You may use whatever programming language/platform you prefer. Use something that you know well.
- You must release your work with an OSI-approved open source license of your choice.
- You must deliver the sources of your application, with a README that explains how to compile and run it.
- Add the code to your own Github account and send us the link.

**IMPORTANT:**  Implement the requirements focusing on **writing the best code** you can produce.

# My solution

My solution has been implemented using the [Strategy Design Pattern](https://en.wikipedia.org/wiki/Strategy_pattern "Strategy Design Pattern").

### Why the Strategy Design Pattern?
During the design phase I decided that an Item object shouldn't "know" directly how to calculate the tax on itself.
Using this approach, another developer could add a Tax Strategy just by adding a Class and change very few lines of code.

### Then, who's calculating the tax rate on the Item?
The Shopping Basket should do the work. In this version of the software, I've implemented only one kind of Shopping Basket based on two linked list and [BigDecimal](https://docs.oracle.com/javase/7/docs/api/java/math/BigDecimal.html "BigDecimal").
BigDecimals were necessary in order to have arbitrary precise rounding methods. Plus, if one day another developer will decide to change the rounding scale / currency decimals, he/she will have to change few lines of code.
![alt text](https://github.com/gittubbs/SalesTaxesProblem/blob/master/uml/strategy.jpg?raw=true)

### That's exciting! What are other curiosities about this project?
For the first time I developed a piece of code with [TDD](https://en.wikipedia.org/wiki/Test-driven_development "TDD"). The Class' name is *JSONItemConverter*.

Even if according to this [StackOverflow question](https://stackoverflow.com/questions/34571/how-do-i-test-a-class-that-has-private-methods-fields-or-inner-classes "StackOverflow question") it is *not* a good practice to test private methods directly, I used [Java Reflection](https://stackoverflow.com/questions/37628/what-is-reflection-and-why-is-it-useful "Java Reflection") for a test case in *ShoppingBasketListBDTest*. I admit that it was fun :P

### Did you use external libraries?
**YES**, json-simple library is used. I need it for reading Items from a local file formatted in JSON. I figured you'd like a system to push data into the software more intelligent than hard-coded class or *manual feeding*.

### What about documentation?
I've generated Javadocs (for private methodes as well). You can find it in **doc** folder.
There are some UML in jpg in the **uml** folder. They've been generated with an Eclipse plug-in. Sources are included.
The Packages diagram has been manually written with [Violet UML Editor](http://alexdp.free.fr/violetumleditor/page.php "... Made by Cay Horstmann...").

### Some more informations on JSON input
You need to have one file for one JSON representing an item.
The JSON needs to be **on one line only**.

Required keys are:
- "name" as a String
- "price" as a Double
- "isExempt" as a Boolean
- "isImported" as Boolean

Optional key is:
- "quantity".

This last key, even if it's not necessary for craft an Item, it will be needed for the Shopping Basket.
## Make it run!!!
Do you have the [latest JRE](http://www.oracle.com/technetwork/java/javase/downloads/jre8-downloads-2133155.html)?
Of course you do!

1. Download the exectuable jar file from **dist** directory.
2. Open a terminal
3. type:  java -jar salestaxesproblem.jar
4. follow onscreen instructions.

Please, don't try to feed this software with bad data, if you create a weird JSON, an Exception will be waiting for you.
Same if you put non-numbers in the manual feeding phase, it will just crash.
