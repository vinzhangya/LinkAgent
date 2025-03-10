/**
 * Copyright 2021 Shulie Technology, Co.Ltd
 * Email: shulie@shulie.io
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.pamirs.attach.plugin.common.datasource.normal;

import com.pamirs.pradar.pressurement.datasource.SqlParser;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.*;
import java.util.Calendar;

/**
 * <p>{@code } instances should NOT be constructed in
 * standard programming. </p>
 *
 * <p>This constructor is public to permit tools that require a JavaBean
 * instance to operate.</p>
 */
public class NormalPreparedStatement implements PreparedStatement {
    /**
     * <p>{@code } instances should NOT be constructed in
     * standard programming. </p>
     *
     * <p>This constructor is public to permit tools that require a JavaBean
     * instance to operate.</p>
     */
    PreparedStatement preparedStatement;
    /**
     * <p>{@code } instances should NOT be constructed in
     * standard programming. </p>
     *
     * <p>This constructor is public to permit tools that require a JavaBean
     * instance to operate.</p>
     */
    Connection connection;

    /**
     * <p>{@code } instances should NOT be constructed in
     * standard programming. </p>
     *
     * <p>This constructor is public to permit tools that require a JavaBean
     * instance to operate.</p>
     */
    private String dbConnectionKey;


    private String dbType;

    /**
     * <p>{@code } instances should NOT be constructed in
     * standard programming. </p>
     *
     * <p>This constructor is public to permit tools that require a JavaBean
     * instance to operate.</p>
     */
    public NormalPreparedStatement(PreparedStatement preparedStatement, Connection connection, String dbConnectionKey
            , String dbType) {
        this.preparedStatement = preparedStatement;
        this.connection = connection;
        this.dbConnectionKey = dbConnectionKey;
        this.dbType = dbType;
    }

    /**
     * <p>{@code } instances should NOT be constructed in
     * standard programming. </p>
     *
     * <p>This constructor is public to permit tools that require a JavaBean
     * instance to operate.</p>
     */
    @Override
    public void addBatch(String arg0) throws SQLException {
        arg0 = SqlParser.replaceTable(arg0, this.dbConnectionKey, this.dbType);
        preparedStatement.addBatch(arg0);
    }

    /**
     * <p>{@code } instances should NOT be constructed in
     * standard programming. </p>
     *
     * <p>This constructor is public to permit tools that require a JavaBean
     * instance to operate.</p>
     */
    @Override
    public void cancel() throws SQLException {
        preparedStatement.cancel();
    }

    /**
     * <p>{@code } instances should NOT be constructed in
     * standard programming. </p>
     *
     * <p>This constructor is public to permit tools that require a JavaBean
     * instance to operate.</p>
     */
    @Override
    public void clearBatch() throws SQLException {
        preparedStatement.clearBatch();
    }

    /**
     * <p>{@code } instances should NOT be constructed in
     * standard programming. </p>
     *
     * <p>This constructor is public to permit tools that require a JavaBean
     * instance to operate.</p>
     */
    @Override
    public void clearWarnings() throws SQLException {
        preparedStatement.clearWarnings();
    }

    /**
     * <p>{@code } instances should NOT be constructed in
     * standard programming. </p>
     *
     * <p>This constructor is public to permit tools that require a JavaBean
     * instance to operate.</p>
     */
    @Override
    public void close() throws SQLException {
        preparedStatement.close();
    }

    /**
     * <p>{@code } instances should NOT be constructed in
     * standard programming. </p>
     *
     * <p>This constructor is public to permit tools that require a JavaBean
     * instance to operate.</p>
     */
    public void closeOnCompletion() throws SQLException {
        try {
            preparedStatement.closeOnCompletion();
        } catch (AbstractMethodError e) {
        } catch (NoSuchMethodError e) {
        }

    }

    /**
     * <p>{@code } instances should NOT be constructed in
     * standard programming. </p>
     *
     * <p>This constructor is public to permit tools that require a JavaBean
     * instance to operate.</p>
     */
    @Override
    public boolean execute(String arg0) throws SQLException {
        arg0 = SqlParser.replaceTable(arg0, this.dbConnectionKey, this.dbType);
        return preparedStatement.execute(arg0);
    }

    /**
     * <p>{@code } instances should NOT be constructed in
     * standard programming. </p>
     *
     * <p>This constructor is public to permit tools that require a JavaBean
     * instance to operate.</p>
     */
    @Override
    public boolean execute(String arg0, int arg1) throws SQLException {
        arg0 = SqlParser.replaceTable(arg0, this.dbConnectionKey, this.dbType);
        return preparedStatement.execute(arg0, arg1);
    }

    /**
     * <p>{@code } instances should NOT be constructed in
     * standard programming. </p>
     *
     * <p>This constructor is public to permit tools that require a JavaBean
     * instance to operate.</p>
     */
    @Override
    public boolean execute(String arg0, int[] arg1) throws SQLException {
        arg0 = SqlParser.replaceTable(arg0, this.dbConnectionKey, this.dbType);
        return preparedStatement.execute(arg0, arg1);
    }

    /**
     * <p>{@code } instances should NOT be constructed in
     * standard programming. </p>
     *
     * <p>This constructor is public to permit tools that require a JavaBean
     * instance to operate.</p>
     */
    @Override
    public boolean execute(String arg0, String[] arg1) throws SQLException {
        arg0 = SqlParser.replaceTable(arg0, this.dbConnectionKey, this.dbType);
        return preparedStatement.execute(arg0, arg1);
    }

    /**
     * <p>{@code } instances should NOT be constructed in
     * standard programming. </p>
     *
     * <p>This constructor is public to permit tools that require a JavaBean
     * instance to operate.</p>
     */
    @Override
    public int[] executeBatch() throws SQLException {
        return preparedStatement.executeBatch();
    }

    /**
     * <p>{@code } instances should NOT be constructed in
     * standard programming. </p>
     *
     * <p>This constructor is public to permit tools that require a JavaBean
     * instance to operate.</p>
     */
    @Override
    public ResultSet executeQuery(String arg0) throws SQLException {
        arg0 = SqlParser.replaceTable(arg0, this.dbConnectionKey, this.dbType);
        return preparedStatement.executeQuery(arg0);
    }

    /**
     * <p>{@code } instances should NOT be constructed in
     * standard programming. </p>
     *
     * <p>This constructor is public to permit tools that require a JavaBean
     * instance to operate.</p>
     */
    @Override
    public int executeUpdate(String arg0) throws SQLException {
        arg0 = SqlParser.replaceTable(arg0, this.dbConnectionKey, this.dbType);
        return preparedStatement.executeUpdate(arg0);
    }

    /**
     * <p>{@code } instances should NOT be constructed in
     * standard programming. </p>
     *
     * <p>This constructor is public to permit tools that require a JavaBean
     * instance to operate.</p>
     */
    @Override
    public int executeUpdate(String arg0, int arg1) throws SQLException {
        arg0 = SqlParser.replaceTable(arg0, this.dbConnectionKey, this.dbType);
        return preparedStatement.executeUpdate(arg0, arg1);
    }

    /**
     * <p>{@code } instances should NOT be constructed in
     * standard programming. </p>
     *
     * <p>This constructor is public to permit tools that require a JavaBean
     * instance to operate.</p>
     */
    @Override
    public int executeUpdate(String arg0, int[] arg1) throws SQLException {
        arg0 = SqlParser.replaceTable(arg0, this.dbConnectionKey, this.dbType);
        return preparedStatement.executeUpdate(arg0, arg1);
    }

    /**
     * <p>{@code } instances should NOT be constructed in
     * standard programming. </p>
     *
     * <p>This constructor is public to permit tools that require a JavaBean
     * instance to operate.</p>
     */
    @Override
    public int executeUpdate(String arg0, String[] arg1) throws SQLException {
        arg0 = SqlParser.replaceTable(arg0, this.dbConnectionKey, this.dbType);
        return preparedStatement.executeUpdate(arg0, arg1);
    }

    /**
     * <p>{@code } instances should NOT be constructed in
     * standard programming. </p>
     *
     * <p>This constructor is public to permit tools that require a JavaBean
     * instance to operate.</p>
     */
    @Override
    public Connection getConnection() throws SQLException {
        return preparedStatement.getConnection();
    }

    /**
     * <p>{@code } instances should NOT be constructed in
     * standard programming. </p>
     *
     * <p>This constructor is public to permit tools that require a JavaBean
     * instance to operate.</p>
     */
    @Override
    public int getFetchDirection() throws SQLException {
        return preparedStatement.getFetchDirection();
    }

    /**
     * <p>{@code } instances should NOT be constructed in
     * standard programming. </p>
     *
     * <p>This constructor is public to permit tools that require a JavaBean
     * instance to operate.</p>
     */
    @Override
    public int getFetchSize() throws SQLException {
        return preparedStatement.getFetchSize();
    }

    /**
     * <p>{@code } instances should NOT be constructed in
     * standard programming. </p>
     *
     * <p>This constructor is public to permit tools that require a JavaBean
     * instance to operate.</p>
     */
    @Override
    public ResultSet getGeneratedKeys() throws SQLException {
        return preparedStatement.getGeneratedKeys();
    }

    /**
     * <p>{@code } instances should NOT be constructed in
     * standard programming. </p>
     *
     * <p>This constructor is public to permit tools that require a JavaBean
     * instance to operate.</p>
     */
    @Override
    public int getMaxFieldSize() throws SQLException {
        return preparedStatement.getMaxFieldSize();
    }

    /**
     * <p>{@code } instances should NOT be constructed in
     * standard programming. </p>
     *
     * <p>This constructor is public to permit tools that require a JavaBean
     * instance to operate.</p>
     */
    @Override
    public int getMaxRows() throws SQLException {
        return preparedStatement.getMaxRows();
    }

    /**
     * <p>{@code } instances should NOT be constructed in
     * standard programming. </p>
     *
     * <p>This constructor is public to permit tools that require a JavaBean
     * instance to operate.</p>
     */
    @Override
    public boolean getMoreResults() throws SQLException {
        return preparedStatement.getMoreResults();
    }

    /**
     * <p>{@code } instances should NOT be constructed in
     * standard programming. </p>
     *
     * <p>This constructor is public to permit tools that require a JavaBean
     * instance to operate.</p>
     */
    @Override
    public boolean getMoreResults(int arg0) throws SQLException {
        return preparedStatement.getMoreResults(arg0);
    }

    /**
     * <p>{@code } instances should NOT be constructed in
     * standard programming. </p>
     *
     * <p>This constructor is public to permit tools that require a JavaBean
     * instance to operate.</p>
     */
    @Override
    public int getQueryTimeout() throws SQLException {
        return preparedStatement.getQueryTimeout();
    }

    /**
     * <p>{@code } instances should NOT be constructed in
     * standard programming. </p>
     *
     * <p>This constructor is public to permit tools that require a JavaBean
     * instance to operate.</p>
     */
    @Override
    public ResultSet getResultSet() throws SQLException {
        return preparedStatement.getResultSet();
    }

    /**
     * <p>{@code } instances should NOT be constructed in
     * standard programming. </p>
     *
     * <p>This constructor is public to permit tools that require a JavaBean
     * instance to operate.</p>
     */
    @Override
    public int getResultSetConcurrency() throws SQLException {
        return preparedStatement.getResultSetConcurrency();
    }

    /**
     * <p>{@code } instances should NOT be constructed in
     * standard programming. </p>
     *
     * <p>This constructor is public to permit tools that require a JavaBean
     * instance to operate.</p>
     */
    @Override
    public int getResultSetHoldability() throws SQLException {
        return preparedStatement.getResultSetHoldability();
    }

    /**
     * <p>{@code } instances should NOT be constructed in
     * standard programming. </p>
     *
     * <p>This constructor is public to permit tools that require a JavaBean
     * instance to operate.</p>
     */
    @Override
    public int getResultSetType() throws SQLException {
        return preparedStatement.getResultSetType();
    }

    /**
     * <p>{@code } instances should NOT be constructed in
     * standard programming. </p>
     *
     * <p>This constructor is public to permit tools that require a JavaBean
     * instance to operate.</p>
     */
    @Override
    public int getUpdateCount() throws SQLException {
        return preparedStatement.getUpdateCount();
    }

    /**
     * <p>{@code } instances should NOT be constructed in
     * standard programming. </p>
     *
     * <p>This constructor is public to permit tools that require a JavaBean
     * instance to operate.</p>
     */
    @Override
    public SQLWarning getWarnings() throws SQLException {
        return preparedStatement.getWarnings();
    }

    /**
     * <p>{@code } instances should NOT be constructed in
     * standard programming. </p>
     *
     * <p>This constructor is public to permit tools that require a JavaBean
     * instance to operate.</p>
     */
    public boolean isCloseOnCompletion() throws SQLException {
        try {
            return preparedStatement.isCloseOnCompletion();
        } catch (AbstractMethodError e) {
        } catch (NoSuchMethodError e) {
        }
        return false;
    }

    /**
     * <p>{@code } instances should NOT be constructed in
     * standard programming. </p>
     *
     * <p>This constructor is public to permit tools that require a JavaBean
     * instance to operate.</p>
     */
    @Override
    public boolean isClosed() throws SQLException {
        return preparedStatement.isClosed();
    }

    /**
     * <p>{@code } instances should NOT be constructed in
     * standard programming. </p>
     *
     * <p>This constructor is public to permit tools that require a JavaBean
     * instance to operate.</p>
     */
    @Override
    public boolean isPoolable() throws SQLException {
        return preparedStatement.isPoolable();
    }

    /**
     * <p>{@code } instances should NOT be constructed in
     * standard programming. </p>
     *
     * <p>This constructor is public to permit tools that require a JavaBean
     * instance to operate.</p>
     */
    @Override
    public void setCursorName(String arg0) throws SQLException {
        //arg0=ShemaReplacer.replaceTable(arg0,connection, this.dbConnectionKey);
        preparedStatement.setCursorName(arg0);
    }

    /**
     * <p>{@code } instances should NOT be constructed in
     * standard programming. </p>
     *
     * <p>This constructor is public to permit tools that require a JavaBean
     * instance to operate.</p>
     */
    @Override
    public void setEscapeProcessing(boolean arg0) throws SQLException {
        preparedStatement.setEscapeProcessing(arg0);
    }

    /**
     * <p>{@code } instances should NOT be constructed in
     * standard programming. </p>
     *
     * <p>This constructor is public to permit tools that require a JavaBean
     * instance to operate.</p>
     */
    @Override
    public void setFetchDirection(int arg0) throws SQLException {
        preparedStatement.setFetchDirection(arg0);

    }

    /**
     * <p>{@code } instances should NOT be constructed in
     * standard programming. </p>
     *
     * <p>This constructor is public to permit tools that require a JavaBean
     * instance to operate.</p>
     */
    @Override
    public void setFetchSize(int arg0) throws SQLException {
        preparedStatement.setFetchSize(arg0);

    }

    /**
     * <p>{@code } instances should NOT be constructed in
     * standard programming. </p>
     *
     * <p>This constructor is public to permit tools that require a JavaBean
     * instance to operate.</p>
     */
    @Override
    public void setMaxFieldSize(int arg0) throws SQLException {
        preparedStatement.setMaxFieldSize(arg0);
    }

    /**
     * <p>{@code } instances should NOT be constructed in
     * standard programming. </p>
     *
     * <p>This constructor is public to permit tools that require a JavaBean
     * instance to operate.</p>
     */
    @Override
    public void setMaxRows(int arg0) throws SQLException {
        preparedStatement.setMaxRows(arg0);
    }

    /**
     * <p>{@code } instances should NOT be constructed in
     * standard programming. </p>
     *
     * <p>This constructor is public to permit tools that require a JavaBean
     * instance to operate.</p>
     */
    @Override
    public void setPoolable(boolean arg0) throws SQLException {
        preparedStatement.setPoolable(arg0);

    }

    /**
     * <p>{@code } instances should NOT be constructed in
     * standard programming. </p>
     *
     * <p>This constructor is public to permit tools that require a JavaBean
     * instance to operate.</p>
     */
    @Override
    public void setQueryTimeout(int arg0) throws SQLException {
        preparedStatement.setQueryTimeout(arg0);
    }

    /**
     * <p>{@code } instances should NOT be constructed in
     * standard programming. </p>
     *
     * <p>This constructor is public to permit tools that require a JavaBean
     * instance to operate.</p>
     */
    @Override
    public boolean isWrapperFor(Class<?> arg0) throws SQLException {
        return preparedStatement.isWrapperFor(arg0);
    }

    /**
     * <p>{@code } instances should NOT be constructed in
     * standard programming. </p>
     *
     * <p>This constructor is public to permit tools that require a JavaBean
     * instance to operate.</p>
     */
    @Override
    public <T> T unwrap(Class<T> arg0) throws SQLException {
        return preparedStatement.unwrap(arg0);
    }

    /**
     * <p>{@code } instances should NOT be constructed in
     * standard programming. </p>
     *
     * <p>This constructor is public to permit tools that require a JavaBean
     * instance to operate.</p>
     */
    @Override
    public void addBatch() throws SQLException {
        preparedStatement.addBatch();
    }

    /**
     * <p>{@code } instances should NOT be constructed in
     * standard programming. </p>
     *
     * <p>This constructor is public to permit tools that require a JavaBean
     * instance to operate.</p>
     */
    @Override
    public void clearParameters() throws SQLException {
        preparedStatement.clearParameters();

    }

    /**
     * <p>{@code } instances should NOT be constructed in
     * standard programming. </p>
     *
     * <p>This constructor is public to permit tools that require a JavaBean
     * instance to operate.</p>
     */
    @Override
    public boolean execute() throws SQLException {
        return preparedStatement.execute();
    }

    /**
     * <p>{@code } instances should NOT be constructed in
     * standard programming. </p>
     *
     * <p>This constructor is public to permit tools that require a JavaBean
     * instance to operate.</p>
     */
    @Override
    public ResultSet executeQuery() throws SQLException {
        return preparedStatement.executeQuery();
    }

    /**
     * <p>{@code } instances should NOT be constructed in
     * standard programming. </p>
     *
     * <p>This constructor is public to permit tools that require a JavaBean
     * instance to operate.</p>
     */
    @Override
    public int executeUpdate() throws SQLException {
        return preparedStatement.executeUpdate();
    }

    /**
     * <p>{@code } instances should NOT be constructed in
     * standard programming. </p>
     *
     * <p>This constructor is public to permit tools that require a JavaBean
     * instance to operate.</p>
     */
    @Override
    public ResultSetMetaData getMetaData() throws SQLException {
        return preparedStatement.getMetaData();
    }

    /**
     * <p>{@code } instances should NOT be constructed in
     * standard programming. </p>
     *
     * <p>This constructor is public to permit tools that require a JavaBean
     * instance to operate.</p>
     */
    @Override
    public ParameterMetaData getParameterMetaData() throws SQLException {
        return preparedStatement.getParameterMetaData();
    }

    /**
     * <p>{@code } instances should NOT be constructed in
     * standard programming. </p>
     *
     * <p>This constructor is public to permit tools that require a JavaBean
     * instance to operate.</p>
     */
    @Override
    public void setArray(int arg0, Array arg1) throws SQLException {
        preparedStatement.setArray(arg0, arg1);
    }

    /**
     * <p>{@code } instances should NOT be constructed in
     * standard programming. </p>
     *
     * <p>This constructor is public to permit tools that require a JavaBean
     * instance to operate.</p>
     */
    @Override
    public void setAsciiStream(int arg0, InputStream arg1) throws SQLException {
        preparedStatement.setAsciiStream(arg0, arg1);
    }

    /**
     * <p>{@code } instances should NOT be constructed in
     * standard programming. </p>
     *
     * <p>This constructor is public to permit tools that require a JavaBean
     * instance to operate.</p>
     */
    @Override
    public void setAsciiStream(int arg0, InputStream arg1, int arg2)
            throws SQLException {
        preparedStatement.setAsciiStream(arg0, arg1, arg2);
    }

    /**
     * <p>{@code } instances should NOT be constructed in
     * standard programming. </p>
     *
     * <p>This constructor is public to permit tools that require a JavaBean
     * instance to operate.</p>
     */
    @Override
    public void setAsciiStream(int arg0, InputStream arg1, long arg2)
            throws SQLException {
        preparedStatement.setAsciiStream(arg0, arg1, arg2);
    }

    /**
     * <p>{@code } instances should NOT be constructed in
     * standard programming. </p>
     *
     * <p>This constructor is public to permit tools that require a JavaBean
     * instance to operate.</p>
     */
    @Override
    public void setBigDecimal(int arg0, BigDecimal arg1) throws SQLException {
        preparedStatement.setBigDecimal(arg0, arg1);
    }

    /**
     * <p>{@code } instances should NOT be constructed in
     * standard programming. </p>
     *
     * <p>This constructor is public to permit tools that require a JavaBean
     * instance to operate.</p>
     */
    @Override
    public void setBinaryStream(int arg0, InputStream arg1) throws SQLException {
        preparedStatement.setBinaryStream(arg0, arg1);
    }

    /**
     * <p>{@code } instances should NOT be constructed in
     * standard programming. </p>
     *
     * <p>This constructor is public to permit tools that require a JavaBean
     * instance to operate.</p>
     */
    @Override
    public void setBinaryStream(int arg0, InputStream arg1, int arg2)
            throws SQLException {
        preparedStatement.setBinaryStream(arg0, arg1, arg2);
    }

    /**
     * <p>{@code } instances should NOT be constructed in
     * standard programming. </p>
     *
     * <p>This constructor is public to permit tools that require a JavaBean
     * instance to operate.</p>
     */
    @Override
    public void setBinaryStream(int arg0, InputStream arg1, long arg2)
            throws SQLException {
        preparedStatement.setBinaryStream(arg0, arg1, arg2);
    }

    /**
     * <p>{@code } instances should NOT be constructed in
     * standard programming. </p>
     *
     * <p>This constructor is public to permit tools that require a JavaBean
     * instance to operate.</p>
     */
    @Override
    public void setBlob(int arg0, Blob arg1) throws SQLException {
        preparedStatement.setBlob(arg0, arg1);

    }

    /**
     * <p>{@code } instances should NOT be constructed in
     * standard programming. </p>
     *
     * <p>This constructor is public to permit tools that require a JavaBean
     * instance to operate.</p>
     */
    @Override
    public void setBlob(int arg0, InputStream arg1) throws SQLException {
        preparedStatement.setBlob(arg0, arg1);

    }

    /**
     * <p>{@code } instances should NOT be constructed in
     * standard programming. </p>
     *
     * <p>This constructor is public to permit tools that require a JavaBean
     * instance to operate.</p>
     */
    @Override
    public void setBlob(int arg0, InputStream arg1, long arg2)
            throws SQLException {
        preparedStatement.setBlob(arg0, arg1, arg2);

    }

    /**
     * <p>{@code } instances should NOT be constructed in
     * standard programming. </p>
     *
     * <p>This constructor is public to permit tools that require a JavaBean
     * instance to operate.</p>
     */
    @Override
    public void setBoolean(int arg0, boolean arg1) throws SQLException {
        preparedStatement.setBoolean(arg0, arg1);

    }

    /**
     * <p>{@code } instances should NOT be constructed in
     * standard programming. </p>
     *
     * <p>This constructor is public to permit tools that require a JavaBean
     * instance to operate.</p>
     */
    @Override
    public void setByte(int arg0, byte arg1) throws SQLException {
        preparedStatement.setByte(arg0, arg1);

    }

    /**
     * <p>{@code } instances should NOT be constructed in
     * standard programming. </p>
     *
     * <p>This constructor is public to permit tools that require a JavaBean
     * instance to operate.</p>
     */
    @Override
    public void setBytes(int arg0, byte[] arg1) throws SQLException {
        preparedStatement.setBytes(arg0, arg1);

    }

    /**
     * <p>{@code } instances should NOT be constructed in
     * standard programming. </p>
     *
     * <p>This constructor is public to permit tools that require a JavaBean
     * instance to operate.</p>
     */
    @Override
    public void setCharacterStream(int arg0, Reader arg1) throws SQLException {
        preparedStatement.setCharacterStream(arg0, arg1);
    }

    /**
     * <p>{@code } instances should NOT be constructed in
     * standard programming. </p>
     *
     * <p>This constructor is public to permit tools that require a JavaBean
     * instance to operate.</p>
     */
    @Override
    public void setCharacterStream(int arg0, Reader arg1, int arg2)
            throws SQLException {
        preparedStatement.setCharacterStream(arg0, arg1, arg2);
    }

    /**
     * <p>{@code } instances should NOT be constructed in
     * standard programming. </p>
     *
     * <p>This constructor is public to permit tools that require a JavaBean
     * instance to operate.</p>
     */
    @Override
    public void setCharacterStream(int arg0, Reader arg1, long arg2)
            throws SQLException {
        preparedStatement.setCharacterStream(arg0, arg1, arg2);
    }

    /**
     * <p>{@code } instances should NOT be constructed in
     * standard programming. </p>
     *
     * <p>This constructor is public to permit tools that require a JavaBean
     * instance to operate.</p>
     */
    @Override
    public void setClob(int arg0, Clob arg1) throws SQLException {
        preparedStatement.setClob(arg0, arg1);

    }

    /**
     * <p>{@code } instances should NOT be constructed in
     * standard programming. </p>
     *
     * <p>This constructor is public to permit tools that require a JavaBean
     * instance to operate.</p>
     */
    @Override
    public void setClob(int arg0, Reader arg1) throws SQLException {
        preparedStatement.setClob(arg0, arg1);
    }

    /**
     * <p>{@code } instances should NOT be constructed in
     * standard programming. </p>
     *
     * <p>This constructor is public to permit tools that require a JavaBean
     * instance to operate.</p>
     */
    @Override
    public void setClob(int arg0, Reader arg1, long arg2) throws SQLException {
        preparedStatement.setClob(arg0, arg1, arg2);
    }

    /**
     * <p>{@code } instances should NOT be constructed in
     * standard programming. </p>
     *
     * <p>This constructor is public to permit tools that require a JavaBean
     * instance to operate.</p>
     */
    @Override
    public void setDate(int arg0, Date arg1) throws SQLException {
        preparedStatement.setDate(arg0, arg1);
    }

    /**
     * <p>{@code } instances should NOT be constructed in
     * standard programming. </p>
     *
     * <p>This constructor is public to permit tools that require a JavaBean
     * instance to operate.</p>
     */
    @Override
    public void setDate(int arg0, Date arg1, Calendar arg2) throws SQLException {
        preparedStatement.setDate(arg0, arg1, arg2);

    }

    /**
     * <p>{@code } instances should NOT be constructed in
     * standard programming. </p>
     *
     * <p>This constructor is public to permit tools that require a JavaBean
     * instance to operate.</p>
     */
    @Override
    public void setDouble(int arg0, double arg1) throws SQLException {
        preparedStatement.setDouble(arg0, arg1);

    }

    /**
     * <p>{@code } instances should NOT be constructed in
     * standard programming. </p>
     *
     * <p>This constructor is public to permit tools that require a JavaBean
     * instance to operate.</p>
     */
    @Override
    public void setFloat(int arg0, float arg1) throws SQLException {
        preparedStatement.setFloat(arg0, arg1);

    }

    /**
     * <p>{@code } instances should NOT be constructed in
     * standard programming. </p>
     *
     * <p>This constructor is public to permit tools that require a JavaBean
     * instance to operate.</p>
     */
    @Override
    public void setInt(int arg0, int arg1) throws SQLException {
        preparedStatement.setInt(arg0, arg1);

    }

    /**
     * <p>{@code } instances should NOT be constructed in
     * standard programming. </p>
     *
     * <p>This constructor is public to permit tools that require a JavaBean
     * instance to operate.</p>
     */
    @Override
    public void setLong(int arg0, long arg1) throws SQLException {
        preparedStatement.setLong(arg0, arg1);

    }

    /**
     * <p>{@code } instances should NOT be constructed in
     * standard programming. </p>
     *
     * <p>This constructor is public to permit tools that require a JavaBean
     * instance to operate.</p>
     */
    @Override
    public void setNCharacterStream(int arg0, Reader arg1) throws SQLException {
        preparedStatement.setNCharacterStream(arg0, arg1);
    }

    /**
     * <p>{@code } instances should NOT be constructed in
     * standard programming. </p>
     *
     * <p>This constructor is public to permit tools that require a JavaBean
     * instance to operate.</p>
     */
    @Override
    public void setNCharacterStream(int arg0, Reader arg1, long arg2)
            throws SQLException {
        preparedStatement.setNCharacterStream(arg0, arg1, arg2);
    }

    /**
     * <p>{@code } instances should NOT be constructed in
     * standard programming. </p>
     *
     * <p>This constructor is public to permit tools that require a JavaBean
     * instance to operate.</p>
     */
    @Override
    public void setNClob(int arg0, NClob arg1) throws SQLException {
        preparedStatement.setNClob(arg0, arg1);
    }

    /**
     * <p>{@code } instances should NOT be constructed in
     * standard programming. </p>
     *
     * <p>This constructor is public to permit tools that require a JavaBean
     * instance to operate.</p>
     */
    @Override
    public void setNClob(int arg0, Reader arg1) throws SQLException {
        preparedStatement.setNClob(arg0, arg1);
    }

    /**
     * <p>{@code } instances should NOT be constructed in
     * standard programming. </p>
     *
     * <p>This constructor is public to permit tools that require a JavaBean
     * instance to operate.</p>
     */
    @Override
    public void setNClob(int arg0, Reader arg1, long arg2) throws SQLException {
        preparedStatement.setNClob(arg0, arg1, arg2);

    }

    /**
     * <p>{@code } instances should NOT be constructed in
     * standard programming. </p>
     *
     * <p>This constructor is public to permit tools that require a JavaBean
     * instance to operate.</p>
     */
    @Override
    public void setNString(int arg0, String arg1) throws SQLException {
        preparedStatement.setNString(arg0, arg1);
    }

    /**
     * <p>{@code } instances should NOT be constructed in
     * standard programming. </p>
     *
     * <p>This constructor is public to permit tools that require a JavaBean
     * instance to operate.</p>
     */
    @Override
    public void setNull(int arg0, int arg1) throws SQLException {
        preparedStatement.setNull(arg0, arg1);

    }

    /**
     * <p>{@code } instances should NOT be constructed in
     * standard programming. </p>
     *
     * <p>This constructor is public to permit tools that require a JavaBean
     * instance to operate.</p>
     */
    @Override
    public void setNull(int arg0, int arg1, String arg2) throws SQLException {
        preparedStatement.setNull(arg0, arg1, arg2);
    }

    /**
     * <p>{@code } instances should NOT be constructed in
     * standard programming. </p>
     *
     * <p>This constructor is public to permit tools that require a JavaBean
     * instance to operate.</p>
     */
    @Override
    public void setObject(int arg0, Object arg1) throws SQLException {
        preparedStatement.setObject(arg0, arg1);
    }

    /**
     * <p>{@code } instances should NOT be constructed in
     * standard programming. </p>
     *
     * <p>This constructor is public to permit tools that require a JavaBean
     * instance to operate.</p>
     */
    @Override
    public void setObject(int arg0, Object arg1, int arg2) throws SQLException {
        preparedStatement.setObject(arg0, arg1, arg2);
    }

    /**
     * <p>{@code } instances should NOT be constructed in
     * standard programming. </p>
     *
     * <p>This constructor is public to permit tools that require a JavaBean
     * instance to operate.</p>
     */
    @Override
    public void setObject(int arg0, Object arg1, int arg2, int arg3)
            throws SQLException {
        preparedStatement.setObject(arg0, arg1, arg2, arg3);
    }

    /**
     * <p>{@code } instances should NOT be constructed in
     * standard programming. </p>
     *
     * <p>This constructor is public to permit tools that require a JavaBean
     * instance to operate.</p>
     */
    @Override
    public void setRef(int arg0, Ref arg1) throws SQLException {
        preparedStatement.setRef(arg0, arg1);

    }

    /**
     * <p>{@code } instances should NOT be constructed in
     * standard programming. </p>
     *
     * <p>This constructor is public to permit tools that require a JavaBean
     * instance to operate.</p>
     */
    @Override
    public void setRowId(int arg0, RowId arg1) throws SQLException {
        preparedStatement.setRowId(arg0, arg1);

    }

    /**
     * <p>{@code } instances should NOT be constructed in
     * standard programming. </p>
     *
     * <p>This constructor is public to permit tools that require a JavaBean
     * instance to operate.</p>
     */
    @Override
    public void setSQLXML(int arg0, SQLXML arg1) throws SQLException {
        preparedStatement.setSQLXML(arg0, arg1);

    }

    /**
     * <p>{@code } instances should NOT be constructed in
     * standard programming. </p>
     *
     * <p>This constructor is public to permit tools that require a JavaBean
     * instance to operate.</p>
     */
    @Override
    public void setShort(int arg0, short arg1) throws SQLException {
        preparedStatement.setShort(arg0, arg1);
    }

    /**
     * <p>{@code } instances should NOT be constructed in
     * standard programming. </p>
     *
     * <p>This constructor is public to permit tools that require a JavaBean
     * instance to operate.</p>
     */
    @Override
    public void setString(int arg0, String arg1) throws SQLException {
        preparedStatement.setString(arg0, arg1);
    }

    /**
     * <p>{@code } instances should NOT be constructed in
     * standard programming. </p>
     *
     * <p>This constructor is public to permit tools that require a JavaBean
     * instance to operate.</p>
     */
    @Override
    public void setTime(int arg0, Time arg1) throws SQLException {
        preparedStatement.setTime(arg0, arg1);
    }

    /**
     * <p>{@code } instances should NOT be constructed in
     * standard programming. </p>
     *
     * <p>This constructor is public to permit tools that require a JavaBean
     * instance to operate.</p>
     */
    @Override
    public void setTime(int arg0, Time arg1, Calendar arg2) throws SQLException {
        preparedStatement.setTime(arg0, arg1, arg2);
    }

    /**
     * <p>{@code } instances should NOT be constructed in
     * standard programming. </p>
     *
     * <p>This constructor is public to permit tools that require a JavaBean
     * instance to operate.</p>
     */
    @Override
    public void setTimestamp(int arg0, Timestamp arg1) throws SQLException {
        preparedStatement.setTimestamp(arg0, arg1);
    }

    /**
     * <p>{@code } instances should NOT be constructed in
     * standard programming. </p>
     *
     * <p>This constructor is public to permit tools that require a JavaBean
     * instance to operate.</p>
     */
    @Override
    public void setTimestamp(int arg0, Timestamp arg1, Calendar arg2)
            throws SQLException {
        preparedStatement.setTimestamp(arg0, arg1, arg2);

    }

    /**
     * <p>{@code } instances should NOT be constructed in
     * standard programming. </p>
     *
     * <p>This constructor is public to permit tools that require a JavaBean
     * instance to operate.</p>
     */
    @Override
    public void setURL(int arg0, URL arg1) throws SQLException {
        preparedStatement.setURL(arg0, arg1);

    }

    /**
     * <p>{@code } instances should NOT be constructed in
     * standard programming. </p>
     *
     * <p>This constructor is public to permit tools that require a JavaBean
     * instance to operate.</p>
     */
    @Override
    public void setUnicodeStream(int arg0, InputStream arg1, int arg2)
            throws SQLException {
        preparedStatement.setUnicodeStream(arg0, arg1, arg2);

    }

}
