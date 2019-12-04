# assessment-calculator

A simple command-line calculator written in Java.

This project is used for assessment of Java Developers.

Please review the code and suggest improvements (if any).

## Review Story

I am a Software Developer and you are my Reviewer.

Our boss has given me the task to develop a little command-line calculator.

The application has a class `CalculatorApplication` with a `main()` method.

The application follows a service-oriented design.

Two services are available:
* `NumberService` converts strings into numbers
* `CalculatorService` does the actual calculations

The contract as described by our Boss is documented in the
Java interfaces.

Everything is of course unit-tested and the application is well tested
and works perfectly.

Please review the code and suggest improvements.


## Build

To test and run the command-line application use the following commands: 

```console
./gradlew test
```


```console
./gradlew install

./build/install/assessment-calculator/bin/assessment-calculator 2 + 3
```

The output of the last command should be:
```
Result: 5.0

```


