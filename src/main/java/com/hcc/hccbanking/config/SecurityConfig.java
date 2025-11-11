package com.hcc.hccbanking.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.web.SecurityFilterChain;

import java.util.*;
import java.util.stream.Collectors;

@Configuration
public class SecurityConfig {

    @Value("${keycloak.client-id}")
    private String clientId;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/v1/admin/**").hasRole("ADMIN")
                        .requestMatchers("/api/v1/user/**").hasRole("USER")
                        .requestMatchers("/api/v1/adminuser/**").hasRole("ADMINUSER")
                        .anyRequest().authenticated()
                )
                .oauth2ResourceServer(oauth2 -> oauth2.jwt(jwt -> jwt.jwtAuthenticationConverter(jwtAuthenticationConverter())));

        return http.build();
    }

    @Bean
    public JwtAuthenticationConverter jwtAuthenticationConverter() {
        JwtAuthenticationConverter converter = new JwtAuthenticationConverter();
        converter.setJwtGrantedAuthoritiesConverter(this::extractRoles);
        return converter;
    }

    private Collection<GrantedAuthority> extractRoles(Jwt jwt) {
        Set<String> roles = new HashSet<>();

        // Extract roles from realm_access
        extractRolesFromClaim(jwt, "realm_access", roles);

        // Extract roles from resource_access for client
        extractRolesFromClient(jwt, clientId, roles);

        return roles.stream()
                .map(this::toAuthority)
                .collect(Collectors.toSet());
    }

    @SuppressWarnings("unchecked")
    private void extractRolesFromClaim(Jwt jwt, String claimName, Set<String> roles) {
        Object claimObj = jwt.getClaim(claimName);
        if (claimObj instanceof Map<?, ?> map) {
            Object rolesObj = map.get("roles");
            if (rolesObj instanceof Collection<?> collection) {
                collection.stream()
                        .map(Object::toString)
                        .forEach(roles::add);
            }
        }
    }

    @SuppressWarnings("unchecked")
    private void extractRolesFromClient(Jwt jwt, String clientId, Set<String> roles) {
        Object resourceAccessObj = jwt.getClaim("resource_access");
        if (resourceAccessObj instanceof Map<?, ?> resourceAccess) {
            Object clientObj = resourceAccess.get(clientId);
            if (clientObj instanceof Map<?, ?> clientMap) {
                Object clientRolesObj = clientMap.get("roles");
                if (clientRolesObj instanceof Collection<?> clientRoles) {
                    clientRoles.stream()
                            .map(Object::toString)
                            .forEach(roles::add);
                }
            }
        }
    }

    private GrantedAuthority toAuthority(String roleName) {
        String normalizedRole = roleName.toUpperCase(Locale.ROOT);
        if (!normalizedRole.startsWith("ROLE_")) {
            normalizedRole = "ROLE_" + normalizedRole;
        }
        return new SimpleGrantedAuthority(normalizedRole);
    }
}
