# Java Bank System

A command-line banking simulator written in plain Java. Shows object-oriented design with inheritance, method overriding and custom exceptions.

## Features
- Savings accounts (with interest) and checking accounts (with overdraft)
- Deposit, withdraw and transfer between accounts
- Custom `InsufficientFundsException`
- Input validation

## Concepts used
Inheritance, polymorphism, method overriding, custom exceptions, `ArrayList`.

## Run
Requires JDK 11+.

```bash
mkdir out
javac -d out src/*.java
java -cp out Main
```

## Account rules
| Type     | Rule                              |
|----------|-----------------------------------|
| Savings  | Cannot go below 0, 2.5% interest  |
| Checking | Overdraft up to 100               |

## Project structure
```
src/
  Main.java                       menu loop
  Bank.java                       holds accounts, transfers
  Account.java                    base class
  SavingsAccount.java             adds interest
  CheckingAccount.java            adds overdraft
  InsufficientFundsException.java custom exception
```

## Possible improvements
- Save accounts to a file
- Transaction history
- Unit tests with JUnit
