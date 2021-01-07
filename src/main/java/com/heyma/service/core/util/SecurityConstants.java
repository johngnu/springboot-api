package com.heyma.service.core.util;

public class SecurityConstants {

    public static final long EXPIRATION_TIME_FORGOT = 300_000; // 5 minute
    // public static final long EXPIRATION_TIME = 1800_000; // 30 minute
    public static final long EXPIRATION_TIME = 86400_000; // 24 hours //1800-30 minute
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";

    public static final String LOGOUT_URL = "/v1/cerrarsesion";
    public static final String FORGOT_URL = "/v1/restablecercontrasenia";
    public static final String RESET_URL = "/v1/confirmarcontrasenia";
    public static final String LOGIN_CIUDIG_URL = "/v1/iniciarsesionciudig";
    public static final String INDEX_URL = "/";
}