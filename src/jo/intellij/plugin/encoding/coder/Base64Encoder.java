package jo.intellij.plugin.encoding.coder;

import sun.misc.BASE64Encoder;

public class Base64Encoder extends Coder {

    @Override
    protected String codeText(String text) {

        BASE64Encoder encoder = new BASE64Encoder();
        String result = encoder.encode(text.getBytes());

        return result;
    }
}