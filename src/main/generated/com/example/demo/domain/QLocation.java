package com.example.demo.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QLocation is a Querydsl query type for Location
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QLocation extends EntityPathBase<Location> {

    private static final long serialVersionUID = -1461154043L;

    public static final QLocation location = new QLocation("location");

    public final StringPath continentCode = createString("continentCode");

    public final StringPath continentName = createString("continentName");

    public final StringPath countryIsoCode = createString("countryIsoCode");

    public final StringPath countryName = createString("countryName");

    public final StringPath geonameId = createString("geonameId");

    public final BooleanPath isInEuropeanUnion = createBoolean("isInEuropeanUnion");

    public final StringPath localeCode = createString("localeCode");

    public QLocation(String variable) {
        super(Location.class, forVariable(variable));
    }

    public QLocation(Path<? extends Location> path) {
        super(path.getType(), path.getMetadata());
    }

    public QLocation(PathMetadata metadata) {
        super(Location.class, metadata);
    }

}

