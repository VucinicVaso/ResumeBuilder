package app.vucinicvaso.resumebuilder.core.cleanarchitecture.usecase;

public abstract class WTUseCaseWithParams<T, P> {

    public abstract T call(P params);

}
