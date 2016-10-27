package com.openshop.product.retrieve;

import java.util.List;

import com.openshop.product.domain.Product;
import com.openshop.product.exception.ProductOperationFailedException;

/**
 * Service for retrieving persisted {@link Product}.
 *
 * @author Laszlo_Sisa
 */
public interface RetrieveProductService {

    List<Product> retrieveProducts(final RetrieveEntityRequestContext context) throws ProductOperationFailedException, IllegalArgumentException;

}
