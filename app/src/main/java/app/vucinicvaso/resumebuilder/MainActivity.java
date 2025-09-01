package app.vucinicvaso.resumebuilder;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.ViewGroup;
import app.vucinicvaso.resumebuilder.core.uifactory.factory.WTUIFactory;
import app.vucinicvaso.resumebuilder.core.uifactory.factory.impl.WTUIFactoryImpl;
import app.vucinicvaso.resumebuilder.core.uifactory.type.WTUIComponentType;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        WTUIFactory uiFactory = new WTUIFactoryImpl();

        var header = uiFactory.createHeader(WTUIComponentType.HeaderType.BASIC1);
        header.setContext(this);
        header.setBackAction((v) -> System.out.println("Header back action"));
        header.setBackActionIcon(R.drawable.ic_arrow_back);
        header.setBackActionLabel("Dashboard");
        header.setTitle("ResumeBuilder");
        header.setAction((v) -> System.out.println("Header action"));
        header.setActionIcon(R.drawable.ic_arrow_forward);
        header.setActionLabel("Action");

        var text = uiFactory.createText(WTUIComponentType.TextType.TEXT);
        text.setContext(this);
        text.setLabel("Click button to update this text (No XML)!");

        var textButton = uiFactory.createButton(WTUIComponentType.ButtonType.TEXT);
        textButton.setContext(this);
        textButton.setLabel("SUBMIT");
        textButton.setAction(v -> text.setLabel("Button Clicked !!!"));

        // Add components to Parent Layout
        var parentLayout = uiFactory.createLayout(WTUIComponentType.LayoutType.VERTICAL);
        parentLayout.setContext(this);
        parentLayout.setPadding(60, 60, 60, 60);
        parentLayout.addComponent(header);
        parentLayout.addComponent(text);
        parentLayout.addComponent(textButton);

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
