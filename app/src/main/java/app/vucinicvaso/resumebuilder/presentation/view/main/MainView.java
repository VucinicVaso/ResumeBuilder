package app.vucinicvaso.resumebuilder.presentation.view.main;

import android.os.Bundle;
import android.view.ViewGroup;
import app.vucinicvaso.resumebuilder.R;
import app.vucinicvaso.resumebuilder.core.cleanarchitecture.mvvm.view.WTView;
import app.vucinicvaso.resumebuilder.core.uifactory.type.WTUIComponentType;
import app.vucinicvaso.resumebuilder.core.uifactory.component.WTUIComponent;
import app.vucinicvaso.resumebuilder.presentation.viewmodel.main.MainViewModel;

public class MainView extends WTView<MainViewModel> {

    public MainView() {
        super();
        setViewModel(new MainViewModel(this));
    }

    WTUIComponent createHeader() {
        var header = uiFactory.createHeader(WTUIComponentType.HeaderType.BASIC1);
        header.setContext(this);
        header.setBackAction((v) -> System.out.println("Header back action"));
        header.setBackActionIcon(R.drawable.ic_arrow_back);
        header.setBackActionLabel("Dashboard");
        header.setTitle("ResumeBuilder");
        header.setAction((v) -> System.out.println("Header action"));
        header.setActionIcon(R.drawable.ic_arrow_forward);
        header.setActionLabel("Action");
        return header;
    }

    WTUIComponent createBody() {
        var text = uiFactory.createText(WTUIComponentType.TextType.TEXT);
        text.setContext(this);
        text.setLabel("Click button to update this text (No XML)!");

        var textButton = uiFactory.createButton(WTUIComponentType.ButtonType.TEXT);
        textButton.setContext(this);
        textButton.setLabel("SUBMIT");
        textButton.setAction(v -> text.setLabel("Button Clicked !!!"));

        var bodyLayout = uiFactory.createLayout(WTUIComponentType.LayoutType.VERTICAL_SCROLL);
        bodyLayout.setContext(this);
        bodyLayout.addComponent(text);
        bodyLayout.addComponent(textButton);
        return bodyLayout;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        var parentLayout = uiFactory.createLayout(WTUIComponentType.LayoutType.VERTICAL);
        parentLayout.setContext(this);
        parentLayout.setPadding(10, 20, 10, 20);
        parentLayout.addComponent(createHeader());
        parentLayout.addComponent(createBody());

        // Set layout as the activity content
        setContentView(
            parentLayout.build(),
            new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
        );
    }

}