# Java Style Checker

## Members

* Jae Dong Hwang
* Steven Anderson
* Surya Appini
* Nivetha Sathyarajan
* Kate Maroney

## Tools

* JavaParser
  * Tool to parse source code into an AST for easy analysis

* JavaSymbolSolver
  * Gets you data about the nodes of the AST

* Google Java Style Guide
  * Defines acceptable whitespace, new lines, format, etc.


## Project Definition

* Base Set of Features:
  * Indent checking (Nivetha, Surya)
  * Extra whitespace (Nivetha, Surya)
  * Newlines (Nivetha, Surya)
  * Unused variables, imports, and methods (Kate)

* Smarter Static Checks 
  * variable/method name checking (Steven)
  * Documentation for public methods (Jae)

* Collector Model
  * Object passed to checkers (model/Issue)
  
* Auto-update
  * Fix improper indenting (Steven)
  * Update javadoc (Jae)

* Main.java

## Documents
* User Document
* Developr Document - ![developer document](doc/developer_note.md)
* Evaluation Document

### References:
* https://javaparser.org/
* https://tomassetti.me/getting-started-with-javaparser-analyzing-java-code-programmatically/
