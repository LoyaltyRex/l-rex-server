package org.loyaltyrex.server.core.rest.api;

import java.util.UUID;

import org.springframework.web.util.UriComponentsBuilder;

import com.google.common.collect.ImmutableMap;

/**
 * Request paths relating to Business endpoints
 * 
 * @author nickavv
 * @since 0.1.0
 */
public final class BusinessRequestPaths {

    /**
     * The path for a single business
     * <p>
     * Path variables:
     * <ul>
     * <li><b>id:</b> ID of the business to look up</li>
     * </ul>
     *
     * @since 0.1.0
     */
    public static final String BUSINESS = "/business/{id}";

    /**
     * Get a request URI for a single business
     * 
     * @param id
     *            The ID of the business to find
     * @return The request URI for the business
     * @since 0.1.0
     */
    public static String getBusinessUrl(UUID id) {
        return UriComponentsBuilder.fromPath(BUSINESS)
                .buildAndExpand(ImmutableMap.of("id", id.toString()))
                .toUriString();
    }

}
