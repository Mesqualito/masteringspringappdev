package net.generica.spring.masteringspringappdev.domain

import javax.persistence.Id
import org.springframework.data.mongodb.core.mapping.Document


@Document
class Product {

    @Id
    private String prodid

    private Double price
    private String name

    Product() {
        super()
    }
}
