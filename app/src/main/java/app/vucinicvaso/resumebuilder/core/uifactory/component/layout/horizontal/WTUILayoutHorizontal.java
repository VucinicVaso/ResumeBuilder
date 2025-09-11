package app.vucinicvaso.resumebuilder.core.uifactory.component.layout.horizontal;

import android.view.View;
import android.widget.LinearLayout;
import app.vucinicvaso.resumebuilder.core.uifactory.component.WTUIComponent;
import app.vucinicvaso.resumebuilder.core.uifactory.component.layout.WTUILayout;

public class WTUILayoutHorizontal extends WTUILayout {

    @Override
    public View build() {
        LinearLayout layout = new LinearLayout(getContext());
        layout.setOrientation(LinearLayout.HORIZONTAL);
        layout.setPadding(
            padding.get("left"),
            padding.get("top"),
            padding.get("right"),
            padding.get("bottom")
        );
        if(!components.isEmpty()) {
            for(WTUIComponent c : components) {
                layout.addView(c.build());
            }
        }
        return layout;
    }

}
