package io.downgoon.tools;

import junit.framework.TestCase;

/**
 * Unit test for EncodingDetect - specifically testing the utf16_probability
 * ArrayIndexOutOfBoundsException bug reported in Issue #7.
 */
public class EncodingDetectTest extends TestCase {

    private EncodingDetect detector;

    public EncodingDetectTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        detector = new EncodingDetect();
    }

    /**
     * Test utf16_probability with empty byte array (length = 0).
     * Before the fix, this would throw ArrayIndexOutOfBoundsException.
     */
    public void testUtf16ProbabilityWithEmptyArray() {
        byte[] empty = new byte[0];
        int result = detector.utf16_probability(empty);
        assertEquals("Empty array should return 0", 0, result);
    }

    /**
     * Test utf16_probability with single byte array (length = 1).
     * Before the fix, this would throw ArrayIndexOutOfBoundsException
     * because rawtext[1] is accessed without checking length.
     */
    public void testUtf16ProbabilityWithSingleByte() {
        byte[] single = new byte[] { (byte) 0xFE };
        int result = detector.utf16_probability(single);
        assertEquals("Single byte array should return 0", 0, result);
    }

    /**
     * Test utf16_probability with Big-endian BOM (0xFE 0xFF).
     * Should correctly return 100.
     */
    public void testUtf16ProbabilityWithBigEndianBOM() {
        byte[] bomBigEndian = new byte[] { (byte) 0xFE, (byte) 0xFF };
        int result = detector.utf16_probability(bomBigEndian);
        assertEquals("Big-endian BOM should return 100", 100, result);
    }

    /**
     * Test utf16_probability with Little-endian BOM (0xFF 0xFE).
     * Should correctly return 100.
     */
    public void testUtf16ProbabilityWithLittleEndianBOM() {
        byte[] bomLittleEndian = new byte[] { (byte) 0xFF, (byte) 0xFE };
        int result = detector.utf16_probability(bomLittleEndian);
        assertEquals("Little-endian BOM should return 100", 100, result);
    }

    /**
     * Test utf16_probability with non-BOM bytes.
     * Should return 0.
     */
    public void testUtf16ProbabilityWithNonBOMBytes() {
        byte[] nonBOM = new byte[] { (byte) 0x41, (byte) 0x42 };
        int result = detector.utf16_probability(nonBOM);
        assertEquals("Non-BOM bytes should return 0", 0, result);
    }
}