package org.loyaltyrex.repository.pg.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import org.loyaltyrex.domain.model.Business;
import org.springframework.jdbc.core.RowMapper;

/**
 * Maps result sets from queries to the business table into Business domain objects
 * 
 * @author nickavv
 * @since 0.1.0
 */
public class BusinessRowMapper implements RowMapper<Business> {

    @Override
    public Business mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Business.getBuilder()
                .id(UUID.fromString(rs.getString("id")))
                .name(rs.getString("name"))
                .build();
    }

}
