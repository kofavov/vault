package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class VaultClient {
    private static final String VAULT_URL = "";
    private static final String TOKEN = "";

    public String getSecret(String path) throws Exception {
        URL url = new URL(VAULT_URL + "/v1/" + path);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("X-Vault-Token", TOKEN);

        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            return response.toString();
        } else {
            throw new RuntimeException("Failed : HTTP error code : " + responseCode);
        }
    }
}
