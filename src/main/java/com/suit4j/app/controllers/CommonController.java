package com.suit4j.app.controllers;

import org.force4j.common.Force4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.unify4j.model.builder.HttpStatusBuilder;
import org.unify4j.model.builder.HttpWrapBuilder;
import org.unify4j.model.response.WrapResponse;

@RestController
@RequestMapping(value = "/api/v1/common")
public class CommonController extends BaseController {

    @GetMapping("/health")
    public @ResponseBody ResponseEntity<?> inform() {
        logger.info("Checking health...");
        WrapResponse<?> response = new HttpWrapBuilder<>()
                .statusCode(HttpStatusBuilder.OK)
                .message("HealthCheck")
                .requestId(Force4j.getCurrentSessionId())
                .build();
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatusCode()));
    }
}
