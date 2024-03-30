package com.funibertest.Entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "product_change_history")
public class ProductChangeHistoryEntity   {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    @Getter
    @Setter
    private ProductEntity product;

    @Getter
    @Setter
    @Column(name = "change_date", nullable = false)
    private Date changeDate;

    @Getter
    @Setter
    @Column(name = "change_type", nullable = false)
    private String changeType;

    @Getter
    @Setter
    @Column(name = "change_details", nullable = false, length = 1000)
    private String changeDetails;
}
