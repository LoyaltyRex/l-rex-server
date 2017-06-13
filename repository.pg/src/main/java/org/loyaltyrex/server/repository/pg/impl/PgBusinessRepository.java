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
package org.loyaltyrex.server.repository.pg.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import javax.inject.Inject;

import org.apache.commons.dbcp2.BasicDataSource;
import org.loyaltyrex.server.domain.model.Business;
import org.loyaltyrex.server.domain.repository.api.IBusinessRepository;
import org.loyaltyrex.server.repository.pg.mapper.BusinessRowMapper;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public class PgBusinessRepository implements IBusinessRepository {

    private static final String BUSINESS_COLUMNS = "b.id, b.name";

    /* Query for looking up a single business by its ID */
    private static final String QUERY_FIND_SINGLE_BUSINESS = "SELECT " + BUSINESS_COLUMNS
            + " FROM business b WHERE b.id = :id";

    /* Query for deleting a single business by its ID */
    private static final String QUERY_DELETE_SINGLE_BUSINESS = "DELETE FROM business WHERE id = :id";

    private static final String QUERY_SAVE_SINGLE_BUSINESS = "INSERT INTO business VALUES(:id, :name) ON CONFLICT (id) DO UPDATE SET name = :name";

    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Inject
    public PgBusinessRepository(BasicDataSource dataSource) {
        jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public Optional<Business> find(UUID uuid) {
        Map<String, Object> queryArguments = Collections.singletonMap("id", uuid);
        try {
            return Optional
                    .of(jdbcTemplate.queryForObject(QUERY_FIND_SINGLE_BUSINESS, queryArguments,
                            new BusinessRowMapper()));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public void delete(Business business) {
        Map<String, Object> queryArguments = Collections.singletonMap("id", business.getId());
        jdbcTemplate.update(QUERY_DELETE_SINGLE_BUSINESS, queryArguments);
    }

    @Override
    public void save(Business business) {
        @SuppressWarnings("serial")
        Map<String, Object> queryArguments = new HashMap<String, Object>() {
            {
                put("id", business.getId());
                put("name", business.getName());
            }
        };
        jdbcTemplate.update(QUERY_SAVE_SINGLE_BUSINESS, queryArguments);
    }

}
