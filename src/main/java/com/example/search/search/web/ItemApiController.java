package com.example.search.search.web;

import com.example.search.search.domain.item.Category;
import com.example.search.search.service.ItemService;
import com.example.search.search.web.dto.ItemResponseDTO;
import com.example.search.search.web.dto.SearchDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ItemApiController {

    private final ItemService searchService;

    @GetMapping("/api/v1/items")
    public List<ItemResponseDTO> findAll() {
        return searchService.findAll();
    }


    /**
     * @description : filter 이용해 조회조건 처리
     */
    @GetMapping("/api/v1/items/Condition1")
    public List<ItemResponseDTO> findByCondition1(@RequestParam String title,
                                                  @RequestParam String price,
                                                  @RequestParam String country,
                                                  @RequestParam Category category) {
        SearchDTO dto = SearchDTO.builder().
                title(title).
                category(category).
                country(country).
                price(price).
                build();
        return searchService.findByCondition1(dto);
    }

    /**
     * @description : spec 이용해 조회조건 처리
     */
    @GetMapping("/api/v1/items/Condition2")
    public List<ItemResponseDTO> findByCondition2(@RequestParam String title,
                                                  @RequestParam String price,
                                                  @RequestParam String country,
                                                  @RequestParam Category category) {
        SearchDTO dto = SearchDTO.builder().
                title(title).
                category(category).
                country(country).
                price(price).
                build();
        return searchService.findByCondition2(dto);
    }

    /**
     * @description : queryDSL 이용해 조회조건 처리리
    */
    @GetMapping("/api/v1/items/Condition3")
    public List<ItemResponseDTO> findByCondition3(@RequestParam String title,
                                                  @RequestParam String price,
                                                  @RequestParam String country,
                                                  @RequestParam Category category) {
        SearchDTO dto = SearchDTO.builder().
                title(title).
                category(category).
                country(country).
                price(price).
                build();
        return searchService.findByCondition3(dto);
    }

}
