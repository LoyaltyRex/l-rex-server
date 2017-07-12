package org.loyaltyrex.server.core.rest.util;

/**
 * Content Types used by the REST endpoints
 * 
 * @author nickavv
 * @since 0.1.0
 */
public final class ContentTypes {

    /**
     * Represents content from the first version of the server APIs
     * 
     * @since 0.1.0
     */
    public static final String APPLICATION_V1 = "application/vnd.loyaltyrex.server-v1+json";

    /**
     * Represents content in JSON format
     * 
     * @since 0.1.0
     */
    public static final String APPLICATION_JSON = "application/json";

    private ContentTypes() {
        // No instantiating helper classes
    }
}
