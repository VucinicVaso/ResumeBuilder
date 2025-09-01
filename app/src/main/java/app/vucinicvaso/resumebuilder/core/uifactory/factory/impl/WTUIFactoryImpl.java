package app.vucinicvaso.resumebuilder.core.uifactory.factory.impl;

import app.vucinicvaso.resumebuilder.core.uifactory.component.layout.WTUILayout;
import app.vucinicvaso.resumebuilder.core.uifactory.component.layout.horizontal.WTUILayoutHorizontal;
import app.vucinicvaso.resumebuilder.core.uifactory.component.layout.vertical.WTUILayoutVertical;
import app.vucinicvaso.resumebuilder.core.uifactory.factory.WTUIFactory;
import app.vucinicvaso.resumebuilder.core.uifactory.type.WTUIComponentType;
import app.vucinicvaso.resumebuilder.core.uifactory.component.text.WTUIText;
import app.vucinicvaso.resumebuilder.core.uifactory.component.text.text.WTUITextText;
import app.vucinicvaso.resumebuilder.core.uifactory.component.button.WTUIButton;
import app.vucinicvaso.resumebuilder.core.uifactory.component.button.text.WTUIButtonText;

public class WTUIFactoryImpl extends WTUIFactory {

    @Override
    public WTUILayout createLayout(WTUIComponentType.LayoutType type) {
        switch(type) {
            case HORIZONTAL:
                var layoutHorizontal = new WTUILayoutHorizontal();
                return layoutHorizontal;
            case VERTICAL:
                var layoutVertical = new WTUILayoutVertical();
                return layoutVertical;
            default:
                return null;
        }
    }

    @Override
    public WTUIButton createButton(WTUIComponentType.ButtonType type) {
        switch(type) {
            case TEXT:
                var component = new WTUIButtonText();
                return component;
            default:
                return null;
        }
    }

    @Override
    public WTUIText createText(WTUIComponentType.TextType type) {
        switch(type) {
            case TEXT:
                var component = new WTUITextText();
                component.setLabelSize(20f);
                return component;
            default:
                return null;
        }
    }
}
