package app.vucinicvaso.resumebuilder;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import app.vucinicvaso.resumebuilder.core.uifactory.factory.WTUIFactory;
import app.vucinicvaso.resumebuilder.core.uifactory.factory.impl.WTUIFactoryImpl;
import app.vucinicvaso.resumebuilder.core.uifactory.type.WTUIComponentType;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        WTUIFactory uiFactory = new WTUIFactoryImpl();

        var text = uiFactory.createText(WTUIComponentType.TextType.TEXT);
        text.setContext(this);
        text.setLabel("Click button to update this text (No XML)!");

        var textButton = uiFactory.createButton(WTUIComponentType.ButtonType.TEXT);
        textButton.setContext(this);
        textButton.setLabel("SUBMIT");
        textButton.setAction(v -> text.setLabel("Button Clicked !!!"));

        // Add components to Parent Layout
        var verticalLayout = uiFactory.createLayout(WTUIComponentType.LayoutType.VERTICAL);
        verticalLayout.setContext(this);
        verticalLayout.setPadding(60, 60, 60, 60);
        verticalLayout.addComponent(text);
        verticalLayout.addComponent(textButton);

        // Set layout as the activity content
        setContentView(
            verticalLayout.build(),
            new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
        );
    }

}
