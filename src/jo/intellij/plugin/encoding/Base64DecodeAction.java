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
package jo.intellij.plugin.encoding;

import jo.intellij.plugin.encoding.coder.Base64Decoder;

/**
 * Action for decoding with Base64.
 */
public class Base64DecodeAction extends AbstractEncodingPluginAction {
// ------------------------------ FIELDS ------------------------------

    private final Base64Decoder decoderBase64 = new Base64Decoder();

// --------------------------- CONSTRUCTORS ---------------------------

    /**
     * Create an action for Base64 decoding.
     */
    public Base64DecodeAction() {
        super("Decode Base64", "Decode selected text from Base64", null);
    }

// -------------------------- OTHER METHODS --------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    protected String codeText(String text) {
        return decoderBase64.code(text);
    }
}
