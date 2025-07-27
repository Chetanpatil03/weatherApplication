# 🌦️ Weather App

A simple and responsive weather application built using **Java (JSP + Servlet)** and the **OpenWeatherMap API**. The app allows users to search for any city and view real-time weather conditions like temperature, humidity, wind speed, and weather icons with a clean UI.

## 🔍 Features

- ✅ Search weather by city name
- 📡 Fetches real-time data using  [OpenWeatherMap API](https://openweathermap.org/)
- 🖼️ Dynamic weather icons
- 🕒 Live date and time that auto-updates
- 🌙 Dark mode toggle
- 📱 Fully responsive design (mobile-friendly)
- 🎨 Smooth UI with CSS transitions

## 📷 Screenshot
<img width="1920" height="1080" alt="image" src="https://github.com/user-attachments/assets/b4adae1d-6c7f-447d-b90f-00a6ac63a00a" />



## 💻 Tech Stack

- **Frontend**: HTML, CSS, JavaScript
- **Backend**: Java (Servlets + JSP)
- **API**: OpenWeatherMap
- **Build Tool**: Apache Tomcat (Servlet Container)

## ⚙️ How to Run Locally

1. **Clone the repository**
   <pre>
   git clone https://github.com/Chetanpatil03/weatherApplication.git
   cd your-repo-name
   </pre>
2. **Import into an IDE**
- Open with Eclipse or IntelliJ IDEA
- Choose Java EE / Dynamic Web Project
  
3. **Add to Apache Tomcat**
- Make sure you have Tomcat configured in your IDE.
- Right-click the project → ``Run on Server``

4. **Get Your OpenWeatherMap API Key**
- Sign up at https://openweathermap.org/api
- Replace the ``API key`` in your servlet code.

5. **Run**
- Open in browser:`` http://localhost:8080/WeatherApp/``

# 📁 Project Structure
<pre>
  
WeatherApp/
├── build/classes/myPakage/
├── src/
│ └── main/
│ ├── java/myPakage/
│ │ └── myServlet.java
│ └── webapp/
│ ├── META-INF/
│ ├── WEB-INF/
│ │ ├── lib/
│ │ │ └── gson-2.8.5.jar
│ │ └── web.xml
│ ├── images/
│ ├── index.jsp
│ ├── index.html
│ └── style.css
├── .classpath
└── .project

</pre>

## 🔐 Dependencies
- ```gson-2.8.5.jar``` → Placed in WEB-INF/lib for JSON parsing

### 📬 Contact
Made with ❤️ by Chetan
- 📫 Feel free to connect via GitHub or LinkedIn


