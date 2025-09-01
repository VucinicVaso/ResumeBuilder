package app.vucinicvaso.resumebuilder.core.uifactory.component.text.text;

import android.view.View;
import android.widget.TextView;
import app.vucinicvaso.resumebuilder.core.uifactory.component.text.WTUIText;

public class WTUITextText extends WTUIText {

    @Override
    public View build() {
        textView = new TextView(getContext());
        textView.setText(getLabel());
        textView.setTextSize(getLabelSize());
        return textView;
    }
}
