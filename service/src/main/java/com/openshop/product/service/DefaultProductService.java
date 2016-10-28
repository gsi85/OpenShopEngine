package com.openshop.product.service;

import static com.openshop.validation.Validation.notNull;

import com.openshop.dao.EntityDao;
import com.openshop.product.domain.Product;
import com.openshop.product.exception.ProductOperationFailedException;

/**
 * Default implementation of {@link ProductService}.
 *
 * @author Laszlo_Sisa
 */
public class DefaultProductService implements ProductService {

    private EntityDao<Product> entityDao;

    @Override
    public Product upsertProduct(final Product product) throws ProductOperationFailedException, IllegalArgumentException {
        validateContext(product);
        return entityDao.upsertEntity(product, Product.class);
    }

    private void validateContext(final Product context) {
        notNull(context, "context must not be null!");
    }
}
