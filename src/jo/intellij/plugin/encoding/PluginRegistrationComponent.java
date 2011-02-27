package jo.intellij.plugin.encoding;

import com.intellij.openapi.actionSystem.*;
import com.intellij.openapi.components.ApplicationComponent;
import org.jetbrains.annotations.NotNull;

public class PluginRegistrationComponent implements ApplicationComponent {

    @Override
    public void initComponent() {
        ActionManager actionManager = ActionManager.getInstance();
        Base64DecodeAction base64DecodeAction = new Base64DecodeAction();
        actionManager.registerAction(base64DecodeAction.getName(), base64DecodeAction);
        Base64EncodeAction base64EncodeAction = new Base64EncodeAction();
        actionManager.registerAction(base64EncodeAction.getName(), base64EncodeAction);

        DefaultActionGroup actionGroup = new DefaultActionGroup("Encode/Decode", true);
        actionManager.registerAction(actionGroup.toString(), actionGroup);
        actionGroup.add(base64DecodeAction);
        actionGroup.add(base64EncodeAction);
        
        DefaultActionGroup editMenu = (DefaultActionGroup) actionManager.getAction("EditMenu");
        editMenu.add(actionGroup);
    }

    public void disposeComponent() {
    }

    @NotNull
    public String getComponentName() {
        return "Encoding Plugin Component";
    }
}
