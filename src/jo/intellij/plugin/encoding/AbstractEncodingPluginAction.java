package jo.intellij.plugin.encoding;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.DataKeys;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.command.CommandProcessor;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.SelectionModel;
import com.intellij.openapi.project.Project;

public abstract class AbstractEncodingPluginAction extends AnAction {

    private Boolean hasSelection(AnActionEvent event) {
        boolean result = false;
        Editor editor = event.getData(DataKeys.EDITOR);
        if (editor != null) {
            SelectionModel selectionModel = editor.getSelectionModel();
            if (selectionModel != null) {
                result = selectionModel.hasSelection();
            }
        }
        return result;
    }

    @Override
    public void update(AnActionEvent event) {
        super.update(event);
        if (hasSelection(event)) {
            System.out.println("hasSelection = true");
            event.getPresentation().setEnabled(true);
        } else {
            System.out.println("hasSelection = false");
            event.getPresentation().setEnabled(false);
        }
    }

    protected void execute(final AnActionEvent event) {
        final Editor editor = event.getData(DataKeys.EDITOR);
        if (editor != null) {
            // Selektierten Text holen
            final SelectionModel selectionModel = editor.getSelectionModel();
            String oldText = selectionModel.getSelectedText();
            // Start und Ende merken
            final int selectionStart = selectionModel.getSelectionStart();
            final int selectionEnd = selectionModel.getSelectionEnd();

            // Text de-/encodieren
            final String newText = codeText(oldText);

            final Project project = (Project) event.getData(DataKeys.PROJECT);


            CommandProcessor.getInstance().executeCommand(
                    project,
                    new Runnable() {
                        public void run() {
                            try {
                                ApplicationManager.getApplication().runWriteAction(
                                        new Runnable() {
                                            public void run() {
                                                // Text ersetzen
                                                Document document = editor.getDocument();
                                                document.deleteString(selectionStart, selectionEnd);
                                                document.insertString(selectionStart, newText);
                                                // neuen Text selektieren
                                                if (newText != null) {
                                                    selectionModel.setSelection(selectionStart, selectionStart + newText.length());
                                                }
                                            }
                                        }
                                );
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    },
                    getActionName(),
                    "string-2"
            );
        }
    }

    protected abstract String codeText(String text);

    protected abstract String getActionName();
}
