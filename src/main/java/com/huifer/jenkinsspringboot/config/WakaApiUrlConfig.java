package com.huifer.jenkinsspringboot.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * waka API配置
 * @Date: 2019-09-29
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "wakatime")
public class WakaApiUrlConfig {
    private String baseUrl;
    private String clientId;
    private String secretApiKey;
    private String oauthUrl;
    private String userInfoUrl;
    private String durationUrl;
    private String heartUrl;
    private String projectUrl;
    private String summaryUrl;
    private String projectDetail;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"baseUrl\":\"")
                .append(baseUrl).append('\"');
        sb.append(",\"clientId\":\"")
                .append(clientId).append('\"');
        sb.append(",\"secretApiKey\":\"")
                .append(secretApiKey).append('\"');
        sb.append(",\"oauthUrl\":\"")
                .append(oauthUrl).append('\"');
        sb.append(",\"userInfoUrl\":\"")
                .append(userInfoUrl).append('\"');
        sb.append(",\"durationUrl\":\"")
                .append(durationUrl).append('\"');
        sb.append(",\"heartUrl\":\"")
                .append(heartUrl).append('\"');
        sb.append(",\"projectUrl\":\"")
                .append(projectUrl).append('\"');
        sb.append(",\"summaryUrl\":\"")
                .append(summaryUrl).append('\"');
        sb.append(",\"projectDetail\":\"")
                .append(projectDetail).append('\"');
        sb.append('}');
        return sb.toString();
    }
}
