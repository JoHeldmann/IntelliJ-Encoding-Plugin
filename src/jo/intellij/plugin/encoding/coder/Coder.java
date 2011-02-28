/*
 * Copyright 2011 Joachim Heldmann
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package jo.intellij.plugin.encoding.coder;

/**
 * Class definition for encoding or decoding a text.
 */
public abstract class Coder {
// -------------------------- OTHER METHODS --------------------------

    /**
     * Method to code a string. Leading spaces and qoutes are removed as
     * well as line breaks inside the string.
     *
     * @param text String to be coded
     * @return Coded string
     */
    public String code(String text) {
        boolean appendSemicolon = false;
        boolean appendQuote = false;
        String str = text.trim();
        if (str.endsWith(";")) {
            str = str.substring(0, str.length() - 1);
            appendSemicolon = true;
        }
        if (str.startsWith("\"") && str.endsWith("\"")) {
            str = str.substring(1, str.length());
            str = str.substring(0, str.length() - 1);
            appendQuote = true;
        } else if (appendSemicolon) {
            str += ";";
            appendSemicolon = false;
        }
        StringBuilder textToCode = new StringBuilder("");
        String[] lines = str.split("\n");
        for (String line : lines) {
            line = line.trim();
            if (line.startsWith("\"")) line = line.substring(1, line.length());
            if (line.endsWith("+")) line = line.substring(0, line.length() - 1).trim();
            if (line.endsWith("\"")) line = line.substring(0, line.length() - 1);
            textToCode.append(line);
        }

        String result = codeText(textToCode.toString());

        if (appendQuote) {
            result = "\"" + result + "\"";
        }
        if (appendSemicolon) result = result + ";";

        return result;
    }

    /**
     * Implementation method to code (encode or decode) a string.
     *
     * @param text String to be coded
     * @return Coded string
     */
    protected abstract String codeText(String text);
}
