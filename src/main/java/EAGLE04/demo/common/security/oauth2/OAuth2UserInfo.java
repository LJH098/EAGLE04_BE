package EAGLE04.demo.common.security.oauth2;

import java.util.Map;

public interface OAuth2UserInfo {
    String getProvider();
    String getProviderId();
    String getEmail();
    String getName();
    Map<String,Object> getAttributes();
}
