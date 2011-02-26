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
