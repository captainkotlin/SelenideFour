open module SelenideFour.WebApi.test {
    requires org.slf4j;

    requires org.junit.jupiter.api;
    requires org.junit.jupiter.params;

    requires rest.assured;
    requires json.path;
    requires com.fasterxml.jackson.databind;
    requires json.schema.validator;
    requires xml.path;
    requires rest.assured.common;

    requires io.qameta.allure.commons;
    
    requires lombok;
    requires java.validation;
    requires org.hamcrest;
    requires org.apache.commons.lang3;
}
