package com.openshop.parser;

import com.google.gson.Gson;

/**
 * Json parser.
 *
 * @author Laszlo_Sisa
 */
public class JsonParser<T> {

    public String serializeObject(final Object objectToSerialize) {
        Gson gson = new Gson();
        return gson.toJson(objectToSerialize);
    }

    public T parseString(final String stringToParse, final Class<T> classOf) {
        Gson gson = new Gson();
        return gson.fromJson(stringToParse, classOf);
    }

}
