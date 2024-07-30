package EAGLE04.demo.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PapagoConfig {
    @Value("${PAPAGO.TRANSLATE.KEY}")
    private String apiKey;

    @Value("${PAPAGO.TRANSLATE.ID}")
    private String apiId;

    public static final String
            CONTENT_TYPE = "application/json;";

    public static final String KEY_NAME = "X-NCP-APIGW-API-KEY";
    public static final String ID_NAME = "X-NCP-APIGW-API-KEY-ID";

    public static final String source = "ko";
    public static final String target = "en";

    public static final String URL = "https://naveropenapi.apigw.ntruss.com/nmt/v1/translation";


    public String getApiKey() {
        return apiKey;
    }

    public String getApiId() {
        return apiId;
    }


}
