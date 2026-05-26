package org.javafn.utils;

import java.util.function.BooleanSupplier;

public final class Expect {

    public static void that(final String expectation) {
        throw new IllegalStateException("Expectation that " + expectation + " was not met");
    }

    public static void that(final BooleanSupplier fn, final String expectation) {
        if (!fn.getAsBoolean()) that(expectation);
    }

    public static void staticConstructorNotCalled() { staticConstructorNotCalled(null);}
    public static void staticConstructorNotCalled(final Class<?> clazz) {
        throw new IllegalStateException("%s is a static class and should never be instantiated"
                .formatted(clazz == null ? "This" : clazz.getCanonicalName()));
    }

    private Expect() { Expect.staticConstructorNotCalled(this.getClass()); }
}
