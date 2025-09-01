package app.vucinicvaso.resumebuilder.core.uifactory.component.button.text;

import android.view.View;
import android.widget.Button;

import app.vucinicvaso.resumebuilder.core.uifactory.component.button.WTUIButton;

public class WTUIButtonText extends WTUIButton {

    @Override
    public View build() {
        Button button = new Button(getContext());
        button.setText(getLabel());
        button.setOnClickListener(getAction());
        return button;
    }
}
