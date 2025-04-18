package util;

import com.google.common.hash.Hashing;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class SignatureGenerator {

    private String generateSignature(String publicKey, String jsonString, String secretKey) {
        String text = publicKey + jsonString + publicKey;
        byte[] hashedBytes = Hashing.hmacSha512(secretKey.getBytes())
                .hashString(text, StandardCharsets.UTF_8).toString().getBytes();
        return Base64.getEncoder().encodeToString(hashedBytes);
    }

    public String getSignature(String publicKey, String requestBody, String secretKey) {
        return generateSignature(publicKey, requestBody, secretKey);
    }

}
