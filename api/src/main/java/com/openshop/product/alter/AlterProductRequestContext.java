package com.openshop.product.alter;

import com.openshop.product.domain.Product;
import com.openshop.validation.Validation;

/**
 * Context object containing information necessary to alter products.
 *
 * @author Laszlo_Sisa
 */
public class AlterProductRequestContext {

    private final Product productToAlter;

    public AlterProductRequestContext(final Product productToAlter) {
        Validation.notNull(productToAlter, "productToAlter can't be null!");
        this.productToAlter = productToAlter;
    }

    public Product getProductToAlter() {
        return productToAlter;
    }
}
