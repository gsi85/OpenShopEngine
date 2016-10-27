package com.openshop.product.alter;

import static com.openshop.validation.Validation.notNull;

import java.util.List;

import com.openshop.dao.EntityDao;
import com.openshop.product.domain.Component;
import com.openshop.product.exception.ComponentOperationFailedException;
import com.openshop.product.retrieve.RetrieveEntityRequestContext;

/**
 * Default implementation of {@link ComponentService}.
 *
 * @author Laszlo_Sisa
 */
public class DefaultComponentService implements ComponentService {

    private final EntityDao<Component> entityDao;

    public DefaultComponentService(final EntityDao<Component> entityDao) {
        this.entityDao = entityDao;
    }

    @Override
    public Component upsertComponent(final Component component) throws ComponentOperationFailedException, IllegalArgumentException {
        notNull(component, "component must not be null!");
        try {
            return entityDao.upsertEntity(component, Component.class);
        } catch (final Exception exception) {
            throw new ComponentOperationFailedException(exception);
        }
    }

    @Override
    public List<Component> findComponents(final RetrieveEntityRequestContext context)
        throws ComponentOperationFailedException, IllegalArgumentException {
        notNull(context, "context must not be null!");
        try {
            return null;
        } catch (final Exception exception) {
            throw new ComponentOperationFailedException(exception);
        }
    }

    @Override
    public boolean deleteComponent(final Component component) throws ComponentOperationFailedException, IllegalArgumentException {
        notNull(component, "component must not be null!");
        try {
            return entityDao.deleteEntity(component, Component.class);
        } catch (final Exception exception) {
            throw new ComponentOperationFailedException(exception);
        }
    }

}
