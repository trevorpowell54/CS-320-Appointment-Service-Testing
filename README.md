# CS 320 Portfolio Artifacts: Appointment Service Testing

## Overview

This repository contains my CS 320 appointment service project. It demonstrates my experience with Java programming, object-oriented design, input validation, and unit testing using JUnit.

The appointment service lets you create, store, retrieve, and delete appointments while enforcing specific requirements for appointment IDs, dates, and descriptions.

### Project Files

- **`Appointment.java`** — Defines the appointment object and validates appointment information. Appointment IDs cannot be changed after creation, appointment dates cannot be in the past, and descriptions cannot exceed 50 characters.
- **`AppointmentService.java`** — Manages appointments using a `HashMap`. It supports adding, retrieving, and deleting appointments while preventing duplicate appointment IDs.
- **`AppointmentTest.java`** — Contains unit tests that verify appointment creation, field validation, and updates to appointment dates and descriptions.
- **`AppointmentServiceTest.java`** — Contains unit tests for adding, retrieving, and deleting appointments, including tests for invalid operations.

## Portfolio Reflections

### 1. How can I ensure that my code, program, or software is functional and secure?

I can ensure that my code is functional and secure by testing different situations, validating input, and making sure the program follows its requirements. In this project, I used JUnit tests to check that appointments could be created with valid information and that invalid information was rejected. For example, I tested appointment IDs that were null or too long, dates that were in the past, and descriptions that exceeded the character limit. I also tested the appointment service to make sure it prevented duplicate IDs and handled attempts to delete appointments that did not exist. These tests helped me verify that the program behaved as expected and handled errors appropriately. In future projects, I will continue writing tests throughout development and reviewing my code for potential security and reliability issues.

### 2. How do I interpret user needs and incorporate them into a program?

I interpret user needs by reviewing the requirements and determining what the program must do and what restrictions it needs to follow. In this project, the appointment service had specific rules for appointment IDs, dates, and descriptions. Appointment IDs had to be unique and could not be updated, appointment dates had to be valid future dates, and descriptions could not exceed 50 characters. I used these requirements to develop the appointment class and service methods. I also created tests to check that valid information was accepted and invalid information was rejected. This experience helped me understand the importance of turning requirements into code and test cases so the finished program meets the user's expectations.

### 3. How do I approach designing software?

My approach to designing software is to understand the requirements first, break the program into smaller parts, and determine what responsibilities each part should handle. In this project, the `Appointment` class manages appointment information and validates its fields, while the `AppointmentService` class handles adding, retrieving, and deleting appointments. Separating these responsibilities makes the code easier to understand, test, and maintain. I also consider testing while designing software instead of waiting until the end. By testing individual classes and service methods, I can identify problems earlier and make improvements as needed. I plan to continue using organized code, clear requirements, and appropriate testing strategies in future software development projects.

## What I Learned

This project helped me improve my understanding of Java classes, object-oriented programming, input validation, and automated unit testing. I learned how to use JUnit to test both successful operations and situations where the program should reject invalid information. I also learned that testing is an important part of software development because it helps identify errors and verify that the program meets its requirements.

## Technologies Used

- Java
- JUnit 5
- Object-oriented programming
- Automated unit testing
- Input validation
- Java Collections Framework (`HashMap`)

## Portfolio Purpose

This project is part of my computer science portfolio and demonstrates my ability to develop a Java application, enforce requirements through validation, and create automated tests to verify software behavior. It reflects the skills I developed in CS 320 and my continued focus on writing reliable, maintainable code.
