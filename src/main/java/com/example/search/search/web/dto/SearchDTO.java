package com.example.search.search.web.dto;

import com.example.search.search.domain.item.Category;
import com.example.search.search.domain.item.Item;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SearchDTO {

    private String title;

    private String price;

    private String country;

    private Category category;

    @Builder
    public SearchDTO(String title, String price, String country, Category category){
        this.category = category;
        this.country = country;
        this.title = title;
        this.price = price;
    }
}
