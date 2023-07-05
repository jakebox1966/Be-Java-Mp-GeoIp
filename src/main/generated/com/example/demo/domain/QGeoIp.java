package com.example.demo.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QGeoIp is a Querydsl query type for GeoIp
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QGeoIp extends EntityPathBase<GeoIp> {

    private static final long serialVersionUID = 1994971912L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QGeoIp geoIp = new QGeoIp("geoIp");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath isAnonymousProxy = createString("isAnonymousProxy");

    public final StringPath isSatelliteProvider = createString("isSatelliteProvider");

    public final QLocation location;

    public final NumberPath<Long> networkEnd = createNumber("networkEnd", Long.class);

    public final NumberPath<Long> networkStart = createNumber("networkStart", Long.class);

    public final NumberPath<Long> registeredCountryGeoNameId = createNumber("registeredCountryGeoNameId", Long.class);

    public final NumberPath<Long> representedCountryGeoNameId = createNumber("representedCountryGeoNameId", Long.class);

    public QGeoIp(String variable) {
        this(GeoIp.class, forVariable(variable), INITS);
    }

    public QGeoIp(Path<? extends GeoIp> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QGeoIp(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QGeoIp(PathMetadata metadata, PathInits inits) {
        this(GeoIp.class, metadata, inits);
    }

    public QGeoIp(Class<? extends GeoIp> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.location = inits.isInitialized("location") ? new QLocation(forProperty("location")) : null;
    }

}

