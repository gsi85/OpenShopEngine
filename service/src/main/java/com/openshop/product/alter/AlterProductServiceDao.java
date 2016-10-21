package com.openshop.product.alter;

import com.openshop.product.domain.Product;
import com.openshop.product.exception.ProductOperationFailedException;

/**
 * Data access interface for inserting or modifying a {@link Product}.
 *
 * @author Laszlo_Sisa
 */
public interface AlterProductServiceDao {

    Product upsertProduct(final AlterProductRequestContext context) throws ProductOperationFailedException;

}
