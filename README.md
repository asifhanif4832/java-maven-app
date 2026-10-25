# Simple Java Maven App

A simple single-page Java Maven application. It uses Java's built-in lightweight HTTP server to serve an interactive web page without requiring external web frameworks.

## Project Structure
```
java-app/
├── pom.xml
└── src/
    └── main/
        └── java/
            └── com/
                └── example/
                    └── App.java
```

## How to Run

1. Navigate to the `java-app` directory:
   ```powershell
   cd "d:\Fyp project\java-app"
   ```

2. Compile and run:
   ```powershell
   mvn compile exec:java
   ```

3. Open your browser:
   Visit [http://localhost:8080](http://localhost:8080) to interact with the application.
