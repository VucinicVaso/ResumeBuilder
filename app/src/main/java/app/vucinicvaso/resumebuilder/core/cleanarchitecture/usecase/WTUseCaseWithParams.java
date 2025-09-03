package app.vucinicvaso.resumebuilder.core.cleanarchitecture.usecase;

import android.content.Context;

public abstract class WTUseCaseWithParams<P, T> {

    public interface Callback<T> {
        void onComplete(T result);
    }

    public abstract void call(Context context, P params, Callback<T> callback);

}
