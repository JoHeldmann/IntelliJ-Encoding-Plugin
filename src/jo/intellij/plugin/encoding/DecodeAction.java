package jo.intellij.plugin.encoding;

import jo.intellij.plugin.encoding.coder.Base64Decoder;

public class DecodeAction extends AbstractEncodingPluginAction {

    private final Base64Decoder decoderBase64 = new Base64Decoder();

    @Override
    protected String codeText(String text) {
        return decoderBase64.code(text);
    }

    @Override
    protected String getName() {
        return "Decode Base64";
    }
}
