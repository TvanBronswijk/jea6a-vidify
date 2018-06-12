package nl.fontys.vidify.logging.controllers;

import nl.fontys.vidify.core.models.logging.Log;
import nl.fontys.vidify.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class LogController {

    @Autowired
    Logger logger;


    @PostMapping
    public void log(Log log) {
        logger.log(log);
    }
}
