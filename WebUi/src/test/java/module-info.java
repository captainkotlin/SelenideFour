module SelenideFour.WebUi.test {
    requires org.slf4j;

    requires org.junit.jupiter.api;
    requires org.junit.platform.launcher;

    requires io.cucumber.core;
    requires io.cucumber.java;
    requires io.cucumber.junit;
    requires io.cucumber.junit.platform.engine;

    requires spring.test;
    requires spring.beans;
    requires spring.context;
    requires io.cucumber.spring;
    requires spring.boot.test;

    requires com.codeborne.selenide;
    requires selenium.api;
    requires selenium.remote.driver;

    requires lombok;
    requires hamcrest.core;
}