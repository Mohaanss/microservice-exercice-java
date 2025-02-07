package com.example.gatewayapp.components;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class AuthenticationFilter implements GlobalFilter, Ordered {

    @Value("${jwt.secret}")
    private String secret;
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // Récupère le chemin de la requête
        String path = exchange.getRequest().getURI().getPath();

        // Si on est sur la route /api/auth/login, on passe le filtre
        if ("/auth-pg-api/api/auth/login".equals(path) || "/auth-pg-api/api/auth/register".equals(path)) {
            return chain.filter(exchange);
        }

        // Pour les autres routes, vérifie la présence d'un header Authorization avec Bearer token
        String authHeader = exchange.getRequest().getHeaders().getFirst("Authorization");
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            // Pas de token ou token mal formé : renvoyer un statut UNAUTHORIZED
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }

        // Ici, vous pouvez éventuellement extraire et valider le token
        String token = authHeader.substring("Bearer ".length());
        try {
            validateToken(token);
        } catch (JwtException e) {
            // En cas d'erreur (token invalide, expiré, ou signature incorrecte), on renvoie une réponse 401 Unauthorized
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }
        // Si tout est OK, passe la requête au chain filter
        return chain.filter(exchange);
    }

    // Vous pouvez définir l'ordre du filtre (plus il est petit, plus il est exécuté tôt)
    @Override
    public int getOrder() {
        return -1;
    }
    private void validateToken(String token) {
        Jwts.parser().setSigningKey(secret).build().parseSignedClaims(token);
    }
}
