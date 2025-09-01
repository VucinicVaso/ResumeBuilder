package app.vucinicvaso.resumebuilder.core.uifactory.component.button;

import android.view.View;
import app.vucinicvaso.resumebuilder.core.uifactory.component.WTUIComponent;

public abstract class WTUIButton extends WTUIComponent {

    protected View.OnClickListener action;
    public void setAction(View.OnClickListener v) { action = v; }
    public View.OnClickListener getAction() { return action; }

    protected String label = "";
    public void setLabel(String v) { label = v; }
    public String getLabel() { return label; }

}
