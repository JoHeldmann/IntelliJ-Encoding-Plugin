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

import jo.intellij.plugin.encoding.coder.Base64Encoder;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Base64EncoderTest {
// ------------------------------ FIELDS ------------------------------

    private Base64Encoder coder;

// -------------------------- OTHER METHODS --------------------------

    @Before
    public void setUp() {
        coder = new Base64Encoder();
    }

    @Test
    public void testEncodeConcatenated() {
        assertEquals("\"MTIzNDU2Nzg5MA==\"", coder.code("\"12345\" +\n  \"67890\""));
        assertEquals("\"MTIzNDU2Nzg5MA==\";", coder.code("\"12345\" +\n  \"67890\";"));
    }

    @Test
    public void testEncodeSimple() {
        assertEquals("MTIzNDU=", coder.code("12345"));
        assertEquals("MTIzNDU2Nzg5MA==", coder.code("1234567890"));
        assertEquals("MTIzNDU7", coder.code("12345;"));
        assertEquals("\"MTIzNDU=\"", coder.code("\"12345\""));
        assertEquals("\"MTIzNDU=\";", coder.code("\"12345\";"));
    }
}
