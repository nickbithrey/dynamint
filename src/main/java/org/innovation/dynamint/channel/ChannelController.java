package org.innovation.dynamint.channel;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChannelController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ChannelController.class);

    @RequestMapping(path = "/api/v1/channel", method = RequestMethod.GET)
    public Map<String, Object> getChannel() {
        LOGGER.debug("getting channel");
        Map<String, Object> model = new HashMap<>();
        model.put("name", "channel");
        return model;
    }
}
