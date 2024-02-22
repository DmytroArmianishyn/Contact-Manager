# Contact Manager Documentation

## Overview
The Contact Manager is a Java application designed to manage a list of contacts. It allows users to add, delete, search, and sort contacts by various criteria. The application supports two types of contacts: individuals (User) and companies.

## Features
- **Add Contact**: Users can add a new contact to the contact list, specifying the contact type (individual or company), name, phone number, email, and additional information such as surname, birthdate (for individuals), or type of company (for companies).
- **Delete Contact**: Users can delete a contact from the contact list by specifying the contact's phone number.
- **Search Contact**: Users can search for a contact by phone number or name.
- **Sort Contacts**: Users can sort the contact list by phone number or name.
- **Print Contacts**: Users can print the entire list of contacts.

## Design Patterns Used
The Contact Manager application incorporates the following design patterns:

- **Singleton Pattern**: Ensures that there is only one instance of the Owner class throughout the application.
- **Builder Pattern**: Simplifies the construction of complex objects (Contact instances) by separating the construction process from its representation.
- **Factory Method Pattern**: Provides an interface for creating objects (Contact instances) in a superclass, but allows subclasses to alter the type of objects that will be created.
- **Iterator Pattern**: Provides a way to access the elements of an aggregate object (the contact list) sequentially without exposing its underlying representation.

## Usage
To use the Contact Manager application, follow these steps:

1. Run the Main class.
2. Choose from the available options to add, delete, search, sort, or print contacts.

## Dependencies
- Java 8 or higher

## Contributors
- **Armianishyn Dmytro**

