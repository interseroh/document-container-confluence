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
package com.lofidewanto.demo.client.ui.docs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MapMediaTypeTest {

    private MapMediaType mapMediaType = new MapMediaType();

    private String mediaType, fileFormat;

    @Test
    public void TestAdobeAcrobatMapping1() {
        mediaType = "application/pdf";
        fileFormat = mapMediaType.mapMediaType2FileFormat(mediaType);

        assertEquals("pdf", fileFormat);
    }

    @Test
    public void TestMSWordMapping1() {
        mediaType = "application/msword";
        fileFormat = mapMediaType.mapMediaType2FileFormat(mediaType);

        assertEquals("msword", fileFormat);
    }

    @Test
    public void TestMSWordMapping2() {
        mediaType = "application/vnd.openxmlformats-officedocument.wordprocessingml.document";
        fileFormat = mapMediaType.mapMediaType2FileFormat(mediaType);

        assertEquals("msword", fileFormat);
    }

    @Test
    public void TestMSWordMapping3() {
        mediaType = "application/vnd.openxmlformats-officedocument.wordprocessingml.template";
        fileFormat = mapMediaType.mapMediaType2FileFormat(mediaType);

        assertEquals("msword", fileFormat);
    }

    @Test
    public void TestMSWordMapping4() {
        mediaType = "application/vnd.ms-word.document.macroEnabled.12";
        fileFormat = mapMediaType.mapMediaType2FileFormat(mediaType);

        assertEquals("msword", fileFormat);
    }

    @Test
    public void TestMSWordMapping5() {
        mediaType = "application/vnd.ms-word.template.macroEnabled.12";
        fileFormat = mapMediaType.mapMediaType2FileFormat(mediaType);

        assertEquals("msword", fileFormat);
    }

    @Test
    public void TestMSExcelMapping1() {
        mediaType = "application/vnd.ms-excel";
        fileFormat = mapMediaType.mapMediaType2FileFormat(mediaType);

        assertEquals("msexcel", fileFormat);
    }

    @Test
    public void TestMSExcelMapping2() {
        mediaType = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
        fileFormat = mapMediaType.mapMediaType2FileFormat(mediaType);

        assertEquals("msexcel", fileFormat);
    }

    @Test
    public void TestMSExcelMapping3() {
        mediaType = "application/vnd.openxmlformats-officedocument.spreadsheetml.template";
        fileFormat = mapMediaType.mapMediaType2FileFormat(mediaType);

        assertEquals("msexcel", fileFormat);
    }

    @Test
    public void TestMSExcelMapping4() {
        mediaType = "application/vnd.ms-excel.sheet.macroEnabled.12";
        fileFormat = mapMediaType.mapMediaType2FileFormat(mediaType);

        assertEquals("msexcel", fileFormat);
    }

    @Test
    public void TestMSExcelMapping5() {
        mediaType = "application/vnd.ms-excel.template.macroEnabled.12";
        fileFormat = mapMediaType.mapMediaType2FileFormat(mediaType);

        assertEquals("msexcel", fileFormat);
    }

    @Test
    public void TestMSExcelMapping6() {
        mediaType = "application/vnd.ms-excel.addin.macroEnabled.12";
        fileFormat = mapMediaType.mapMediaType2FileFormat(mediaType);

        assertEquals("msexcel", fileFormat);
    }

    @Test
    public void TestMSExcelMapping7() {
        mediaType = "application/vnd.ms-excel.sheet.binary.macroEnabled.12";
        fileFormat = mapMediaType.mapMediaType2FileFormat(mediaType);

        assertEquals("msexcel", fileFormat);
    }

    @Test
    public void TestMSPowerpointMapping1() {
        mediaType = "application/vnd.ms-powerpoint";
        fileFormat = mapMediaType.mapMediaType2FileFormat(mediaType);

        assertEquals("mspowerpoint", fileFormat);
    }

    @Test
    public void TestMSPowerpointMapping2() {
        mediaType = "application/vnd.openxmlformats-officedocument.presentationml.presentation";
        fileFormat = mapMediaType.mapMediaType2FileFormat(mediaType);

        assertEquals("mspowerpoint", fileFormat);
    }

    @Test
    public void TestMSPowerpointMapping3() {
        mediaType = "application/vnd.openxmlformats-officedocument.presentationml.template";
        fileFormat = mapMediaType.mapMediaType2FileFormat(mediaType);

        assertEquals("mspowerpoint", fileFormat);
    }

    @Test
    public void TestMSPowerpointMapping4() {
        mediaType = "application/vnd.openxmlformats-officedocument.presentationml.slideshow";
        fileFormat = mapMediaType.mapMediaType2FileFormat(mediaType);

        assertEquals("mspowerpoint", fileFormat);
    }

    @Test
    public void TestMSPowerpointMapping5() {
        mediaType = "application/vnd.ms-powerpoint.addin.macroEnabled.12";
        fileFormat = mapMediaType.mapMediaType2FileFormat(mediaType);

        assertEquals("mspowerpoint", fileFormat);
    }

    @Test
    public void TestMSPowerpointMapping6() {
        mediaType = "application/vnd.ms-powerpoint.presentation.macroEnabled.12";
        fileFormat = mapMediaType.mapMediaType2FileFormat(mediaType);

        assertEquals("mspowerpoint", fileFormat);
    }

    @Test
    public void TestMSPowerpointMapping7() {
        mediaType = "application/vnd.ms-powerpoint.template.macroEnabled.12";
        fileFormat = mapMediaType.mapMediaType2FileFormat(mediaType);

        assertEquals("mspowerpoint", fileFormat);
    }

    @Test
    public void TestMSPowerpointMapping8() {
        mediaType = "application/vnd.ms-powerpoint.slideshow.macroEnabled.12";
        fileFormat = mapMediaType.mapMediaType2FileFormat(mediaType);

        assertEquals("mspowerpoint", fileFormat);
    }

    @Test
    public void TestMSAccessMapping1() {
        mediaType = "application/vnd.ms-access";
        fileFormat = mapMediaType.mapMediaType2FileFormat(mediaType);

        assertEquals("msaccess", fileFormat);
    }

    @Test
    public void TestDefaultMapping1() {
        mediaType = "test/test";
        fileFormat = mapMediaType.mapMediaType2FileFormat(mediaType);

        assertEquals("datei", fileFormat);
    }
}
