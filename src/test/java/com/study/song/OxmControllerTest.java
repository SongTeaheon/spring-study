package com.study.song;

import com.study.song.Service.OxmService;
import com.study.song.controller.OxmController;
import com.study.song.repository.BoardMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(OxmController.class)
@AutoConfigureMockMvc
@ContextConfiguration
public class OxmControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private OxmService oxmService;

    @Test
    public void getAllBoardListTest() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/board/list"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
                //.andExpect(MockMvcResultMatchers.content().));
    }
}
