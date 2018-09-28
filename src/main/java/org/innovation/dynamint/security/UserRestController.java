package org.innovation.dynamint.security;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserRestController.class);

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public Map<String, Object> user(Principal principal) {
        LOGGER.debug("Returning principal {}", principal);
        Map<String, Object> model = new HashMap<>();
        model.put("name", principal.getName());
        return model;
    }
}
