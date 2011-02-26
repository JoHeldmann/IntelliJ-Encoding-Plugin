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
