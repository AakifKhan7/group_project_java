# Restaurant Management System

## Overview

This is a simple Java-based console application that simulates a virtual restaurant management system. It allows a user to act as either a Manager or a Customer. Customers can view menus, place orders, and make payments, while Managers can add, remove, and update food items.

## Features

* **Customer Module:**
  * Select vegetarian or non-vegetarian food items from a predefined menu.
  * Place orders and generate a bill.
  * Choose a payment method (Credit Card, Debit Card, Net Banking, UPI, Cash).
* **Manager Module:**
  * Add, remove, and update food items from the menu.

## Classes

### 1. `Restaurant`

* The main class that runs the application.
* Provides options for selecting Manager or Customer.

### 2. `Customer`

* Handles customer interactions.
* Displays menus and processes orders.
* Implements payment options.

### 3. `Menu`

* Stores vegetarian and non-vegetarian food menus.
* Provides methods to display menus.

### 4. `Bill`

* Calculates the total bill for the customer.

### 5. `Payment`

* Manages different payment methods (Cash, Card, UPI, etc.).

### 6. `Manager`

* Provides options to add, remove, and update food items in the menu.

## How to Run

1. Compile the program using `javac Restaurant.java`
2. Run the program using `java Restaurant`
3. Follow the on-screen instructions to navigate the system.

## Future Enhancements

* Improve menu management (dynamic menu storage).
* Implement an actual database for storing food items.
* Add user authentication for Manager access.
* Introduce a graphical user interface (GUI).

## Author

Aakifkhan, Ronit, Neel
