package jo.intellij.plugin.encoding;

import com.intellij.openapi.actionSystem.AnActionEvent;
import sun.misc.BASE64Decoder;

import java.io.IOException;

public class DecodeAction extends AbstractEncodingPluginAction {

    @Override
    public void actionPerformed(AnActionEvent event) {
        System.out.println("######### DecodeAction");
        execute(event);
    }

    @Override
    protected String codeText(String text) {
        BASE64Decoder decoder = new BASE64Decoder();
        String result = null;
        try {
            result = new String(decoder.decodeBuffer(text), "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return result;
    }

    @Override
    protected String getActionName() {
        return "Decode";
    }
}
