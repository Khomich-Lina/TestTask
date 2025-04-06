package dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import util.MessageDeserializer;

public class ErrorResponseDto {

    private Error error;

    @JsonProperty("message")
    @JsonDeserialize(using = MessageDeserializer.class)  // Custom deserializer
    private Object message;  // Could be a Map or a String

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }

    // Error class to handle the detailed structure with field-specific validation messages
    public static class Error {
        private String code;
        private Object message;  // For holding both String and Map

        // Getters and setters
        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public Object getMessage() {
            return message;
        }

        public void setMessage(Object message) {
            this.message = message;
        }
    }
}
