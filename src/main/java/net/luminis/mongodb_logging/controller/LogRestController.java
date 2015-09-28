package net.luminis.mongodb_logging.controller;

import net.luminis.mongodb_logging.domain.Log;
import net.luminis.mongodb_logging.repository.LogRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/logging")
public class LogRestController {
    private static final Logger LOG = Logger.getLogger(LogRestController.class);

    @Autowired
    private LogRepository repo;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public void log(@RequestParam String logMessage) {
        LOG.info(logMessage);
    }

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Log> getLogByName(@RequestParam(required = false) String name) {
        if(name != null && name.trim().length() > 0) {
            return repo.findByName(name);
        } else {
            return repo.findAll();
        }
    }
}
