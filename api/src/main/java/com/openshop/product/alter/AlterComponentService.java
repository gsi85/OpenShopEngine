package com.openshop.product.alter;

import com.openshop.product.domain.Component;
import com.openshop.product.exception.ComponentOperationFailedException;

/**
 * Service for altering component.
 *
 * @author Laszlo_Sisa
 */
public interface AlterComponentService {

    Component upsertComponent(final AlterComponentRequestContext context) throws ComponentOperationFailedException, IllegalArgumentException;

}
