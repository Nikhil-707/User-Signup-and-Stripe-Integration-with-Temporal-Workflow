# User-Signup-and-Stripe-Integration-with-Temporal-Workflow



**Description:**
This project implements a user signup process integrated with Stripe for creating customer accounts using a Temporal workflow. It leverages Java Spring Boot for backend development and integrates with the Stripe API for payment processing. The user signup process is orchestrated using Temporal, a workflow orchestration engine, to ensure reliability and fault tolerance.

---

### Setup

#### Installing Java JDK 21.0.2:
- [Download Java JDK 21.0.2](<https://www.azul.com/downloads/?package=jdk#zulu>)

#### Downloading Temporal CLI for Windows:
- Choose the appropriate binary for your system:
  - For Windows (<https://docs.temporal.io/cli#install>)
- Extract the Archive and add the path to the temporal.exe binary to your system's PATH environment variable.
- Verify Configuration: Open a new Command Prompt window and type `temporal` to verify accessibility.

#### Install Docker Desktop:
- [Download Docker Desktop](<https://docs.docker.com/get-docker/>)

---

### Program Approach

#### Project Structure:
```plaintext
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── midas/
│   │           ├── app/
│   │           │   ├── activities/
│   │           │   │   └── UserActivity.java
│   │           │   ├── controllers/
│   │           │   │   └── ApplicationController.java
│   │           │   ├── models/
│   │           │   │   └── UserModel.java
│   │           │   └── utils/
│   │           │       └── StripeIntegration.java
│   │           └── Application.java 
└── test/
    ├── java/
    │   └── com/
    │       └── midas/
    │           ├── app/
    │           │   ├── controllers/
    │           │   │   └── ApplicationControllerTest.java
    │           │   └── utils/
    │           │       └── StripeIntegrationTest.java
    │           └── ApplicationTest.java
    └── resources/
```

---

### Programs Insight and Code

1. **UserActivity.java (in activities package):**
   - Implementation of the Temporal workflow for user signup.
   - Integrates the Stripe Create Customer API to create a new customer in Stripe upon user signup.

2. **ApplicationController.java (in controllers package):**
   - Handles new fields in the user model and manages the user signup process.
   - Updates endpoints to handle user signup and exposes the GET /accounts endpoint for testing.

3. **UserModel.java (in models package):**
   - Adds `providerType` and `providerId` fields to the user model.

4. **StripeIntegration.java (in utils package):**
   - Integrates with the Stripe SDK to interact with the Stripe API for customer creation.

5. **MidasApplication.java:**
   - Main class of the Spring Boot application, containing configuration and startup logic.

6. **ApplicationControllerTest.java (in controllers package under test):**
   - Unit tests to validate the behavior of the `ApplicationController`.

7. **StripeIntegrationTest.java (in utils package under test):**
   - Tests to verify the functionality of the `StripeIntegration` class.



