package com.study.song;

import com.study.song.controller.OxmController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@WebMvcTest(OxmController.class)
class SongApplicationTests {

    @Autowired
    private MockMvc mvc;


    @Test
    void testExample() throws Exception {
        final ResultActions actions = mvc.perform(MockMvcRequestBuilders.get("/get/1")
                .contentType(MediaType.APPLICATION_JSON)) .andDo(MockMvcResultHandlers.print());
        actions .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.title").value("TITLE1"))
                .andDo(MockMvcResultHandlers.print());

    }

}
