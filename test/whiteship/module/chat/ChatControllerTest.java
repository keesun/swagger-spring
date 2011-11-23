package whiteship.module.chat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.web.server.MockMvc;
import org.springframework.test.web.server.setup.MockMvcBuilder;
import org.springframework.test.web.server.setup.MockMvcBuilders;

import static org.springframework.test.web.server.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.server.result.MockMvcResultMatchers.*;

/**
 * @author: keesunbaik
 */
public class ChatControllerTest {

    @Test
    public void send() throws Exception {
        MockMvc mockMvc = MockMvcBuilders
                .xmlConfigSetup("classpath:/applicationContext.xml", "file:web/WEB-INF/keynote-servlet.xml")
                .build();
        mockMvc.perform(post("/send/from/ks/message/hello ks"))
                .andExpect(status().isOk())
                .andExpect(content().string("ok"));
    }

}
