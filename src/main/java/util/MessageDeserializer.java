package util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import java.io.IOException;
import java.util.Map;

public class MessageDeserializer extends JsonDeserializer<Object> {

    @Override
    public Object deserialize(JsonParser jsonParser, DeserializationContext context) throws IOException {
        if (jsonParser.getCurrentToken().isStructStart()) {
            return jsonParser.readValueAs(Map.class);
        } else if (jsonParser.getCurrentToken().isScalarValue()) {
            return jsonParser.getText();
        }
        return null;
    }
}
