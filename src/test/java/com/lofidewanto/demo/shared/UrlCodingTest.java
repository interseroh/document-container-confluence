/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
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