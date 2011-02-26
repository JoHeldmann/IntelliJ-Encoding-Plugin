package jo.intellij.plugin.encoding;

import jo.intellij.plugin.encoding.coder.Base64Decoder;

public class Base64DecodeAction extends AbstractEncodingPluginAction {
    public Base64DecodeAction() {
        super("Decode Base64", "Decode selected text from Base64", null);
    }

    private final Base64Decoder decoderBase64 = new Base64Decoder();

    @Override
    protected String codeText(String text) {
        return decoderBase64.code(text);
    }
}
