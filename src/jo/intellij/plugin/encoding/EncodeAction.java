package jo.intellij.plugin.encoding;

import jo.intellij.plugin.encoding.coder.Base64Encoder;

public class EncodeAction extends AbstractEncodingPluginAction {

    private final Base64Encoder encoderBase64 = new Base64Encoder();

    @Override
    protected String codeText(String text) {
        return encoderBase64.code(text);
    }

    @Override
    protected String getName() {
        return "Encode Base64";
    }
}
