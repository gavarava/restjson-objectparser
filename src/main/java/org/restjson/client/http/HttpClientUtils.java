package org.restjson.client.http;

import com.google.common.io.CharStreams;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class HttpClientUtils {

    public static String readURLResponseAsString(String url) {
        HttpGet request = new HttpGet(url);
        try (CloseableHttpClient httpClient = HttpClientBuilder.create().build()) {
            final CloseableHttpResponse execute = httpClient.execute(request);
            InputStream stream = execute.getEntity().getContent();
            return convertToString(stream);
        } catch (IOException e) {
           throw new RuntimeException("Invalid URL", e);
        }
    }

    private static String convertToString(InputStream inputStream) throws IOException {
        String result = null;
        try (final Reader reader = new InputStreamReader(inputStream)) {
            result = CharStreams.toString(reader);
        }
        return result;
    }
}
