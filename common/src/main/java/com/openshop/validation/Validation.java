package com.openshop.validation;

/**
 * Collection of commonly validation methods.
 *
 * @author Laszlo_Sisa
 */
public class Validation {

    /**
     * Validates an object against nullity.
     *
     * @param toValidate the object to be validated
     * @param message    specific exception message if validation fails
     * @throws IllegalArgumentException if {@code toValidate} is null
     */
    public static void notNull(final Object toValidate, final String message) {
        if (toValidate == null) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * Validates if a string has content.
     *
     * @param toValidate the string to validate
     * @param message specific exception message if validation fails
     * @throws IllegalArgumentException if {@code toValidate} is null or empty
     */
    public static void hasText(final String toValidate, final String message) {
        notNull(toValidate, message);
        if (toValidate.trim().length() == 0) {
            throw new IllegalArgumentException(message);
        }
    }

}
