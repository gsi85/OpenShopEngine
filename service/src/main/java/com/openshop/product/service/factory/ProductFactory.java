package com.openshop.product.service.factory;

import java.util.ArrayList;
import java.util.List;

import com.openshop.dao.EntityDao;
import com.openshop.filer.IdBasedEntityFilter;
import com.openshop.product.domain.Component;
import com.openshop.product.domain.Product;
import com.openshop.product.service.domain.PersistedProduct;

/**
 * Factory for creating a {@link Product} from a {@link PersistedProduct}.
 *
 * @author Laszlo_Sisa
 */
public class ProductFactory {

    private final EntityDao<Component> entityDao;

    /**
     * DI constructor.
     *
     * @param entityDao {@link EntityDao}
     */
    public ProductFactory(final EntityDao<Component> entityDao) {
        this.entityDao = entityDao;
    }

    public Product createFrom(final PersistedProduct persistedProduct) {
        List<Component> components = getComponents(persistedProduct.getComponentIds());
        return buildProduct(persistedProduct.getProduct(), components);
    }

    private List<Component> getComponents(final List<String> componentIds) {
        List<Component> components = new ArrayList<>();
        for (String componentId : componentIds) {
            //TODO: implement filter + filter factories
            List<Component> retrieveEntities = entityDao.retrieveEntities(new IdBasedEntityFilter(componentId), Component.class);
            if (!retrieveEntities.isEmpty()) {
                components.add(retrieveEntities.get(0));
            }
        }
        return components;
    }

    private Product buildProduct(final Product product, final List<Component> components) {
        return new Product.Builder()
                .withName(product.getName())
                .withDescription(product.getDescription())
                .withIdFrom(product)
                .withComponents(components)
                .withImages(product.getImages())
                .withPrice(product.getPrice())
                .build();
    }

}
