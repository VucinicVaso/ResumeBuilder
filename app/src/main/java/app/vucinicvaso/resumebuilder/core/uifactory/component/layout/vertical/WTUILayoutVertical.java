package app.vucinicvaso.resumebuilder.core.uifactory.component.layout.vertical;

import android.view.View;
import android.widget.LinearLayout;
import app.vucinicvaso.resumebuilder.core.uifactory.component.WTUIComponent;
import app.vucinicvaso.resumebuilder.core.uifactory.component.layout.WTUILayout;

public class WTUILayoutVertical extends WTUILayout {

    @Override
    public View build() {
        LinearLayout layout = new LinearLayout(getContext());
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setPadding(padding.get("left"), padding.get("top"), padding.get("right"), padding.get("bottom"));
        for(WTUIComponent c : components) {
            layout.addView(c.build());
        }
        return layout;
    }

}
