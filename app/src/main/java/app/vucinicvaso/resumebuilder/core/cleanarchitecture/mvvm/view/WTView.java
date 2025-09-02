package app.vucinicvaso.resumebuilder.core.cleanarchitecture.mvvm.view;

import androidx.appcompat.app.AppCompatActivity;
import app.vucinicvaso.resumebuilder.core.uifactory.factory.WTUIFactory;
import app.vucinicvaso.resumebuilder.core.uifactory.factory.impl.WTUIFactoryImpl;

public abstract class WTView<M> extends AppCompatActivity {

    protected WTView() {
        setUiFactory();
    }

    protected M viewModel;
    public void setViewModel(M m) {
        viewModel = m;
    }

    protected WTUIFactory uiFactory;
    void setUiFactory() {
        uiFactory = WTUIFactoryImpl.getInstance();
    }

}
