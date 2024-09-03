package com.suit4j.app.controllers;

import com.suit4j.app.services.CommonService;
import org.clarify4j.common.annotation.ExecutorSince;
import org.force4j.common.Force4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.unify4j.model.builder.HttpStatusBuilder;
import org.unify4j.model.builder.HttpWrapBuilder;
import org.unify4j.model.response.WrapResponse;

@RestController
@RequestMapping(value = "/api/v1/common")
public class CommonController extends BaseController {
    protected final CommonService commonService;

    @Autowired
    public CommonController(CommonService commonService) {
        this.commonService = commonService;
    }

    @ExecutorSince
    @GetMapping("/health")
    public @ResponseBody ResponseEntity<?> inform() {
        WrapResponse<?> response = new HttpWrapBuilder<>()
                .statusCode(HttpStatusBuilder.OK)
                .message("HealthCheck")
                .requestId(Force4j.getCurrentSessionId())
                .build();
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatusCode()));
    }

    @ExecutorSince
    @PostMapping("/health")
    public @ResponseBody ResponseEntity<?> inform(@RequestBody Object request) {
        WrapResponse<?> response = new HttpWrapBuilder<>()
                .statusCode(HttpStatusBuilder.OK)
                .message("HealthCheck")
                .requestId(Force4j.getCurrentSessionId())
                .build();
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatusCode()));
    }
}
