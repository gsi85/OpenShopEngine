package com.openshop.product.service;

import com.openshop.product.domain.Product;
import com.openshop.product.exception.ProductOperationFailedException;

/**
 * Service for persisting a new {@link Product} or modifying an existing one.
 *
 * @author Laszlo_Sisa
 */
public interface ProductService {

    Product upsertProduct(final Product context) throws ProductOperationFailedException, IllegalArgumentException;

}
