/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weather;

import com.weather.web.WeatherController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(WeatherController.class)
@AutoConfigureRestDocs(outputDir = "target/snippets")
public class WebLayerTest {

//    @Rule
//    public JUnitRestDocumentation restDocumentation = new JUnitRestDocumentation("target/generated-snippets");
//
//    @Autowired
//    private WebApplicationContext context;
    @Autowired
    private MockMvc mockMvc;

//    @Before
//    public void setUp() {
//        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context)
//                .apply(documentationConfiguration(this.restDocumentation))
//                .build();
//    }
    @Test
    public void shouldReturnStatus() throws Exception {
        this.mockMvc.perform(get("/")).andDo(print())
                .andExpect(status().isOk())
                .andDo(document("index"));
    }

}
