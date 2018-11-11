package com.danieleautizi.website

import com.danieleautizi.website.manager.SkillManager
import com.fasterxml.jackson.databind.ObjectMapper
import groovy.util.logging.Slf4j
import io.restassured.RestAssured
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.context.embedded.LocalServerPort
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification


@Slf4j(value = "LOG")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = [DanieleAutiziApplication])
class IntegrationTestBase extends Specification {

    @LocalServerPort
    private final int serverPort

    @Autowired
    protected final ObjectMapper objectMapper

    @Autowired
    protected final SkillManager skillManager

    void setup() {

        RestAssured.port = serverPort
    }

}
