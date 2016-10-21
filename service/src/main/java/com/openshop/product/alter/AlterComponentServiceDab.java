package com.openshop.product.alter;

import com.openshop.product.domain.Component;
import com.openshop.product.exception.ComponentOperationFailedException;

/**
 * Data access interface for inserting or modifying a {@link Component}.
 *
 * @author Laszlo_Sisa
 */
public interface AlterComponentServiceDab {

    Component upsertComponent(final AlterComponentRequestContext context) throws ComponentOperationFailedException;

}
