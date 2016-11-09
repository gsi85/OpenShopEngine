package com.openshop.product.service;

import static com.openshop.validation.Validation.notNull;

import com.openshop.dao.EntityDao;
import com.openshop.product.domain.Product;
import com.openshop.product.exception.ProductOperationFailedException;
import com.openshop.product.service.domain.PersistedProduct;

/**
 * Default implementation of {@link ProductService}.
 *
 * @author Laszlo_Sisa
 */
public class DefaultProductService implements ProductService {

    private final EntityDao<PersistedProduct> entityDao;

    public DefaultProductService(final EntityDao<PersistedProduct> entityDao) {
        this.entityDao = entityDao;
    }

    @Override
    public Product upsertProduct(final Product product) throws ProductOperationFailedException, IllegalArgumentException {
        validateContext(product);
        PersistedProduct persistedProduct = entityDao.upsertEntity(new PersistedProduct(product), PersistedProduct.class);
        return null;
    }

    private void validateContext(final Product context) {
        notNull(context, "context must not be null!");
    }
}
