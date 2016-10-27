package com.openshop.product.alter;

import static com.openshop.validation.Validation.notNull;

import com.openshop.dao.EntityDao;
import com.openshop.product.domain.Product;
import com.openshop.product.exception.ProductOperationFailedException;

/**
 * Default implementation of {@link AlterProductService}.
 *
 * @author Laszlo_Sisa
 */
public class DefaultAlterProductService implements AlterProductService {

    private EntityDao<Product> alterProductServiceDao;

    @Override
    public Product upsertProduct(final Product product) throws ProductOperationFailedException, IllegalArgumentException {
        validateContext(product);
        return alterProductServiceDao.upsertEntity(product, Product.class);
    }

    private void validateContext(final Product context) {
        notNull(context, "context must not be null!");
    }
}
