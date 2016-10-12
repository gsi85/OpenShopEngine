package com.openshop.product.delete;

import com.openshop.product.exception.ProductOperationFailedException;

/**
 * Service for deleting a persisted product.
 *
 * @author Laszlo_Sisa
 */
public interface DeleteProductService {

    boolean deleteProduct(final DeleteProductRequestContext context) throws ProductOperationFailedException;

}
