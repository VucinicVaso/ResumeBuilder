package app.vucinicvaso.resumebuilder.core.service;

public abstract class WTService<S> {

    public interface Callback<T> {
        void onComplete(T result) throws ClassNotFoundException;
    }

}
