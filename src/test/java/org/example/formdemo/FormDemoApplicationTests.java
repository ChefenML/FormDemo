package org.example.formdemo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@WebMvcTest(TodayController.class)
class FormDemoApplicationTests {


    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private msgRepo msgRepo;

    @Test
    void contextLoads() throws Exception {
        mockMvc.perform(get("/social")).andExpect(status().
                isOk()).
                andExpect(view().name("social"));
    }

}
