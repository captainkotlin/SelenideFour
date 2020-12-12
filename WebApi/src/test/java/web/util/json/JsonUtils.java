package web.util.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.path.json.JsonPath;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;

public class JsonUtils
{
    @SneakyThrows
    public static Object toJsonObject(Object o)
    {
        String str = new ObjectMapper().writeValueAsString(o);
        return toJsonObject(str);
    }

    public static Object toJsonObject(String body)
    {
        return new JsonPath(body).getObject(StringUtils.EMPTY, Object.class);
    }
}
