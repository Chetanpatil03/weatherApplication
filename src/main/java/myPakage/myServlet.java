package myPakage;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.Date;
//import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
//import com.sun.org.apache.xerces.internal.impl.dv.xs.DateTimeDV;

/**
 * Servlet implementation class myServlet
 */
@WebServlet("/myServlet")
public class myServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public myServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.sendRedirect("index.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.setCharacterEncoding("UTF-8");

		// API Key
		String apiKey = "6b53df28f215b0f8ad309e078ba5c1e6";
		// Get the city from the form input
		String city = URLEncoder.encode(request.getParameter("city"), "UTF-8");



		// Create the URL for the OpenWeatherMap API request
		String apiUrl = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apiKey;

		try {
			
			URL url = new URL(apiUrl);

			// api integration
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");

			// reading data from network
			InputStream inputStream = conn.getInputStream();
			InputStreamReader reader = new InputStreamReader(inputStream);

			// to store the data in string (mutable)

			StringBuilder responseContent = new StringBuilder();

			// scanner object to get input from reader
			Scanner sc = new Scanner(reader);

			while (sc.hasNext()) {
				responseContent.append(sc.nextLine());
			}

//			System.out.println(responseContent);

			sc.close();

			// Type casting / parsing the data from json set

			Gson gson = new Gson();
			JsonObject jsonObject = gson.fromJson(responseContent.toString(), JsonObject.class);

//			System.out.println(jsonObject);

			// date and current timestamp
			long dateTimestamp = jsonObject.get("dt").getAsLong() * 1000;
            String date = new Date(dateTimestamp).toLocaleString(); // add to string

			// getting temperature as kelvin
			double temperatureKelvin = jsonObject.getAsJsonObject("main").get("temp").getAsDouble(); // add
																										// getAsDouble()
			// converting kelvin to celsius
			int temperatureCelsius = (int) (temperatureKelvin - 275.15);

			// getting humadity from json object
			int humidity = jsonObject.getAsJsonObject("main").get("humidity").getAsInt(); // add getAsInt();

			// windspeed
			double windSpeed = jsonObject.getAsJsonObject("wind").get("speed").getAsDouble();

			// weathercondition current it is in an array converting it to json object and
			// then string.
			String weatherCondition = jsonObject.getAsJsonArray("weather").get(0).getAsJsonObject().get("description").getAsString(); // add
																													// getAsString();
			
			System.out.println(weatherCondition);

//			set the data that are parsed as a attribute.
//			 sending to jsp

			request.setAttribute("date", date);
			city = URLDecoder.decode(city, "UTF-8");
			request.setAttribute("city", city);
			request.setAttribute("temperature", temperatureCelsius);
			request.setAttribute("weatherCondition", weatherCondition);
			request.setAttribute("humidity", humidity);
			request.setAttribute("windSpeed", windSpeed);
			request.setAttribute("weatherData", responseContent.toString());

			conn.disconnect();

		} catch (IOException e) {
			e.printStackTrace();
		}
		

		request.getRequestDispatcher("index.jsp").forward(request, response);

	}

}
