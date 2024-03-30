package com.funibertest.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "product")
public class ProductEntity {

    @Id
    @Getter
    @Setter
    private Integer code;

    @Getter
    @Setter
    private String name;

    @ManyToOne
    @JoinColumn(name = "category")
    @Getter
    @Setter
    private CategoryEntity category;

    @Getter
    @Setter
    private Boolean stock;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private Set<ProductChangeHistoryEntity> changeHistory;



}
