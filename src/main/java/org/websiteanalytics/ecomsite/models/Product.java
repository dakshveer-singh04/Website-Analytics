package org.websiteanalytics.ecomsite.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ecom_products")
public class Product {
    @Id
    private String id;
    private String name;
    private String description;
    private double price;
}
