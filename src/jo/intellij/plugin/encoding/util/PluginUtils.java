/*
 * Copyright 2011 Joachim Heldmann
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package jo.intellij.plugin.encoding.util;

import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.DataKeys;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.command.CommandProcessor;
import com.intellij.openapi.project.Project;

/**
 * Utility methods for IntelliJ IDEA plugins.
 */
public final class PluginUtils {
// -------------------------- STATIC METHODS --------------------------

    /**
     * Execute an action inside a <code>CommandProcessor.executeCommand()</code> and
     * <code>ApplicationManager.runWriteAction()</code> command.
     *
     * @param action  Action object triggered by event
     * @param event   Event object triggered by user
     * @param command Runnable object to execute action
     */
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

// --------------------------- CONSTRUCTORS ---------------------------

    /**
     * Private constructor to prevent instantiation.
     */
    private PluginUtils() {
    }
}
