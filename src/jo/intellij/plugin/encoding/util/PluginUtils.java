package jo.intellij.plugin.encoding.util;

import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.DataKeys;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.command.CommandProcessor;
import com.intellij.openapi.project.Project;

public class PluginUtils {

    public static void executeWriteAction(AbstractPluginAction action, AnActionEvent event, final Runnable command) {
        final Project project = event.getData(DataKeys.PROJECT);
        CommandProcessor.getInstance().executeCommand(
                project,
                new Runnable() {
                    public void run() {
                        try {
                            ApplicationManager.getApplication().runWriteAction(command);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                },
                action.getName(),
                action.getDescription()
        );

    }

}
