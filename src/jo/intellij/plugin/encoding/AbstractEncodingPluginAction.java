package jo.intellij.plugin.encoding;

import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.DataKeys;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.SelectionModel;
import jo.intellij.plugin.encoding.util.AbstractPluginAction;
import jo.intellij.plugin.encoding.util.PluginUtils;

public abstract class AbstractEncodingPluginAction extends AbstractPluginAction {

    private Boolean hasSelection(AnActionEvent event) {
        boolean result = false;
        Editor editor = event.getData(DataKeys.EDITOR);
        if (editor != null) {
            SelectionModel selectionModel = editor.getSelectionModel();
            result = selectionModel.hasSelection();
        }
        return result;
    }

    @Override
    public void update(AnActionEvent event) {
        super.update(event);
        if (hasSelection(event)) {
//            System.out.println("hasSelection = true");
            event.getPresentation().setEnabled(true);
        } else {
//            System.out.println("hasSelection = false");
            event.getPresentation().setEnabled(false);
        }
    }

    @Override
    public void actionPerformed(final AnActionEvent event) {
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

            PluginUtils.executeWriteAction(this, event, new Runnable() {
                public void run() {
                    // Text ersetzen
                    Document document = editor.getDocument();
                    document.deleteString(selectionStart, selectionEnd);
                    document.insertString(selectionStart, newText);
                    // neuen Text selektieren
                    selectionModel.setSelection(selectionStart, selectionStart + newText.length());
                }
            });
        }
    }

    protected abstract String codeText(String text);

}
