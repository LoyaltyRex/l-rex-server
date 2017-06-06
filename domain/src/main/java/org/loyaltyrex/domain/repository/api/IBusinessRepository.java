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
package org.loyaltyrex.domain.repository.api;

import java.util.Optional;
import java.util.UUID;

import org.loyaltyrex.domain.model.Business;

/**
 * An interface for retrieving Business objects from a data store
 * 
 * @author nickavv
 * @since 0.1.0
 */
public interface IBusinessRepository {

    /**
     * Find a Business in the data store by its ID.
     * 
     * @param id
     *            The unique identifier of the Business to retrieve
     * @return An Optional containing the Business requested, or Optional.empty() if none was found
     * @since 0.1.0
     */
    Optional<Business> find(UUID id);

}
