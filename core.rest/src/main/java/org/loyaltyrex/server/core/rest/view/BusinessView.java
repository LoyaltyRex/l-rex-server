/*
 * Copyright (c) Apr 10, 2017 Loyalty Rex.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Apache License Version 2.0
 * which accompanies this distribution, and is available at
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Contributors:
 *    nickavv - initial API and implementation and/or initial documentation
 */
package org.loyaltyrex.server.core.rest.view;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;

/**
 * Represents a business
 *
 * <p>
 * Intended for serialization to JSON in the form:
 *
 * <pre>
 * {
 *      "name": "Business Name",
 *      "_meta": {
 *          "href": "http://...",
 *          "allowed": [ "GET" ],
 *          "links": [
 *          ]
 *      }
 * }
 * </pre>
 *
 * @author nickavv
 * @since 0.1.0
 */
public final class BusinessView {

    @JsonProperty(value = "name", required = true)
    private final String name;
	
    @JsonProperty(value = "_meta", required = true)
    private final MetaDataView metaData;

    /**
     * @param name
     * @param metaData
     */
    public BusinessView(String name, MetaDataView metaData) {
		this.name = Objects.requireNonNull(name);
        this.metaData = Objects.requireNonNull(metaData);
	}
	
	/**
     * @return The name of the business
     * @since 0.1.0
     */
    public String getName() {
        return name;
	}
	
	/**
     * @return The metadata associated with this business
     */
    public MetaDataView getMetaData() {
        return metaData;
	}

	@Override
	public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("name", name)
                .add("metaData", metaData)
                .toString();
	}

	@Override
	public int hashCode() {
        return Objects.hash(name, metaData);
	}

	@Override
	public boolean equals(Object obj) {
		boolean result = false;

        if (obj instanceof BusinessView) {
        	BusinessView compare = (BusinessView) obj;

            result = Objects.equals(compare.getName(), getName())
                    && Objects.equals(compare.getMetaData(), getMetaData());
        }

        return result;
	}
}
