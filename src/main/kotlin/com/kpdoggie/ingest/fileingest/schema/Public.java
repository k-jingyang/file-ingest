/*
 * This file is generated by jOOQ.
 */
package com.kpdoggie.ingest.fileingest.schema;


import com.kpdoggie.ingest.fileingest.schema.tables.People;

import java.util.Arrays;
import java.util.List;

import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Public extends SchemaImpl {

    private static final long serialVersionUID = -1699639494;

    /**
     * The reference instance of <code>PUBLIC</code>
     */
    public static final Public PUBLIC = new Public();

    /**
     * The table <code>PUBLIC.PEOPLE</code>.
     */
    public final People PEOPLE = People.PEOPLE;

    /**
     * No further instances allowed
     */
    private Public() {
        super("PUBLIC", null);
    }


    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        return Arrays.<Table<?>>asList(
            People.PEOPLE);
    }
}