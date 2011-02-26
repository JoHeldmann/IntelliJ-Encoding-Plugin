package jo.intellij.plugin.encoding;

import com.intellij.openapi.actionSystem.AnActionEvent;
import sun.misc.BASE64Encoder;

public class EncodeAction extends AbstractEncodingPluginAction {

    @Override
    public void actionPerformed(AnActionEvent event) {
        System.out.println("######### EncodeAction");
        execute(event);

//        Project project = event.getData(PlatformDataKeys.PROJECT);
//        String txt = Messages.showInputDialog(project, "What is your name?", "Input your name", Messages.getQuestionIcon());
//        Messages.showMessageDialog(project, "Hello, " + txt + "!\n I am glad to see you.", "Information", Messages.getInformationIcon());

    }

    @Override
    protected String codeText(String text) {
        BASE64Encoder encoder = new BASE64Encoder();
        String result = encoder.encode(text.getBytes());
        return result;
    }

    @Override
    protected String getActionName() {
        return "Encode";
    }
}
