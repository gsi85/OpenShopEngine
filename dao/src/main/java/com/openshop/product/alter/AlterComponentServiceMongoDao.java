package com.openshop.product.alter;

import com.openshop.product.domain.Component;
import com.openshop.product.exception.ComponentOperationFailedException;

/**
 * Mongo DB specific implementation of {@link AlterComponentServiceDao}.
 *
 * @author Laszlo_Sisa
 */
public class AlterComponentServiceMongoDao implements AlterComponentServiceDao {

    public Component upsertComponent(final AlterComponentRequestContext context) throws ComponentOperationFailedException {
        Component componentToAlter = context.getComponentToAlter();
        return isNewComponent(componentToAlter) ? insertNewEntry(componentToAlter) : updateEntry(componentToAlter);
    }

    private boolean isNewComponent(final Component componentToAlter) {
        return componentToAlter.getId() == Component.NEW_INSTANCE_ID;
    }

    private Component insertNewEntry(final Component componentToAlter) {
        return null;
    }

    private Component updateEntry(final Component componentToAlter) {
        return null;
    }
}
