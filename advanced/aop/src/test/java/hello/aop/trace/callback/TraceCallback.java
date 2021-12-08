package hello.aop.trace.callback;

public interface TraceCallback<T> {
    T call();
}
