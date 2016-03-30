# CS200---Token-Iterator
Source code for the P3 token iterator

DESIGN SPECIFICATIONS:

TokenIter

You need to build an iterator TokenIter, that scans an input line character by character and produces Strings (nextToken is an instance variable in TokenIter that is supposed to contain the next token if there is one and null it there is none). Valid tokens are:
  “true”, “false”, “^” “&”, “!”, “(”, “)”
Invalid tokens should be discarded. If the input line is e.g.:
  true & ! (false ^ true)
the strings produced by subsequent calls to the next() method of a TokenIter should be:
  "true", "&", "!", "(", "false", "^", "true", ")".
  1:! means boolean NOT (highest precedence operator)
  2:& means boolean AND
  3:^ means boolean EXCLUSIVE OR (lowest precedence operator) 
(true if exactly one of the operands is true)
Examples of valid input lines are:
true

true false
true^false
true ^ false
      true      ^      false
! (   ! (true &    false))
The first input line contains the simple logic expression "true".
The second input line is empty and demonstrates that your program needs to handle empty inputs properly.
The third demonstrates that adjacent alphabetic tokens must be separated by one or more spaces.
The remaining lines show that spaces are allowed anywhere, (well, not inside the words "true" and "false") but are only required as specified in the previous item.
Implement the constructor, hasNext(), and next(). The remove method has been provided. Don't change it. The provided main method exercises TokenIter; it prints the input line and every next token surrounded by square brackets, to show white space, or the lack thereof.
When properly implemented

javac TokenIter.java
java TokenIter
should produce the following output:
line: [ ! BAD (true ^ false) % truelybad]
next token: [!]
next token: [(]
next token: [true]
next token: [^]
next token: [false]
next token: [)]
Notice that invalid tokens are skipped.
