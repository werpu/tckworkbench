# tckworkbench

## Introduction
This project is a small fork of the 
Jakarta Faces Ajax TCK tests for development purposes.

It uses an embedded Tomcat server, to run the
tests in conjunction with a Selenium Webdriver.

Parts of it hopefully will make it back
into the official TCK tests!

The advantage over the official TCK tests is,
that you can test HTML5/ES2015 code with this
combination (test engine Chrome), whereas
the official TCK tests use HTMLUnit, which is
atm stuck on ES5 level.


## Setup

Atm Apache MyFaces/Openwebbeans are the JSF/CDI implementation used
you can change it by replacing the dependency
in the main pom.xml

The Tests are run the usual Maven way (clean install, or test)

### Requirements

* Java 11 
* Maven latest version
* A working Chrome installation on the test machine reachable via a path config
