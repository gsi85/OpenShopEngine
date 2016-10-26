package com.openshop.product.alter;

import com.openshop.entity.EntityManager;
import com.openshop.product.domain.Component;
import com.openshop.product.exception.ComponentOperationFailedException;

/**
 * Default implementation of {@link AlterComponentServiceDao}.
 *
 * @author Laszlo_Sisa
 */
public class DefaultAlterComponentServiceDao implements AlterComponentServiceDao {

    private final EntityManager<Component> entityManager;

    public DefaultAlterComponentServiceDao(final EntityManager<Component> entityManager) {
        this.entityManager = entityManager;
    }

    public Component upsertComponent(final AlterComponentRequestContext context) throws ComponentOperationFailedException {
        Component componentToAlter = context.getComponentToAlter();
        return isNewComponent(componentToAlter) ? insertNewEntry(componentToAlter) : updateEntry(componentToAlter);
    }

    private boolean isNewComponent(final Component componentToAlter) {
        return Component.NEW_INSTANCE_ID.equals(componentToAlter.getId());
    }

    private Component insertNewEntry(final Component componentToAlter) {
        entityManager.insertEntity(componentToAlter, Component.class);
        return null;
    }

    private Component updateEntry(final Component componentToAlter) {
        return null;
    }
}
