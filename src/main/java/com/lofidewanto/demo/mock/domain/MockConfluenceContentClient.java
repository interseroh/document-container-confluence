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
package com.lofidewanto.demo.mock.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.inject.Singleton;

import org.fusesource.restygwt.client.MethodCallback;

import com.lofidewanto.demo.client.domain.ConfluenceContentClient;
import com.lofidewanto.demo.shared.AttachmentDto;

@Singleton
public class MockConfluenceContentClient implements ConfluenceContentClient {

    private static Logger logger = Logger
            .getLogger(MockConfluenceContentClient.class.getName());

    @Override
    public void getAllAttachments(
            MethodCallback<List<AttachmentDto>> callback) {
        final List<AttachmentDto> attachments = createAttachments();

        callback.onSuccess(null, attachments);
    }

    private List<AttachmentDto> createAttachments() {
        // Create mock attachments
        AttachmentDto attach1 = new AttachmentDto();
        AttachmentDto attach2 = new AttachmentDto();
        AttachmentDto attach3 = new AttachmentDto();

        List<AttachmentDto> attachmentDtos = new ArrayList<>();
        attachmentDtos.add(attach1);
        attachmentDtos.add(attach2);
        attachmentDtos.add(attach3);

        return attachmentDtos;
    }

}
