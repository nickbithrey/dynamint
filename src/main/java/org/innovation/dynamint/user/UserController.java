package org.innovation.dynamint.user;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @GetMapping(value = "/user")
    public Map<String, Object> user(Principal principal) {
        LOGGER.debug("Returning principal {}", principal);
        Map<String, Object> model = new HashMap<>();
        model.put("name", principal.getName());
        return model;
    }
}
