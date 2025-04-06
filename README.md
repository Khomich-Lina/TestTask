# 🧪 TestTask Project

## 📜 About This Project

Welcome to the **TestTask** repository! This project is designed to demonstrate the creation of automated tests for a **payment processing API**. The primary aim is to ensure that the payment flow works as expected, both from the **backend** (API testing) and **frontend** (UI testing).

### Key Features:
- **API Testing**: Validates API endpoints for payment creation, order status, and payment processing.
- **UI Testing**: Simulates user interactions for the payment process (e.g., entering payment details, confirming transactions).
- **Test Framework**: Uses **JUnit** for test execution and **Selenide** for UI interactions.
- **Assertions**: Built with **AssertJ** to keep tests simple, readable, and maintainable.

## 🚀 Setup Instructions

To get the project up and running, follow these steps:

### Prerequisites

- **Java 21** (or compatible version)
- **Maven 3.x.x** or higher

### Steps to Run the Project

1. **Clone the repository**:
   ```bash
   git clone https://github.com/Khomich-Lina/TestTask.git

2. **Install dependencies: To install the project dependencies, use Maven**:
    ```bash
    mvn clean install

3. **Run the tests: After installing the dependencies, you can run the tests:**:
    ```bash
    mvn test

Once the tests are executed, you will see the results printed in the console.

## 💡 Features for Improvement

1. **Add Allure Reporting**:

2. **Improve the exception handling in the tests to handle edge cases better**

3. **Increase Test Coverage to include more edge cases and different user scenarios**

4. **Improve Logging**

5. **Optimize Test Performance and parallel when it's needed**

6. **Implement Continuous Integration**