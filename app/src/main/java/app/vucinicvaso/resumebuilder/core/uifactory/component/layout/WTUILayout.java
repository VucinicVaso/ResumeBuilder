package app.vucinicvaso.resumebuilder.core.uifactory.component.layout;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import app.vucinicvaso.resumebuilder.core.uifactory.component.WTUIComponent;

public abstract class WTUILayout extends WTUIComponent {

    protected Map<String, Integer> padding = new HashMap<String, Integer>();
    public void setPadding(int left, int top, int right, int bottom) {
        padding.put("left", left);
        padding.put("top", top);
        padding.put("right", right);
        padding.put("bottom", bottom);
    }

    protected List<WTUIComponent> components = new ArrayList<WTUIComponent>();
    public void addComponent(WTUIComponent v) { components.add(v); }
    public List<WTUIComponent> getComponents() { return components; }
}
