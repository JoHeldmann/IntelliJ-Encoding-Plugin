package jo.intellij.plugin.encoding;

import jo.intellij.plugin.encoding.coder.Base64Encoder;

import javax.swing.*;

public class Base64EncodeAction extends AbstractEncodingPluginAction {

    private final Base64Encoder encoderBase64 = new Base64Encoder();

    protected Base64EncodeAction() {
        super("Encode Base64", "Encode selected text to Base64", null);
    }

    @Override
    protected String codeText(String text) {
        return encoderBase64.code(text);
    }

}
