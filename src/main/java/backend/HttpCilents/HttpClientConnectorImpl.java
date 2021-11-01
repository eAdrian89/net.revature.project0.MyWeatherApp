package backend.HttpCilents;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpClientConnectorImpl implements HttpClientConnector{

    @Override
    public String initializeHttpConnection(String URL) {

        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(URL))
                .version(HttpClient.Version.HTTP_2)
                .GET()
                .build();


        try {
            HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            String responseBody = httpResponse.body();

            return responseBody;

        } catch (IOException | InterruptedException e) {
            System.err.println("Cannot initialize HTTP connection");
        }

        return null;
    }
}
