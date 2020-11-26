/*
 * This file is generated by jOOQ.
 */
package com.kpdoggie.ingest.fileingest.schema.tables;


import com.kpdoggie.ingest.fileingest.schema.Keys;
import com.kpdoggie.ingest.fileingest.schema.Public;
import com.kpdoggie.ingest.fileingest.schema.tables.records.CachedSRecord;

import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row2;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class CachedS extends TableImpl<CachedSRecord> {

    private static final long serialVersionUID = -187569697;

    /**
     * The reference instance of <code>PUBLIC.CACHED_S</code>
     */
    public static final CachedS CACHED_S = new CachedS();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<CachedSRecord> getRecordType() {
        return CachedSRecord.class;
    }

    /**
     * The column <code>PUBLIC.CACHED_S.S_ID</code>.
     */
    public final TableField<CachedSRecord, Integer> S_ID = createField(DSL.name("S_ID"), org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>PUBLIC.CACHED_S.S_NAME</code>.
     */
    public final TableField<CachedSRecord, String> S_NAME = createField(DSL.name("S_NAME"), org.jooq.impl.SQLDataType.VARCHAR(20), this, "");

    /**
     * Create a <code>PUBLIC.CACHED_S</code> table reference
     */
    public CachedS() {
        this(DSL.name("CACHED_S"), null);
    }

    /**
     * Create an aliased <code>PUBLIC.CACHED_S</code> table reference
     */
    public CachedS(String alias) {
        this(DSL.name(alias), CACHED_S);
    }

    /**
     * Create an aliased <code>PUBLIC.CACHED_S</code> table reference
     */
    public CachedS(Name alias) {
        this(alias, CACHED_S);
    }

    private CachedS(Name alias, Table<CachedSRecord> aliased) {
        this(alias, aliased, null);
    }

    private CachedS(Name alias, Table<CachedSRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    public <O extends Record> CachedS(Table<O> child, ForeignKey<O, CachedSRecord> key) {
        super(child, key, CACHED_S);
    }

    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    @Override
    public Identity<CachedSRecord, Integer> getIdentity() {
        return Keys.IDENTITY_CACHED_S;
    }

    @Override
    public UniqueKey<CachedSRecord> getPrimaryKey() {
        return Keys.CONSTRAINT_1;
    }

    @Override
    public List<UniqueKey<CachedSRecord>> getKeys() {
        return Arrays.<UniqueKey<CachedSRecord>>asList(Keys.CONSTRAINT_1);
    }

    @Override
    public CachedS as(String alias) {
        return new CachedS(DSL.name(alias), this);
    }

    @Override
    public CachedS as(Name alias) {
        return new CachedS(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public CachedS rename(String name) {
        return new CachedS(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public CachedS rename(Name name) {
        return new CachedS(name, null);
    }

    // -------------------------------------------------------------------------
    // Row2 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row2<Integer, String> fieldsRow() {
        return (Row2) super.fieldsRow();
    }
}