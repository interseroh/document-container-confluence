package com.lofidewanto.demo.shared;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UrlCodingTest {

    private static final String URL_STRING = "http://www.test.com?test1=1&test2=2";
    private static final String ENCODED_URL_STRING = "http://www.test.com__-__test1=1--_--test2=2";

    @Test
    public void testEncoding() {
        UrlCoding urlCoding = new UrlCoding(URL_STRING);
        String result = urlCoding.encode();

        assertEquals(result, ENCODED_URL_STRING);
    }

    @Test
    public void testDecoding() {
        UrlCoding urlCoding = new UrlCoding();
        String result = urlCoding.decode(ENCODED_URL_STRING);

        assertEquals(result, URL_STRING);
    }

}