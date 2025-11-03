# REST API Client - CodTech Internship Task 2

This is a simple Java console application created for the **CodTech Internship Task 2**. It functions as a REST API client that fetches and displays current weather data from the public Open-Meteo API based on user-provided latitude and longitude.

## 🚀 Features

* Prompts the user to enter a latitude and longitude.
* Builds and sends an HTTP GET request to the Open-Meteo weather API.
* Consumes the public REST API (`api.open-meteo.com`).
* Parses the JSON response using the Jackson library.
* Displays the current weather in a structured format:
    * Temperature (°C)
    * Wind Speed (m/s)
    * Wind Direction (°)
    * Time of the reading

## 🛠️ Technologies Used

* **Java 17**
* **Maven** (for dependency management)
* **java.net.http.HttpClient** (Java's built-in client for HTTP requests)
* **Jackson (databind)** (for parsing JSON responses)

## 📋 Prerequisites

Before you begin, ensure you have the following installed on your system:
* [Java Development Kit (JDK) 17 or newer](https://www.oracle.com/java/technologies/downloads/)
* [Apache Maven](https://maven.apache.org/download.cgi)

## ⚡ How to Run

1.  **Clone the repository:**
    ```sh
    git clone [https://github.com/bhakti22004/RestApiClient.git](https://github.com/bhakti22004/RestApiClient.git)
    ```

2.  **Navigate to the project directory:**
    ```sh
    cd RestApiClient
    ```

3.  **Compile the project using Maven:**
    *(This will also download the required Jackson dependency)*
    ```sh
    mvn compile
    ```

4.  **Run the application:**
    ```sh
    mvn exec:java -Dexec.mainClass="com.example.rest.RestClient"
    ```

5.  **Follow the prompts** in your console to enter a latitude and longitude:
    ```
    === REST API CLIENT (Weather Example) ===
    Enter latitude (e.g., 35): 
    Enter longitude (e.g., 139): 
    ```

### Example Output
