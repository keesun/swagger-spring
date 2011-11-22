package whiteship.module.chat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.web.server.MockMvc;
import org.springframework.test.web.server.setup.MockMvcBuilder;
import org.springframework.test.web.server.setup.MockMvcBuilders;

import static org.springframework.test.web.server.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.server.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.server.result.MockMvcResultActions.response;

/**
 * @author: keesunbaik
 */
public class ChatControllerTest {

    @Test
    public void send() throws Exception {
        MockMvc mockMvc = MockMvcBuilders
                .xmlConfigSetup("classpath:/applicationContext.xml", "file:web/WEB-INF/keynote-servlet.xml")
                .build();
        mockMvc.perform(post("/send").param("message", "HELLO BOM_SAK").param("from", "keesun"))
                .andExpect(response().status().isOk())
                .andExpect(response().content().isEqualTo("ok"));
    }

}
