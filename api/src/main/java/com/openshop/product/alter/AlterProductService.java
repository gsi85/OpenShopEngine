package com.openshop.product.alter;

import com.openshop.product.domain.Product;
import com.openshop.product.exception.ProductOperationFailedException;

/**
 * Service for persisting a new {@link Product} or modifying an existing one.
 *
 * @author Laszlo_Sisa
 */
public interface AlterProductService {

    Product upsertProduct(final AlterProductRequestContext context) throws ProductOperationFailedException;

}
