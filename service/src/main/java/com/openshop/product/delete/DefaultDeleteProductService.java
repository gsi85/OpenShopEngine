package com.openshop.product.delete;

import static com.openshop.validation.Validation.notNull;

import com.openshop.dao.EntityDao;
import com.openshop.product.domain.Product;
import com.openshop.product.exception.ProductOperationFailedException;

/**
 * Default implementation of {@link DeleteProductService}.
 *
 * @author Laszlo_Sisa
 */
public class DefaultDeleteProductService implements DeleteProductService {

    private EntityDao<Product> deleteProductDao;

    @Override
    public boolean deleteProduct(final Product product) throws ProductOperationFailedException, IllegalArgumentException {
        validateContext(product);
        return deleteProductDao.deleteEntity(product, Product.class);
    }

    private void validateContext(final Product context) {
        notNull(context, "context must not be null!");
    }
}
