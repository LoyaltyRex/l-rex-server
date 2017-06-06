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
package org.loyaltyrex.repository.pg.impl;

import java.util.Optional;
import java.util.UUID;

import javax.inject.Inject;

import org.apache.commons.dbcp2.BasicDataSource;
import org.loyaltyrex.domain.model.Business;
import org.loyaltyrex.domain.repository.api.IBusinessRepository;
import org.springframework.jdbc.core.JdbcTemplate;

public class PgBusinessRepository implements IBusinessRepository {

    private static final String BUSINESS_COLUMNS = "b.id, b.name";

    /* The query for looking up a single business by its ID */
    private static final String QUERY_SINGLE_BUSINESS = "SELECT " + BUSINESS_COLUMNS + " FROM business WHERE id = ?";

    private final JdbcTemplate jdbcTemplate;

    @Inject
    public PgBusinessRepository(BasicDataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Optional<Business> find(UUID id) {
        // TODO Auto-generated method stub
        return null;
    }

}
