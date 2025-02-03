package com.inditex.gft.infrastructure.adapter.out.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "prices")
@Data
public class PriceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "brand_id")
    private Long brandId;

    @Column(name = "price_list")
    private Integer priceList;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    @Column(name = "price")
    private Double price;

    @Column(name = "priority")
    private Integer priority;

}
