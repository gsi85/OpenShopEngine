package com.openshop.product.delete;

import com.openshop.product.domain.Product;
import com.openshop.product.exception.ProductOperationFailedException;

/**
 * Service for deleting a persisted product.
 *
 * @author Laszlo_Sisa
 */
public interface DeleteProductService {

    boolean deleteProduct(final Product product) throws ProductOperationFailedException, IllegalArgumentException;

}
