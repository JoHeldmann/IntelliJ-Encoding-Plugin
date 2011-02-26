package jo.intellij.plugin.encoding.util;

import com.intellij.openapi.actionSystem.AnAction;

public abstract class AbstractPluginAction extends AnAction {

    protected abstract String getName();

    public String getDescription() {
        return "description";
    }
}
