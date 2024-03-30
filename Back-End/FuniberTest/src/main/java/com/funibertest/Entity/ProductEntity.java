package com.funibertest.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "product")
public class ProductEntity {

    @Id
    @Getter
    @Setter
    Integer code;

    @Getter
    @Setter
    String name;

    @Getter
    @Setter
    Integer Category;

    @Getter
    @Setter
    Boolean Stock;


}
