package org.example.config;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.auth.http.HttpCredentialsAdapter;
import com.google.auth.oauth2.GoogleCredentials;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.InputStream;
import java.util.Collections;

@Configuration
public class GoogleSheetsConfig {

    @Bean
    public Sheets sheetsService() throws Exception {

        InputStream inputStream = getClass()
                .getClassLoader()
                .getResourceAsStream("credentials.json");

        GoogleCredentials credentials =
                GoogleCredentials.fromStream(inputStream)
                        .createScoped(
                                Collections.singleton(
                                        SheetsScopes.SPREADSHEETS_READONLY
                                )
                        );

        HttpRequestInitializer requestInitializer =
                new HttpCredentialsAdapter(credentials);

        return new Sheets.Builder(
                GoogleNetHttpTransport.newTrustedTransport(),
                GsonFactory.getDefaultInstance(),
                requestInitializer
        )
                .setApplicationName("avito-tracking")
                .build();
    }
}