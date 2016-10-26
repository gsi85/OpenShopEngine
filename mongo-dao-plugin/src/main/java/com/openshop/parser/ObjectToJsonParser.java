package com.openshop.parser;

import com.google.gson.Gson;

/**
 * Object to Json parser.
 *
 * @author Laszlo_Sisa
 */
public class ObjectToJsonParser {

    public String serializeObject(final Object objectToParse) {
        Gson gson = new Gson();
        return gson.toJson(objectToParse);
    }

}
