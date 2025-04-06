package api;

import util.ConfigLoader;
import util.SignatureGenerator;

public class BaseApi {

    protected static final ConfigLoader configLoader = new ConfigLoader();
    protected static final String PUBLIC_KEY = configLoader.getProperty("user.publicKey");
    protected static final String SECRET_KEY = configLoader.getProperty("user.secretKey");
    private static final String VERSION_1 = "/v1";

    protected static SignatureGenerator generator = new SignatureGenerator();

    public static String getBaseUrl(String baseUrl) {
        if (baseUrl == null || baseUrl.isEmpty()) {
            throw new RuntimeException("Base URL is not configured.");
        }
        return baseUrl + VERSION_1;
    }

}
