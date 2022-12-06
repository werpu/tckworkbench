# tckworkbench

## Introduction
This project is a small fork of the 
jakarta faces ajax TCK tests for development purposes

It uses an embedded Tomcat server to run the
tests in conjunction with a Selenium Webdriver.

Parts of it hopefully will make it back
into the official TCK tests!

The advantage over the official TCK tests is
that you can test html5/ES2015 code with this
combination (test engine chrome), whereas
the official TCK tests use HTMLUnit which is
atm stuck on ES5 level.


## Setup

Atm Apache myfaces/openwebbeans are the JSF/CDI implementation used
you can change it by replacing the dependency
in the main pom.xml

The Tests are run the usual Maven way

### Requirements

* Java 11 
* Maven latest version
* A working chrome installation on the test machine reachable via a path config
