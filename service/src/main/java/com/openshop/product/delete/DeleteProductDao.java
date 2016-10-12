package com.openshop.product.delete;

import com.openshop.product.exception.ProductOperationFailedException;

/**
 * Data access interface for deleting a {@link com.openshop.product.domain.Product}.
 *
 * @author Laszlo_Sisa
 */
public interface DeleteProductDao {

    int deleteProduct(final DeleteProductRequestContext context) throws ProductOperationFailedException;

}
