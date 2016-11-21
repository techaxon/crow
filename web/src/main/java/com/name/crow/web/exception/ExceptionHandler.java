package com.name.crow.web.exception;

import jersey.repackaged.com.google.common.base.Throwables;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by pchandramohan on 11/20/16.
 */
@ControllerAdvice
public class ExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger("ErrorLog");

    @org.springframework.web.bind.annotation.ExceptionHandler(value = Exception.class)
    public ModelAndView exception(Exception exception, WebRequest request) {
        ModelAndView modelAndView = new ModelAndView("error/general");
        Throwable rootCause = Throwables.propagate(exception);
        modelAndView.addObject("errorMessage", rootCause);
        LOGGER.error(rootCause.toString(), exception);
        return modelAndView;
    }
}
