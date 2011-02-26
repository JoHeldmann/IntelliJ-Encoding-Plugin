package jo.intellij.plugin.encoding.coder;

import sun.misc.BASE64Decoder;

import java.io.IOException;

public class Base64Decoder extends Coder {

    @Override
    protected String codeText(String text) {
        BASE64Decoder decoder = new BASE64Decoder();
        String result = null;
        try {
            result = new String(decoder.decodeBuffer(text), "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}