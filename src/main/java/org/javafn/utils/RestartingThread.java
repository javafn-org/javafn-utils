package org.javafn.utils;

import java.lang.Thread.UncaughtExceptionHandler;
import java.util.function.BooleanSupplier;

public final class RestartingThread extends Thread implements UncaughtExceptionHandler {

	public interface ThreadContext {
		Runnable runnable();
		String threadName();
		boolean isRunning();
		void onThreadInstanceChanged(RestartingThread newInstance, Throwable cause);
		void onThreadInstanceExited(Throwable cause);
	}
	public static abstract class ThreadContextImpl implements ThreadContext, Runnable {
		private final String threadName;
		private final BooleanSupplier isRunning;

		public ThreadContextImpl(final String _threadName, final BooleanSupplier _isRunning ) {
			threadName = _threadName;
			isRunning = _isRunning;
		}
		@Override public Runnable runnable() { return this; }
		@Override public String threadName() { return threadName; }
		@Override public boolean isRunning() { return isRunning.getAsBoolean(); }
	}

	private final ThreadContext ctx;

	public RestartingThread(final ThreadContext _ctx) {
		super(_ctx.runnable(), _ctx.threadName());
		ctx = _ctx;
		setUncaughtExceptionHandler(this);
		start();
	}

	@Override public void run() {super.run();}

	@Override public void uncaughtException(final Thread t, final Throwable e) {
		if (ctx.isRunning()) {
			ctx.onThreadInstanceChanged(new RestartingThread(ctx), e);
		} else {
			ctx.onThreadInstanceExited(e);
		}
	}
}
