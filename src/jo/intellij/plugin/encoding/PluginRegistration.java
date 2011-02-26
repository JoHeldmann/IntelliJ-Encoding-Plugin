package jo.intellij.plugin.encoding;

import com.intellij.openapi.actionSystem.ActionGroup;
import com.intellij.openapi.actionSystem.ActionManager;
import com.intellij.openapi.actionSystem.ActionPopupMenu;
import com.intellij.openapi.actionSystem.DefaultActionGroup;
import com.intellij.openapi.components.ApplicationComponent;
import org.jetbrains.annotations.NotNull;

public class PluginRegistration implements ApplicationComponent {
    public void initComponent() {
        ActionManager am = ActionManager.getInstance();
        Base64DecodeAction base64DecodeAction = new Base64DecodeAction();
        am.registerAction(base64DecodeAction.getName(), base64DecodeAction);
        Base64EncodeAction base64EncodeAction = new Base64EncodeAction();
        am.registerAction(base64EncodeAction.getName(), base64EncodeAction);

        DefaultActionGroup editMenu = (DefaultActionGroup) am.getAction("EditMenu");
        editMenu.add(base64DecodeAction);
        editMenu.add(base64EncodeAction);

        ActionPopupMenu menu = am.createActionPopupMenu("Encode/Decode", editMenu);

        /*
        <group id = "EncodingPlugin.Menu"
        text = "Encode/Decode"
        description = "Encode/Decode selected text"
        popup = "true" >
        <add - to - group
        group - id = "EditMenu"
        anchor = "last" / >
        <action id = "EncodingPlugin.Encode"
        class="jo.intellij.plugin.encoding.Base64EncodeAction"
        text = "Encode"
        description = "Encode selected text" / >
        <action id = "EncodingPlugin.Decode"
        class="jo.intellij.plugin.encoding.Base64DecodeAction"
        text = "Decode"
        description = "Decode selected text" / >
        </group >
        */
    }

    public void disposeComponent() {
    }

    @NotNull
    public String getComponentName() {
        return "Encoding Plugin";
    }
}
