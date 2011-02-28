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

import sun.misc.BASE64Encoder;

/**
 * Class to encode a string with Base64 encoding.
 */
public class Base64Encoder extends Coder {
// -------------------------- OTHER METHODS --------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    protected String codeText(String text) {
        BASE64Encoder encoder = new BASE64Encoder();
        String result = encoder.encode(text.getBytes());

        return result;
    }
}