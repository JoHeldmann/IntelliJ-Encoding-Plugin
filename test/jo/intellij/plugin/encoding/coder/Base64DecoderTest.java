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

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Base64DecoderTest {
// ------------------------------ FIELDS ------------------------------

    private Base64Decoder coder;

// -------------------------- OTHER METHODS --------------------------

    @Before
    public void setUp() {
        coder = new Base64Decoder();
    }

    @Test
    public void testDecodeSimple() {
        assertEquals("12345", coder.code("MTIzNDU="));
        assertEquals("1234567890", coder.code("MTIzNDU2Nzg5MA=="));
    }
}
