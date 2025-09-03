package app.vucinicvaso.resumebuilder.core.uifactory.component.header;

import android.view.View;

import app.vucinicvaso.resumebuilder.core.uifactory.component.WTUIComponent;

public abstract class WTUIHeader extends WTUIComponent {

    protected int backActionIcon = 0;
    protected String backActionLabel;
    protected View.OnClickListener backAction;
    public void setBackActionIcon(int v) { backActionIcon = v; }
    public void setBackActionLabel(String v) { backActionLabel = v; }
    public void setBackAction(View.OnClickListener v) { backAction = v; }

    protected String title;
    public void setTitle(String v) { title = v; }

    protected int actionIcon = 0;
    protected String actionLabel;
    protected View.OnClickListener action;
    public void setActionIcon(int v) { actionIcon = v; }
    public void setActionLabel(String v) { actionLabel = v; }
    public void setAction(View.OnClickListener v) { action = v; }


}
