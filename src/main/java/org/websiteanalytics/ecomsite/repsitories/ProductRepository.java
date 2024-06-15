package org.websiteanalytics.ecomsite.repsitories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.websiteanalytics.ecomsite.models.Product;

public interface ProductRepository extends MongoRepository<Product, String> {
    Product findByName(String username);
}
