package com.jojoldu.book.springboot;

import org.hamcrest.core.Is;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest

public class HelloControllerTest {

    @Autowired
    private  MockMvc mvc;

    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "hello";
        mvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(hello));

    }

    @Test
    public void helloDto가_리턴된다() throws Exception {
        String name = "hello";
        int amount = 1000;
        mvc.perform(get("/hello/dto").param("name",name)
                .param("amount", String.valueOf(amount))) //param은 string만 허용
                .andExpect(jsonPath("$.name", is(name)))
                //jsonPath-JSON 응답값을필드별로검증할수있는메소드입니다
                //$를 기준으로 필드명을 명시합니다
                .andExpect(jsonPath("$.amount", is(amount)));

    }

}
