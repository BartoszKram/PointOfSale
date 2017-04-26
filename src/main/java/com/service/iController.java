package com.service;

import com.model.Product;

public interface iController {

    void exit();
    void invalidProduct();
    void productNotFound();
    void productFound(Product product);
    void service(String barcode);
}
