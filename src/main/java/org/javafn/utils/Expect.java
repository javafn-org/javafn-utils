package org.javafn.utils;

import edu.umd.cs.findbugs.annotations.CheckReturnValue;

import java.util.function.BooleanSupplier;
import java.util.function.Supplier;

public final class Expect {

    @CheckReturnValue
    public static Supplier<IllegalStateException> optionalPresent() {
        return () -> new IllegalStateException("Already checked the presence of an optional; if triggered, this represents a programming error");
    }

    @CheckReturnValue
    public static Runnable that(final String expectation) {
        return () -> { throw new IllegalStateException("Expectation that " + expectation + " was not met"); };
    }

    public static void that(final BooleanSupplier fn, final String expectation) {
        if (!fn.getAsBoolean()) that(expectation).run();
    }

    public static void staticConstructorNotCalled() { staticConstructorNotCalled(null);}
    public static void staticConstructorNotCalled(final Class<?> clazz) {
        throw new IllegalStateException("%s is a static class and should never be instantiated"
                .formatted(clazz == null ? "This" : clazz.getCanonicalName()));
    }

    private Expect() { Expect.staticConstructorNotCalled(this.getClass()); }
}
