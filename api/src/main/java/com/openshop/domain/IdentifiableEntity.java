package com.openshop.domain;

/**
 * Interface marking entities which should be uniquely identifiable by there id.
 *
 * @author Laszlo_Sisa
 */
public interface IdentifiableEntity {

    String NEW_ENTITY_ID = "-1";

    String getId();

}
