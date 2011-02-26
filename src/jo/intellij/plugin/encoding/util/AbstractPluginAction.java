package jo.intellij.plugin.encoding.util;

import com.intellij.openapi.actionSystem.AnAction;

import javax.swing.*;

public abstract class AbstractPluginAction extends AnAction {

    private String name;
    private String description;

    protected AbstractPluginAction(String name, String description, Icon icon) {
        super(name, description, icon);
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
