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
package org.loyaltyrex.server.domain.model;

import java.util.Objects;
import java.util.UUID;

/**
 * A domain-level representation of a business.
 * 
 * @author nickavv
 * @since 0.1.0
 */
public final class Business {

    private final UUID id;
	
    private final String name;
	
    private Business(UUID id, String name) {
		this.id = Objects.requireNonNull(id);
		this.name = Objects.requireNonNull(name);
	}
	
	/**
	 * @return The identifier used to uniquely address this business
	 * @since 0.1.0
	 */
    public UUID getId() {
		return id;
	}
	
	/**
	 * @return The name of the business
	 * @since 0.1.0
	 */
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return new StringBuilder().append("Business[")
				.append("name=").append(name)
				.append("]")
				.toString();
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}

	@Override
	public boolean equals(Object obj) {
		boolean result = false;

        if (obj instanceof Business) {
        	Business compare = (Business) obj;

            result = Objects.equals(compare.getId(), getId())
                    && Objects.equals(compare.getName(), getName());
        }

        return result;
	}
	
    public static Builder getBuilder() {
        return new Builder();
    }
	
    public static class Builder {

        private UUID id;

        private String name;

        private Builder() {
            // No instantiating builders. Clients should use Business.getBuilder() to get an instance
        }

        public Builder id(UUID id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Business build() {
            return new Business(id, name);
        }

    }
	
}
