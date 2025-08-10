package com.example.householdbudget.config;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;

import com.example.householdbudget.model.dto.transaction.CategoryType;

/**
 * CategoryType用のMyBatis TypeHandler
 * データベースの文字列値とEnum値の変換を行う
 */
@MappedTypes(CategoryType.class)
public class CategoryTypeHandler extends BaseTypeHandler<CategoryType> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, CategoryType parameter, JdbcType jdbcType) throws SQLException {
        // Enum → DB文字列
        ps.setString(i, parameter.getName());
    }

    @Override
    public CategoryType getNullableResult(ResultSet rs, String columnName) throws SQLException {
        // DB文字列 → Enum
        String value = rs.getString(columnName);
        return value == null ? null : CategoryType.fromName(value);
    }

    @Override
    public CategoryType getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        // DB文字列 → Enum
        String value = rs.getString(columnIndex);
        return value == null ? null : CategoryType.fromName(value);
    }

    @Override
    public CategoryType getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        // DB文字列 → Enum
        String value = cs.getString(columnIndex);
        return value == null ? null : CategoryType.fromName(value);
    }
}