package com.conversion_app;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.Gson;

import io.github.cdimascio.dotenv.Dotenv;

public class UrlDataFetcher {

	private String result;
	private HttpClient httpClient;
	private HttpRequest request;
	private Gson gson;
	private String apiUrl;
	private String API_KEY;

	public UrlDataFetcher() {

		Dotenv dotenv = Dotenv.load();
		API_KEY = dotenv.get("API_KEY");

		httpClient = HttpClient.newHttpClient();

		gson = new Gson();
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String find(String from, String to) {
		apiUrl = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/pair/" + from + "/" + to;
		request = HttpRequest.newBuilder().uri(URI.create(apiUrl)).GET().build();

		try {
			HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
			if (response.statusCode() == 200) {
				ResponseFetchUrl responseBody = gson.fromJson(response.body(), ResponseFetchUrl.class);

				setResult(responseBody.getConversion_rate());
			} else {
				System.out.println("Error al realizar la solicitud. Código de respuesta: " + response.statusCode());
			}
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
		return getResult();
	}

}
