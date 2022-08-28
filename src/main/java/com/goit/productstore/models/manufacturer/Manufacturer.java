package com.goit.productstore.models.manufacturer;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "manufacturer")
@Getter
@Setter
@NoArgsConstructor
public class Manufacturer {

    @Id
    @GeneratedValue(generator = "UUID")
    @Type(type = "uuid-char")
    @Column(name = "uuid")
    private UUID uuid;

    @Column(name = "manuf_name")
    private String manufName;
}
