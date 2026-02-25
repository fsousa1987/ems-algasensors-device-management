package com.algaworks.algasensors.device.management.common;

import io.hypersistence.tsid.TSID;

import java.util.Optional;

public class IdGenerator {

    private static final String TSID_NODE_COUNT = "tsid.node.count";
    private static final String TSID_NODE = "tsid.node";
    private static final String DEFAULT_NODE_COUNT = "32";

    private static final TSID.Factory tsidFactory;

    static {
        Optional.ofNullable(System.getenv(TSID_NODE))
                .ifPresent(tsidNode -> System.setProperty(TSID_NODE, tsidNode));

        Optional.ofNullable(System.getenv(TSID_NODE_COUNT))
                .ifPresent(tsidNodeCount -> System.setProperty(TSID_NODE_COUNT, tsidNodeCount));


        System.setProperty(TSID_NODE_COUNT, DEFAULT_NODE_COUNT);

        tsidFactory = TSID.Factory.builder().build();
    }

    private IdGenerator() {

    }

    public static TSID generateTSID() {
        return tsidFactory.generate();
    }

}
