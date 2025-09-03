package app.vucinicvaso.resumebuilder.presentation.view.main;

import android.os.Bundle;
import android.view.ViewGroup;
import app.vucinicvaso.resumebuilder.R;
import app.vucinicvaso.resumebuilder.core.cleanarchitecture.mvvm.view.WTView;
import app.vucinicvaso.resumebuilder.core.uifactory.type.WTUIComponentType;
import app.vucinicvaso.resumebuilder.core.uifactory.component.WTUIComponent;
import app.vucinicvaso.resumebuilder.presentation.bindings.router.ResumeBuilderRoutes;
import app.vucinicvaso.resumebuilder.presentation.viewmodel.main.MainViewModel;

public class MainView extends WTView<MainViewModel> {

    public MainView() {
        super();
        setViewModel(new MainViewModel());
        new ResumeBuilderRoutes();
    }

    WTUIComponent createHeader() {
        var header = uiFactory.createHeader(WTUIComponentType.HeaderType.BASIC1);
        header.setContext(this);
        header.setTitle("ResumeBuilder");
        return header;
    }

    WTUIComponent createBody() {
        var text = uiFactory.createText(WTUIComponentType.TextType.TEXT);
        text.setContext(this);
        text.setLabel("Click SUBMIT button to get started");

        var textButton = uiFactory.createButton(WTUIComponentType.ButtonType.TEXT);
        textButton.setContext(this);
        textButton.setLabel("SUBMIT");
        textButton.setAction(v -> viewModel.init(this));

        var bodyLayout = uiFactory.createLayout(WTUIComponentType.LayoutType.VERTICAL_SCROLL);
        bodyLayout.setContext(this);
        bodyLayout.addComponent(text);
        bodyLayout.addComponent(textButton);
        return bodyLayout;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        var layout = uiFactory.createLayout(WTUIComponentType.LayoutType.VERTICAL);
        layout.setContext(this);
        layout.setPadding(10, 20, 10, 20);
        layout.addComponent(createHeader());
        layout.addComponent(createBody());

        setContentView(
            layout.build(),
            new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
        );
    }

}