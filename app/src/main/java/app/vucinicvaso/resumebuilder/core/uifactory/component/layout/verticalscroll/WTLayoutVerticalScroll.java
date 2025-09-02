package app.vucinicvaso.resumebuilder.core.uifactory.component.layout.verticalscroll;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import app.vucinicvaso.resumebuilder.core.uifactory.component.WTUIComponent;
import app.vucinicvaso.resumebuilder.core.uifactory.component.layout.WTUILayout;

public class WTLayoutVerticalScroll extends WTUILayout {

    @Override
    public View build() {
        LinearLayout layout = new LinearLayout(context);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setLayoutParams(new LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        ));
        layout.setPadding(padding.get("left"), padding.get("top"), padding.get("right"), padding.get("bottom"));
        for(WTUIComponent c : components) {
            layout.addView(c.build());
        }

        ScrollView scrollView = new ScrollView(context);
        LinearLayout.LayoutParams scrollParams = new LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            0, // weight = 1 → fills remaining space
            1f
        );
        scrollView.setLayoutParams(scrollParams);
        scrollView.addView(layout);
        return scrollView;
    }

}
