package com.openshop.dao;

import java.util.List;

import com.openshop.domain.IdentifiableEntity;
import com.openshop.entity.EntityManager;
import com.openshop.filer.EntityFilter;
import com.openshop.product.exception.ComponentOperationFailedException;

/**
 * Default implementation of {@link EntityDao}.
 *
 * @author Laszlo_Sisa
 */
public class DefaultEntityDao<T extends IdentifiableEntity> implements EntityDao<T> {

    private final EntityManager<T> entityManager;

    public DefaultEntityDao(final EntityManager<T> entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public T upsertEntity(final T entity, final Class<T> entityTypeClass) throws ComponentOperationFailedException {
        return isNewEntity(entity) ? insertEntity(entity, entityTypeClass) : updateEntity(entity, entityTypeClass);
    }

    @Override
    public List<T> retrieveEntities(final EntityFilter filter, final Class<T> entityTypeClass) {
        return null;
    }

    @Override
    public boolean deleteEntity(final T entity, final Class<T> entityTypeClass) {
        return entityManager.deleteEntity(entity, entityTypeClass);
    }

    private boolean isNewEntity(final T entity) {
        return IdentifiableEntity.NEW_ENTITY_ID.equals(entity.getId());
    }

    private T insertEntity(final T entry, final Class<T> entityTypeClass) {
        return entityManager.insertEntity(entry, entityTypeClass);
    }

    private T updateEntity(final T entity, Class<T> entityTypeClass) {
        return entityManager.updateEntry(entity, entityTypeClass);
    }
}
