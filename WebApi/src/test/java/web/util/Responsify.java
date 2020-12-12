package web.util;

import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.matcher.DetailedCookieMatcher;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import io.restassured.specification.*;
import org.apache.commons.lang3.StringUtils;
import org.hamcrest.Matcher;


import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class Responsify implements ResponseSpecification
{
    private ResponseSpecification responseSpecification;
    private String bodyFormat = StringUtils.EMPTY;

    public Responsify(ResponseSpecification responseSpecification)
    {
        this.responseSpecification = responseSpecification;
    }

    public static Responsify of(ResponseSpecification responseSpecification)
    {
        return new Responsify(responseSpecification);
    }


    @Override
    public Response validate(Response response)
    {
        return responseSpecification.validate(response);
    }

    public ResponseWrapper valid(Response response)
    {
        return ResponseWrapper.of(responseSpecification.validate(response));
    }

    @Override
    public ResponseSpecification time(Matcher<Long> matcher)
    {
        return responseSpecification.time(matcher);
    }

    @Override
    public ResponseSpecification time(Matcher<Long> matcher, TimeUnit timeUnit)
    {
        return responseSpecification.time(matcher, timeUnit);
    }

    public Responsify setBodyFormat(String format)
    {
        bodyFormat = format;
        return this;
    }

    public Responsify unsetBodyFormat()
    {
        bodyFormat = StringUtils.EMPTY;
        return this;
    }

    @SafeVarargs
    public final <T> Responsify bodyMatches(String bodyFormat, BodyMatcher<T>... bodyMatchers)
    {
        Responsify responsify = null;
        for (var bodyMatcher : bodyMatchers)
        {
            responsify = body(bodyMatcher.getMatcher(), bodyFormat, bodyMatcher.getArgs());
        }
        return responsify;
    }

    @SafeVarargs
    public final <T> Responsify bodyMatches(BodyMatcher<T>... bodyMatchers)
    {
        Responsify responsify = null;
        for (var bodyMatcher : bodyMatchers)
        {
            responsify = body(bodyMatcher.getMatcher(), bodyFormat, bodyMatcher.getArgs());
        }
        return responsify;
    }

    public <T> Responsify bodyMatch(BodyMatcher<T> bodyMatcher)
    {
        return body(bodyMatcher.getMatcher(), bodyMatcher.getFormat(), bodyMatcher.getArgs());
    }

    @Override
    public ResponseSpecification body(String s, List<Argument> list, Matcher matcher, Object... objects)
    {
        return responseSpecification.body(s, list, matcher, objects);
    }

    public <T> Responsify body(Matcher<T> matcher, String s, List<Argument> args)
    {
        return Responsify.of(responseSpecification.body(s, args, matcher));
    }

    public <T> Responsify body(Matcher<T> matcher, List<Argument> args)
    {
        return Responsify.of(responseSpecification.body(bodyFormat, args, matcher));
    }

    @Override
    public ResponseSpecification body(List<Argument> list, Matcher matcher, Object... objects)
    {
        return responseSpecification.body(list, matcher, objects);
    }

    @Override
    public ResponseSpecification statusCode(Matcher<? super Integer> matcher)
    {
        return responseSpecification.statusCode(matcher);
    }

    public Responsify status(Matcher<? super Integer> matcher)
    {
        return Responsify.of(responseSpecification.statusCode(matcher));
    }

    @Override
    public ResponseSpecification statusCode(int i)
    {
        return responseSpecification.statusCode(i);
    }

    public Responsify status(int i)
    {
        return Responsify.of(responseSpecification.statusCode(i));
    }

    @Override
    public ResponseSpecification statusLine(Matcher<? super String> matcher)
    {
        return responseSpecification.statusLine(matcher);
    }

    @Override
    public ResponseSpecification statusLine(String s)
    {
        return responseSpecification.statusLine(s);
    }

    @Override
    public ResponseSpecification headers(Map<String, ?> map)
    {
        return responseSpecification.headers(map);
    }

    @Override
    public ResponseSpecification headers(String s, Object o, Object... objects)
    {
        return responseSpecification.headers(s, o, objects);
    }

    @Override
    public ResponseSpecification header(String s, Matcher<?> matcher)
    {
        return responseSpecification.header(s, matcher);
    }

    @Override
    public <T> ResponseSpecification header(String s, Function<String, T> function, Matcher<? super T> matcher)
    {
        return responseSpecification.header(s, function, matcher);
    }

    @Override
    public ResponseSpecification header(String s, String s1)
    {
        return responseSpecification.headers(s, s1);
    }

    @Override
    public ResponseSpecification cookies(Map<String, ?> map)
    {
        return responseSpecification.cookies(map);
    }

    @Override
    public ResponseSpecification cookie(String s)
    {
        return responseSpecification.cookie(s);
    }

    @Override
    public ResponseSpecification cookies(String s, Object o, Object... objects)
    {
        return responseSpecification.cookies(s, o, objects);
    }

    @Override
    public ResponseSpecification cookie(String s, Matcher<?> matcher)
    {
        return responseSpecification.cookie(s, matcher);
    }

    @Override
    public ResponseSpecification cookie(String s, DetailedCookieMatcher detailedCookieMatcher)
    {
        return responseSpecification.cookie(s, detailedCookieMatcher);
    }

    @Override
    public ResponseSpecification cookie(String s, Object o)
    {
        return responseSpecification.cookie(s, o);
    }

    @Override
    public ResponseLogSpecification log()
    {
        return responseSpecification.log();
    }

    @Override
    public ResponseSpecification rootPath(String s, List<Argument> list)
    {
        return responseSpecification.rootPath(s, list);
    }

    @Override
    public ResponseSpecification rootPath(String s)
    {
        return responseSpecification.rootPath(s);
    }

    @Override
    public ResponseSpecification noRootPath()
    {
        return responseSpecification.noRootPath();
    }

    @Override
    public ResponseSpecification appendRootPath(String s)
    {
        return responseSpecification.appendRootPath(s);
    }

    @Override
    public ResponseSpecification appendRootPath(String s, List<Argument> list)
    {
        return responseSpecification.appendRootPath(s, list);
    }

    @Override
    public ResponseSpecification detachRootPath(String s)
    {
        return responseSpecification.detachRootPath(s);
    }

    @Override
    public ResponseSpecification contentType(ContentType contentType)
    {
        return responseSpecification.contentType(contentType);
    }

    @Override
    public ResponseSpecification contentType(String s)
    {
        return responseSpecification.contentType(s);
    }

    @Override
    public ResponseSpecification contentType(Matcher<? super String> matcher)
    {
        return responseSpecification.contentType(matcher);
    }

    @Override
    public ResponseSpecification body(Matcher<?> matcher, Matcher<?>... matchers)
    {
        return responseSpecification.body(matcher, matchers);
    }

    @Override
    public Responsify body(String s, Matcher<?> matcher, Object... objects)
    {
        return Responsify.of(responseSpecification.body(s, matcher, objects));
    }

    @Override
    public RequestSender when()
    {
        return responseSpecification.when();
    }

    @Override
    public RequestSpecification given()
    {
        return responseSpecification.given();
    }

    @Override
    public ResponseSpecification that()
    {
        return responseSpecification.that();
    }

    @Override
    public RequestSpecification request()
    {
        return responseSpecification.request();
    }

    @Override
    public ResponseSpecification response()
    {
        return responseSpecification.response();
    }

    @Override
    public ResponseSpecification and()
    {
        return responseSpecification.and();
    }

    @Override
    public RequestSpecification with()
    {
        return responseSpecification.with();
    }

    @Override
    public ResponseSpecification then()
    {
        return responseSpecification.then();
    }

    @Override
    public ResponseSpecification expect()
    {
        return responseSpecification.expect();
    }

    @Override
    public ResponseSpecification spec(ResponseSpecification responseSpecification)
    {
        return responseSpecification.spec(responseSpecification);
    }

    @Override
    public ResponseSpecification parser(String s, Parser parser)
    {
        return responseSpecification.parser(s, parser);
    }

    @Override
    public ResponseSpecification defaultParser(Parser parser)
    {
        return responseSpecification.defaultParser(parser);
    }

    @Override
    public ResponseSpecification logDetail(LogDetail logDetail)
    {
        return responseSpecification.logDetail(logDetail);
    }
}
