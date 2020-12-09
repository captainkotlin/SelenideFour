package web.util;

import io.restassured.common.mapper.TypeRef;
import io.restassured.http.Cookie;
import io.restassured.http.Cookies;
import io.restassured.http.Headers;
import io.restassured.mapper.ObjectMapper;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.path.json.JsonPath;
import io.restassured.path.json.config.JsonPathConfig;
import io.restassured.path.xml.XmlPath;
import io.restassured.path.xml.config.XmlPathConfig;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ValidatableResponse;

import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class ResponseWrapper implements Response
{
    private Response response;

    public ResponseWrapper(Response response)
    {
        this.response = response;
    }

    public static ResponseWrapper of(Response response)
    {
        return new ResponseWrapper(response);
    }

    @Override
    public String print()
    {
        return response.print();
    }

    @Override
    public String prettyPrint()
    {
        return response.prettyPrint();
    }

    @Override
    public Response peek()
    {
        return response.peek();
    }

    @Override
    public Response prettyPeek()
    {
        return response.prettyPeek();
    }

    @Override
    public <T> T as(Class<T> cls)
    {
        return response.as(cls);
    }

    @Override
    public <T> T as(Class<T> cls, ObjectMapperType mapperType)
    {
        return response.as(cls, mapperType);
    }

    @Override
    public <T> T as(Class<T> cls, ObjectMapper mapper)
    {
        return response.as(cls, mapper);
    }

    @Override
    public <T> T as(TypeRef<T> typeRef)
    {
        return response.as(typeRef);
    }

    @Override
    public <T> T as(Type cls)
    {
        return response.as(cls);
    }

    @Override
    public <T> T as(Type cls, ObjectMapperType mapperType)
    {
        return response.as(cls, mapperType);
    }

    @Override
    public <T> T as(Type cls, ObjectMapper mapper)
    {
        return response.as(cls, mapper);
    }

    @Override
    public JsonPath jsonPath()
    {
        return response.jsonPath();
    }

    @Override
    public JsonPath jsonPath(JsonPathConfig config)
    {
        return response.jsonPath(config);
    }

    @Override
    public XmlPath xmlPath()
    {
        return response.xmlPath();
    }

    @Override
    public XmlPath xmlPath(XmlPathConfig config)
    {
        return response.xmlPath(config);
    }

    @Override
    public XmlPath xmlPath(XmlPath.CompatibilityMode compatibilityMode)
    {
        return response.xmlPath(compatibilityMode);
    }

    @Override
    public XmlPath htmlPath()
    {
        return response.htmlPath();
    }

    @Override
    public <T> T path(String path, String... arguments)
    {
        return response.path(path, arguments);
    }

    @Override
    public String asString()
    {
        return response.asString();
    }

    @Override
    public String asPrettyString() {
        return response.asPrettyString();
    }

    @Override
    public byte[] asByteArray()
    {
        return response.asByteArray();
    }

    @Override
    public InputStream asInputStream()
    {
        return response.asInputStream();
    }

    @Override
    public Response andReturn()
    {
        return response.andReturn();
    }

    @Override
    public Response thenReturn()
    {
        return response.thenReturn();
    }

    @Override
    public ResponseBody body()
    {
        return response.body();
    }

    @Override
    public ResponseBody getBody()
    {
        return response.getBody();
    }

    @Override
    public Headers headers()
    {
        return response.headers();
    }

    @Override
    public Headers getHeaders()
    {
        return response.getHeaders();
    }

    @Override
    public String header(String name)
    {
        return response.header(name);
    }

    @Override
    public String getHeader(String name)
    {
        return response.getHeader(name);
    }

    @Override
    public Map<String, String> cookies()
    {
        return response.cookies();
    }

    @Override
    public Cookies detailedCookies()
    {
        return response.detailedCookies();
    }

    @Override
    public Map<String, String> getCookies()
    {
        return response.getCookies();
    }

    @Override
    public Cookies getDetailedCookies()
    {
        return response.getDetailedCookies();
    }

    @Override
    public String cookie(String name)
    {
        return response.cookie(name);
    }

    @Override
    public String getCookie(String name)
    {
        return response.getCookie(name);
    }

    @Override
    public Cookie detailedCookie(String name)
    {
        return response.detailedCookie(name);
    }

    @Override
    public Cookie getDetailedCookie(String name)
    {
        return response.getDetailedCookie(name);
    }

    @Override
    public String contentType()
    {
        return response.contentType();
    }

    @Override
    public String getContentType()
    {
        return response.getContentType();
    }

    @Override
    public String statusLine()
    {
        return response.statusLine();
    }

    @Override
    public String getStatusLine()
    {
        return response.getStatusLine();
    }

    @Override
    public String sessionId()
    {
        return response.sessionId();
    }

    @Override
    public String getSessionId()
    {
        return response.getSessionId();
    }

    @Override
    public int statusCode()
    {
        return response.statusCode();
    }

    @Override
    public int getStatusCode()
    {
        return response.getStatusCode();
    }

    @Override
    public long time()
    {
        return response.time();
    }

    @Override
    public long timeIn(TimeUnit timeUnit)
    {
        return response.timeIn(timeUnit);
    }

    @Override
    public long getTime()
    {
        return response.getTime();
    }

    @Override
    public long getTimeIn(TimeUnit timeUnit)
    {
        return response.getTimeIn(timeUnit);
    }

    @Override
    public ValidatableResponse then()
    {
        return response.then();
    }
}
