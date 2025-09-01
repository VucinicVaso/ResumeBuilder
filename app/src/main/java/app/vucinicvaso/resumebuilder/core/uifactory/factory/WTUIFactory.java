package app.vucinicvaso.resumebuilder.core.uifactory.factory;

import app.vucinicvaso.resumebuilder.core.uifactory.component.header.WTUIHeader;
import app.vucinicvaso.resumebuilder.core.uifactory.component.layout.WTUILayout;
import app.vucinicvaso.resumebuilder.core.uifactory.component.text.WTUIText;
import app.vucinicvaso.resumebuilder.core.uifactory.type.WTUIComponentType;
import app.vucinicvaso.resumebuilder.core.uifactory.component.button.WTUIButton;

public abstract class WTUIFactory {

    public abstract WTUILayout createLayout(WTUIComponentType.LayoutType type);

    public abstract WTUIHeader createHeader(WTUIComponentType.HeaderType type);

    public abstract WTUIButton createButton(WTUIComponentType.ButtonType type);

    public abstract WTUIText createText(WTUIComponentType.TextType type);

}
