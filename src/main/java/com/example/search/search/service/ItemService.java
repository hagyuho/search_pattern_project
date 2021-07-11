package com.example.search.search.service;

import com.example.search.search.domain.item.Item;
import com.example.search.search.domain.item.ItemRepository;
import com.example.search.search.web.dto.ItemResponseDTO;
import com.example.search.search.web.dto.SearchDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ItemService {

    private final ItemRepository itemRepository;


    public List<ItemResponseDTO> findAll() {
        return itemRepository.findAll().stream().map(items -> new ItemResponseDTO(items)).collect(Collectors.toList());
    }

    public ItemResponseDTO findById(Long id) {
        Item item = itemRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당정보가 없습니다."));
        ItemResponseDTO dto = new ItemResponseDTO(item);
        return dto;
    }

    public List<ItemResponseDTO> findByCondition1(SearchDTO dto) {
        return itemRepository.findAll().stream()
                .filter(p -> p.getCategory() == dto.getCategory() && p.getCountry() == dto.getCountry() && p.getPrice() == dto.getPrice() && p.getTitle() == dto.getTitle())
                .map(p -> new ItemResponseDTO(p))
                .collect(Collectors.toList());
    }

    public List<ItemResponseDTO> findByCondition2(SearchDTO dto) {
        return null;
    }

    public List<ItemResponseDTO> findByCondition3(SearchDTO dto) {
        return null;
    }
}
