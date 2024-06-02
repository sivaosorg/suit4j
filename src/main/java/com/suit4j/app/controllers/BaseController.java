package com.suit4j.app.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BaseController {
    protected Logger logger;

    protected BaseController() {
        this.logger = LoggerFactory.getLogger(getClass());
    }
}
