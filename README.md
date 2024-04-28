# Java Financial System Simulation

## Overview

This project is a Java-based simulation demonstrating interactions within a financial system, including transactions between customers, stores, banks, and employees. 

It features object-oriented programming concepts and synchronization mechanisms to handle multi-threaded operations safely.

Made for the Concurrent and distributed programming class lectured at Universidade Católica de Brasília.

## Modules

- Customer: Represents a customer who makes purchases from stores. Each customer operates in their own thread, simulating concurrent purchases.
- Account: Manages the financial balance. Contains methods to deposit, withdraw, and check the balance.
- Store: Manages store operations. Each store has an account and is associated with a bank and multiple employees. Stores handle purchase transactions and pay salaries.
- Bank: Simulates a bank's operations (the Bank.java file was not provided, but its presence is assumed in other classes).
- Employee: Represents an employee working at a store. Each employee has a salary and an investment account.
- Main: Entry point for the simulation, setting up stores, customers, and initiating the transaction processes.


## Running the Simulation

1. Ensure Java is installed on your machine.
2. Compile the project using javac Main.java (make sure all files are in the same directory or properly referenced).
3. Run the simulation using java Main.
