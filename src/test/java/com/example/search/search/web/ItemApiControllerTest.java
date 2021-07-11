package com.example.search.search.web;

import com.example.search.search.domain.item.Category;
import com.example.search.search.domain.item.Item;
import com.example.search.search.domain.item.ItemRepository;
import com.example.search.search.web.dto.ItemResponseDTO;
import com.example.search.search.web.dto.SearchDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ItemApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private WebApplicationContext context;

    @Autowired
    ObjectMapper objectMapper;

    private MockMvc mvc;

    @Before
    public void setup() {
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                //.apply(springSecurity())
                .build();
    }

    @After
    public void tearDown() throws Exception {
        itemRepository.deleteAll();
    }

    @Test
    public void 조회조건1테스트()throws Exception{
        //given
        String title = "cake";
        String price = "100";
        String country = "china";

        itemRepository.save(Item.builder().title(title).price(price).country(country).build());

        SearchDTO dto = SearchDTO.builder().
                title(title).
                build();

        String url = "http://localhost:"+port+"/api/v1/items/Condition1";

        //when
        mvc.perform(get(url)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk());

        //then
        List<ItemResponseDTO> list = itemRepository.

    }
}
