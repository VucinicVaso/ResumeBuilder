package app.vucinicvaso.resumebuilder.presentation.view.dashboard;

import android.os.Bundle;
import android.view.ViewGroup;
import app.vucinicvaso.resumebuilder.R;
import app.vucinicvaso.resumebuilder.core.cleanarchitecture.mvvm.view.WTView;
import app.vucinicvaso.resumebuilder.core.uifactory.type.WTUIComponentType;
import app.vucinicvaso.resumebuilder.core.uifactory.component.WTUIComponent;
import app.vucinicvaso.resumebuilder.presentation.viewmodel.dashboard.DashboardViewModel;

public class DashboardView extends WTView<DashboardViewModel> {

    public DashboardView() {
        super();
        setViewModel(new DashboardViewModel());
    }

    WTUIComponent createHeader() {
        var header = uiFactory.createHeader(WTUIComponentType.HeaderType.BASIC1);
        header.setContext(this);
        header.setBackAction((v) -> finish());
        header.setBackActionIcon(R.drawable.ic_arrow_back);
        header.setBackActionLabel("Go Back");
        header.setTitle("Dashboard");
        header.setAction((v) -> System.out.println("Action !!!"));
        header.setActionIcon(R.drawable.ic_arrow_forward);
        header.setActionLabel("Action");
        return header;
    }

    WTUIComponent createBody() {
        var text = uiFactory.createText(WTUIComponentType.TextType.TEXT);
        text.setContext(this);
        text.setLabel("Click button to say HELLO !!!");

        var textButton = uiFactory.createButton(WTUIComponentType.ButtonType.TEXT);
        textButton.setContext(this);
        textButton.setLabel("SUBMIT");
        textButton.setAction(v -> text.setLabel("Hello to you too !!!"));

        var bodyLayout = uiFactory.createLayout(WTUIComponentType.LayoutType.VERTICAL_SCROLL);
        bodyLayout.setContext(this);
        bodyLayout.addComponent(text);

        var layout = uiFactory.createLayout(WTUIComponentType.LayoutType.VERTICAL);
        layout.setContext(this);
        layout.addComponent(bodyLayout);
        layout.addComponent(textButton);
        return layout;
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