package jo.intellij.plugin.encoding.coder;

public abstract class Coder {
    protected abstract String codeText(String text);

    public String code(String text) {

        boolean appendSemicolon = false;
        boolean appendQuote = false;
        text = text.trim();
        if (text.endsWith(";")) {
            text = text.substring(0, text.length() - 1);
            appendSemicolon = true;
        }
        if (text.startsWith("\"") && text.endsWith("\"")) {
            text = text.substring(1, text.length());
            text = text.substring(0, text.length() - 1);
            appendQuote = true;
        } else if (appendSemicolon) {
            text += ";";
            appendSemicolon = false;
        }
        String textToCode = "";
        String[] lines = text.split("\n");
        for (String line : lines) {
            line = line.trim();
            if (line.startsWith("\"")) line = line.substring(1, line.length());
            if (line.endsWith("+")) line = line.substring(0, line.length() - 1).trim();
            if (line.endsWith("\"")) line = line.substring(0, line.length() - 1);
            textToCode += line;
        }

        String result = codeText(textToCode);

        if (appendQuote) {
            result = "\"" + result + "\"";
        }
        if (appendSemicolon) result = result + ";";

        return result;
    }

}
