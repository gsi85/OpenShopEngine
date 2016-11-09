package com.openshop.product.service.domain;

import static com.openshop.validation.Validation.notNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;

import com.openshop.domain.IdentifiableEntity;
import com.openshop.product.domain.Component;
import com.openshop.product.domain.Product;

/**
 * Object wrapping {@link Product} for persistence.
 * Sub components are linked with the list of {@code componentIds}.
 *
 * @author Laszlo_Sisa
 */
public final class PersistedProduct implements IdentifiableEntity {

    private final Product product;
    private final List<String> componentIds;

    public PersistedProduct(final Product product) {
        notNull(product, "product can't be null!");
        this.product = product;
        this.componentIds = product.getComponents().stream().map(Component::getId).collect(ImmutableListCollector.toImmutableList());
    }

    @Override
    public String getId() {
        return product.getId();
    }

    public Product getProduct() {
        return product;
    }

    public List<String> getComponentIds() {
        return componentIds;
    }

    private static class ImmutableListCollector {

        private static <t> Collector<t, List<t>, List<t>> toImmutableList() {
            return Collector.of(ArrayList::new, List::add, (left, right) -> {
                left.addAll(right);
                return left;
            }, Collections::unmodifiableList);
        }
    }
}
