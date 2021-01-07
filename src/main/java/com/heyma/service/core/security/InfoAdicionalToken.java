package com.heyma.service.core.security;

import com.heyma.service.core.model.entity.security.User;
import com.heyma.service.core.service.security.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
public class InfoAdicionalToken implements TokenEnhancer {

    @Autowired
    private UserService userService;

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        Optional<User> user = userService.findByUsername(authentication.getName());
        Map<String, Object> info = new HashMap<>();
        info.put("info_adicional", "Hola que tal!: ".concat(authentication.getName()));
        info.put("id", user.get().getId());
        info.put("completeName", user.get().getCompleteName());
        info.put("email", user.get().getEmail());

        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);

        return accessToken;
    }

}
