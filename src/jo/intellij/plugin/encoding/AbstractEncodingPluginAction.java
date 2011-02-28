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
package jo.intellij.plugin.encoding;

import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.DataKeys;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.SelectionModel;
import jo.intellij.plugin.encoding.util.AbstractPluginAction;
import jo.intellij.plugin.encoding.util.PluginUtils;

import javax.swing.*;

/**
 * Abstract class definition for common behaviour of all plugin actions.
 */
public abstract class AbstractEncodingPluginAction extends AbstractPluginAction {
// --------------------------- CONSTRUCTORS ---------------------------

    protected AbstractEncodingPluginAction(String name, String description, Icon icon) {
        super(name, description, icon);
    }

// -------------------------- OTHER METHODS --------------------------

    /**
     * Execute triggered event.
     *
     * @param event triggered event
     */
    @Override
    public void actionPerformed(final AnActionEvent event) {
        final Editor editor = event.getData(DataKeys.EDITOR);
        if (editor != null) {
            // get selected text
            final SelectionModel selectionModel = editor.getSelectionModel();
            String oldText = selectionModel.getSelectedText();
            // keep start and end index
            final int selectionStart = selectionModel.getSelectionStart();
            final int selectionEnd = selectionModel.getSelectionEnd();

            // de-/encode text
            final String newText = codeText(oldText);

            // replace text in editor
            PluginUtils.executeWriteAction(this, event, new Runnable() {
                public void run() {
                    Document document = editor.getDocument();
                    document.deleteString(selectionStart, selectionEnd);
                    document.insertString(selectionStart, newText);
                    // neuen Text selektieren
                    selectionModel.setSelection(selectionStart, selectionStart + newText.length());
                }
            });
        }
    }

    /**
     * Code the given text.
     *
     * @param text text to code
     * @return coded text
     */
    protected abstract String codeText(String text);

    /**
     * Update enabled state in menu for the action.
     *
     * @param event Event object
     */
    @Override
    public void update(AnActionEvent event) {
        super.update(event);
        if (hasSelection(event)) {
            event.getPresentation().setEnabled(true);
        } else {
            event.getPresentation().setEnabled(false);
        }
    }

    /**
     * Helper method to check, if any text is selected in the editor.
     *
     * @param event Unused
     * @return true, if text is selected in editor
     */
    private Boolean hasSelection(AnActionEvent event) {
        boolean result = false;
        Editor editor = event.getData(DataKeys.EDITOR);
        if (editor != null) {
            SelectionModel selectionModel = editor.getSelectionModel();
            result = selectionModel.hasSelection();
        }
        return result;
    }
}
