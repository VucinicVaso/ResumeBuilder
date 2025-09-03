package app.vucinicvaso.resumebuilder.core.cleanarchitecture.usecase;

import android.content.Context;

public abstract class WTUseCase<T> {

    public interface Callback<T> {
        void onComplete(T result);
    }

    public abstract void call(Context context, Callback<T> callback);

}
