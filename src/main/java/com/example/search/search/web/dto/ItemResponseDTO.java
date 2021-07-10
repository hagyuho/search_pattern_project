package com.example.search.search.web.dto;

import com.example.search.search.domain.item.Category;
import com.example.search.search.domain.item.Item;
import lombok.Getter;

import javax.persistence.*;

@Getter
public class ItemResponseDTO {

    private long id;

    private String title;

    private String price;

    private String country;

    private Category category;

    public ItemResponseDTO(Item item){
        this.id = item.getId();
        this.category = item.getCategory();
        this.country = item.getCountry();
        this.price = item.getPrice();
        this.title = item.getTitle();
    }
}
