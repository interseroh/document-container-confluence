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

import javax.inject.Singleton;

@Singleton
public class MapMediaType {
    public String mapMediaType2FileFormat(String mediaType) {

        String result = "";

        switch(mediaType) {
            case "application/pdf":
                result = "pdf";
                break;

            case "application/msword":
            case "application/vnd.openxmlformats-officedocument.wordprocessingml.document":
            case "application/vnd.openxmlformats-officedocument.wordprocessingml.template":
            case "application/vnd.ms-word.document.macroEnabled.12":
            case "application/vnd.ms-word.template.macroEnabled.12":
                result = "msword";
                break;

            case "application/vnd.ms-excel":
            case "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet":
            case "application/vnd.openxmlformats-officedocument.spreadsheetml.template":
            case "application/vnd.ms-excel.sheet.macroEnabled.12":
            case "application/vnd.ms-excel.template.macroEnabled.12":
            case "application/vnd.ms-excel.addin.macroEnabled.12":
            case "application/vnd.ms-excel.sheet.binary.macroEnabled.12":
                result = "msexcel";
                break;

            case "application/vnd.ms-powerpoint":
            case "application/vnd.openxmlformats-officedocument.presentationml.presentation":
            case "application/vnd.openxmlformats-officedocument.presentationml.template":
            case "application/vnd.openxmlformats-officedocument.presentationml.slideshow":
            case "application/vnd.ms-powerpoint.addin.macroEnabled.12":
            case "application/vnd.ms-powerpoint.presentation.macroEnabled.12":
            case "application/vnd.ms-powerpoint.template.macroEnabled.12":
            case "application/vnd.ms-powerpoint.slideshow.macroEnabled.12":
                result = "mspowerpoint";
                break;

            case "application/vnd.ms-access":
                result = "msaccess";
                break;

            default:
                result = "datei";
        }

        return result;
    }
}
