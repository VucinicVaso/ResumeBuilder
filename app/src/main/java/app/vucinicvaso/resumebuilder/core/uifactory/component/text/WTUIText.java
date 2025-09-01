package app.vucinicvaso.resumebuilder.core.uifactory.component.text;

import android.widget.TextView;
import app.vucinicvaso.resumebuilder.core.uifactory.component.WTUIComponent;

public abstract class WTUIText extends WTUIComponent {

    public TextView textView;

    private float labelSize = 0;
    public void setLabelSize(float v) { labelSize = v; }
    public float getLabelSize() { return labelSize; }

    private String label = "";
    public void setLabel(String v) {
        label = v;
        if(textView != null) { textView.setText(label); }
    }
    public String getLabel() { return label; }

}
