package org.example;

import com.bettercloud.vault.Vault;
import com.bettercloud.vault.VaultConfig;
import com.bettercloud.vault.VaultException;
import com.bettercloud.vault.response.LogicalResponse;
//import jdk.internal.org.jline.utils.ExecHelper;
import org.springframework.vault.authentication.TokenAuthentication;
import org.springframework.vault.client.VaultEndpoint;
import org.springframework.vault.core.VaultKeyValueOperations;
import org.springframework.vault.core.VaultKeyValueOperationsSupport;
import org.springframework.vault.core.VaultTemplate;
import org.springframework.vault.support.VaultResponse;
import org.springframework.vault.support.VaultResponseSupport;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws Exception {
//        VaultConfig config = new VaultConfig()
//                .address("") // URL вашего Vault сервера
//                .token("") // Ваш токен аутентификации
//                .engineVersion(1)
//                .build();
//
//        // Инициализация клиента Vault
//        Vault vault = new Vault(config);
//
//        // Получение секрета
//        LogicalResponse response = vault.logical()
//                .read(""); // Путь к вашему секрету
//
//        // Вывод данных секрета
//        System.out.println(response.getData());
//        String vaultAddress = "";
//        String token = "";
//        String secretPath = "";
//
//        // Создание HTTP-клиента
//        HttpClient client = HttpClient.newHttpClient();
//
//        // Создание HTTP-запроса
//        HttpRequest request = HttpRequest.newBuilder()
//                .uri(URI.create(vaultAddress + "/v1/" + secretPath))
//                .header("X-Vault-Token", token) // Токен Vault для аутентификации
//                .GET()
//                .build();
//
//        // Отправка запроса и получение ответа
//        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
//
//        // Вывод тела ответа
//        System.out.println(response.body());

        VaultClient vaultClient = new VaultClient();
        try {
            // Получение секрета
            String secret = vaultClient.getSecret("");
            System.out.println("Secret: " + secret);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static class Secrets {

        String username;
        String password;

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }
    }
}
