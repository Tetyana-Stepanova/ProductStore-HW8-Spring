package com.goit.productstore.models.product;

import com.goit.productstore.models.manufacturer.Manufacturer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "product")
@Getter
@Setter
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(generator = "UUID")
    @Type(type = "uuid-char")
    @Column(name = "uuid")
    private UUID uuid;

    @Column(name = "product_name")
    private String productName;

    @Column
    private Long price;

    @ManyToOne
    @JoinColumn(name = "manuf_uuid" , referencedColumnName = "uuid")
    private Manufacturer manufacturer;
}
