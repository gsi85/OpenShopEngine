package com.openshop.product.retrieve;

import com.openshop.product.exception.ProductOperationFailedException;
import java.util.List;

import com.openshop.product.domain.Product;

/**
 * Data access interface for retrieving persisted product.
 *
 * @author Laszlo_Sisa
 */
public interface RetrieveProductDao {

    List<Product> retrieveProduct(final RetrieveEntityRequestContext context) throws ProductOperationFailedException;

}
