package com.example.search.search.service;

import com.example.search.search.domain.item.Item;
import com.example.search.search.domain.item.ItemRepository;
import com.example.search.search.web.dto.ItemResponseDTO;
import com.example.search.search.web.dto.SearchDTO;
import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ItemServiceTest {

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    ItemService itemService;
    @After
    public void cleanUp(){
        itemRepository.deleteAll();
    }

    @Test
    public void 전체조회테스트(){
        //given
        String title = "cake";
        String price = "100";
        String country = "china";

        itemRepository.save(Item.builder().title(title).price(price).country(country).build());

        //when
        List<ItemResponseDTO> list= itemService.findAll();

        //then
        assertThat(list.get(0).getTitle()).isEqualTo(title);
    }


    @Test
    public void 조회조건1_테스트(){
        //given
        String title = "cake";
        String price = "100";
        String country = "china";

        itemRepository.save(Item.builder().title(title).price(price).country(country).build());

        SearchDTO dto = SearchDTO.builder().
                title(title).
                build();

        //when
        List<ItemResponseDTO> list= itemService.findByCondition1(dto);

        //then
        assertThat(list.get(0).getTitle()).isEqualTo(title);
    }

}
