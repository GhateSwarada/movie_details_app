# Movie Details Application

This is a web application built with Spring Boot that allows users to view details about various movies. It leverages Thymeleaf for server-side templating to dynamically render HTML pages, providing a rich user experience for exploring movie information.

## 🌟 Features

* **View Movie Details:** Displays comprehensive information for each movie, including title, description, release date, genre, and ratings.

* **Responsive UI:** Built with HTML and CSS to ensure a clean and user-friendly interface across different devices.

* **Spring Boot Backend:** Provides a robust and scalable backend for handling data retrieval and application logic.

* **Thymeleaf Integration:** Seamlessly integrates backend data with frontend templates for dynamic content generation.

## 🚀 Technologies Used

* **Spring Boot:** A powerful framework for building stand-alone, production-grade Spring applications.

* **Thymeleaf:** A modern server-side Java template engine for both web and standalone environments.

* **HTML5:** The standard markup language for creating web pages.

* **CSS3:** Used for styling the web application, ensuring a visually appealing design.

* **Java:** The primary programming language used for the backend logic.

* **Maven (or Gradle):** For dependency management and build automation.

## 🛠️ Getting Started

Follow these instructions to get a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

* Java Development Kit (JDK) 8 or higher

* Maven (or Gradle, if used as the build tool)

* An IDE like IntelliJ IDEA, Eclipse, or VS Code with Spring Boot extensions

### Installation

1.  **Clone the repository:**

    ```bash
    git clone [https://github.com/GhateSwarada/movie_details_app.git](https://github.com/GhateSwarada/movie_details_app.git)
    ```

2.  **Navigate into the project directory:**

    ```bash
    cd movie_details_app
    ```

3.  **Build the project (using Maven):**

    ```bash
    mvn clean install
    ```

### Running the Application

1.  **From your IDE:**

    * Open the project in your preferred IDE (e.g., IntelliJ IDEA).

    * Locate the main application class (e.g., `MovieDetailsAppApplication.java`).

    * Run the `main` method from the IDE.

2.  **From the command line:**

    * After building the project, navigate to the `target` directory.

    * Run the JAR file:

        ```bash
        java -jar movie_details_app-0.0.1-SNAPSHOT.jar # Adjust version if different
        ```

The application will typically start on `http://localhost:8080`.

## 🖥️ Usage

Once the application is running, open your web browser and navigate to `http://localhost:8080` (or the port your application is configured to use). You will be able to browse and view details of movies displayed by the application.

