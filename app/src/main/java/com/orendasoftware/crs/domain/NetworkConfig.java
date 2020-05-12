package com.orendasoftware.crs.domain;

public class NetworkConfig {

    public static final int CONNECTION_TIMEOUT = 15; // 15 seconds
    public static final int READ_TIMEOUT = 15; // 15 seconds
    public static final String BASE_URL = "https://krishna";
    public static final String CONTENT_TYPE = "application/vnd.nets.v5+json";
    public static final String HEADER_CONTENT_TYPE = "Content-Type: " + CONTENT_TYPE;
}
