package web.util.json;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion;
import com.networknt.schema.ValidationMessage;
import lombok.SneakyThrows;

import java.io.InputStream;
import java.util.Set;

public class JsonValidatorUtils
{
    private final String jsonSchemaResourcePath;

    public JsonValidatorUtils(String jsonSchemaResourcePath)
    {
        this.jsonSchemaResourcePath = jsonSchemaResourcePath;
    }

    public static JsonValidatorUtils of(String jsonSchemaResourcePath)
    {
        return new JsonValidatorUtils(jsonSchemaResourcePath);
    }

    public Set<ValidationMessage> validate(String body)
    {
        var jsonSchema = getJsonSchemaFromClasspath(jsonSchemaResourcePath);
        var jsonNode = getJsonNodeFromStringContent(body);
        return jsonSchema.validate(jsonNode);
    }

    public void validateWithException(String body)
    {
        var jsonSchema = getJsonSchemaFromClasspath(jsonSchemaResourcePath);
        var jsonNode = getJsonNodeFromStringContent(body);
        jsonSchema.validate(jsonNode).forEach(message ->
        {
            throw new RuntimeException(message.getMessage());
        });
    }

    private static JsonSchema getJsonSchemaFromClasspath(String name)
    {
        JsonSchemaFactory factory = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V4);
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(name);
        return factory.getSchema(is);
    }

    @SneakyThrows
    private JsonNode getJsonNodeFromStringContent(String content)
    {
        return new ObjectMapper().readTree(content);
    }
}
