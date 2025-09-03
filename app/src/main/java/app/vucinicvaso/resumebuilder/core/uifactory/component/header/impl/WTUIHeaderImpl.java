package app.vucinicvaso.resumebuilder.core.uifactory.component.header.impl;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import app.vucinicvaso.resumebuilder.core.uifactory.component.header.WTUIHeader;

public class WTUIHeaderImpl extends WTUIHeader {

    View createBackActionComponent() {
        var button = new Button(context);
        button.setOnClickListener(backAction);
        button.setText(backActionLabel);
        button.setAllCaps(false);
        button.setCompoundDrawablesWithIntrinsicBounds(backActionIcon, 0, 0, 0);
        button.setPadding(16, 0, 16, 0);
        return button;
    }

    View createTitleComponent() {
        var titleView = new TextView(context);
        titleView.setText(title);
        titleView.setTextSize(20f);
        titleView.setTypeface(null, android.graphics.Typeface.BOLD);
        titleView.setGravity(android.view.Gravity.CENTER);

        var titleParams = new LinearLayout.LayoutParams(
            0,
            android.widget.LinearLayout.LayoutParams.WRAP_CONTENT,
            1f
        );
        titleView.setLayoutParams(titleParams);

        return titleView;
    }

    View createActionComponent() {
        var button = new android.widget.Button(context);
        button.setText(actionLabel);
        button.setAllCaps(false);
        button.setCompoundDrawablesWithIntrinsicBounds(actionIcon, 0, 0, 0);
        button.setPadding(16, 0, 16, 0);
        return button;
    }

    @Override
    public View build() {
        LinearLayout rootLayout = new LinearLayout(context);
        rootLayout.setOrientation(android.widget.LinearLayout.HORIZONTAL);
        rootLayout.setLayoutParams(
            new android.widget.LinearLayout.LayoutParams(
                android.widget.LinearLayout.LayoutParams.MATCH_PARENT,
                android.widget.LinearLayout.LayoutParams.WRAP_CONTENT
            )
        );
        rootLayout.setPadding(4, 16, 4, 16);
        rootLayout.setGravity(android.view.Gravity.CENTER_VERTICAL);

        if(backActionIcon != 0 || backActionLabel != null) rootLayout.addView(createBackActionComponent());
        if(title != null) rootLayout.addView(createTitleComponent());
        if(actionIcon != 0 || actionLabel != null) rootLayout.addView(createActionComponent());
        return rootLayout;
    }

}
