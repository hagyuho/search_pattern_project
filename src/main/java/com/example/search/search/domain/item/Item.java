package com.example.search.search.domain.item;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;

    private String price;

    private String country;

    @Enumerated(EnumType.STRING)
    private Category category;

    @Builder
    public Item(String title, String price, String country, Category category){
        this.title = title;
        this.price = price;
        this.country = country;
        this.category = category;
    }

}
