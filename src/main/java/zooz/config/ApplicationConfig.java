package zooz.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by stas.panchenko on 24/06/2017.
 */
@Component
@ConfigurationProperties("server")
public class ApplicationConfig {
    private String apiKey;

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    @Override
    public String toString() {
        return "ApplicationConfig{" +
                "apiKey='" + apiKey + '\'' +
                '}';
    }
}
