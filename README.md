# 🌤️ Weather Monitoring Application

A modern, real-time weather monitoring application built with **Spring Boot**, fetching live weather data from the **OpenWeatherMap API** and displaying it in a beautifully styled dashboard.

![Weather Monitoring](https://github.com/UmangSonthaliya/weatherapp/raw/main/screenshot.png)

## 🚀 Features
- 🔄 **Real-time Weather Updates**: Fetches live weather data every 5 minutes.
- 🌐 **Multiple Cities**: Displays weather for **Delhi**, **Mumbai**, **Chennai**, **Bengaluru**, **Kolkata**, and **Hyderabad**.
- 💾 **Persistent Storage**: Weather data is stored in a MySQL database.
- 📊 **User-Friendly UI**: Clean and responsive design for easy weather data visualization.
- 🛠️ **Custom Error Handling**: Graceful error handling for API or connection issues.

---

## 🛠️ Tech Stack

**Backend**:
- [Java 17](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html)
- [Spring Boot](https://spring.io/projects/spring-boot) (REST, Scheduling, Data JPA)
- [Hibernate ORM](https://hibernate.org/orm/)
- [MySQL](https://www.mysql.com/)

**Frontend**:
- [HTML](https://developer.mozilla.org/en-US/docs/Web/HTML)
- [CSS](https://developer.mozilla.org/en-US/docs/Web/CSS)

**APIs**:
- [OpenWeatherMap API](https://openweathermap.org/api)

---

## 🏗️ Setup Instructions

### Prerequisites:
- Java 17+
- Maven 3.6+
- MySQL (locally or cloud-based)
- OpenWeatherMap API key (sign up [here](https://home.openweathermap.org/users/sign_up))

### ⚙️ Installation Steps:

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/UmangSonthaliya/weatherapp.git
   cd weatherapp

**Key Functionality**
Weather Data Fetching: Scheduled to run every 5 minutes, fetching data using Spring's @Scheduled annotation.
MySQL Persistence: Weather data for each city is stored in a MySQL database with unique constraints on city and timestamp to avoid duplication.
Responsive Design: Frontend is built with basic HTML and CSS, ensuring a responsive design that looks good on all devices.

**💡 How It Works**
Backend:
The application fetches weather data from OpenWeatherMap for a list of cities.
It stores the weather information (temperature, condition, timestamp) in a MySQL database.
Frontend:
A simple HTML page displays the data in a grid, showing real-time weather updates for each city.
📦 API Integration
This project integrates with the OpenWeatherMap API to fetch the latest weather data. You need to register and get an API key from OpenWeatherMap to use in the application.



