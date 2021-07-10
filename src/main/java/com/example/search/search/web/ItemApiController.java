package com.example.search.search.web;

import com.example.search.search.service.ItemService;
import com.example.search.search.web.dto.ItemResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ItemApiController {

    private final ItemService searchService;

    @GetMapping("api/v1/items")
    public List<ItemResponseDTO> findAll() {
        return searchService.findAll();
    }


}
