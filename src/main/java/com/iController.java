package com;

import com.Model.Product;

/**
 * Created by kram on 25.04.17.
 */
public interface iController {

    void exit();
    void invalidProduct();
    void productNotFound();
    void productFound(Product product);
    void service(String barcode);
}
