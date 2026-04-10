package org.javafn.utils;

import jakarta.annotation.Nonnull;

import java.util.Objects;

/**
 * Provide calling code a method to clean up an object without having that functionality
 * be exposed in the object's public API.
 *
 * <pre>{@code
 * var mgrHandle = MyManager.construct();
 * untrusted.stream().forEach(u -> u.visit(mgrHandle.component()));
 * mgrHandle = mgrHandle.halt();
 * }</pre>
 *
 * This object and its halt function is not threadsafe.  The intended use is for a single
 * managing component to access the handle, e.g., {@link Runtime#addShutdownHook(Thread)}
 * taking ownership and calling {@link #halt()} in its thread.
 */
public final class Haltable<C> {

	private C component;
	private Runnable haltFn;

	public Haltable(@Nonnull final C _component, @Nonnull final Runnable _haltFn) {
		component = Objects.requireNonNull(_component);
		haltFn = Objects.requireNonNull(_haltFn);
	}

	/**
	 * Return the component, or null if this has been halted
	 */
	public C component() {
		return component;
	}

	@SuppressWarnings("SameReturnValue")
	public Haltable<C> halt() {
		if (component == null) return null;
		component = null;
		haltFn.run();
		haltFn = null;
		return null;
	}
}