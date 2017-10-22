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
package com.lofidewanto.demo.server.service.content;

import java.net.URI;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;

import com.lofidewanto.demo.shared.DemoGwtServiceEndpoint;

import static org.springframework.test.util.AssertionErrors.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class ConfluenceContentServiceImplTest {

	@InjectMocks
	private ConfluenceContentServiceImpl confluenceContentService = new ConfluenceContentServiceImpl();

	@Mock
	private RestTemplate restTemplate;

	private String confluenceUrl = "http://confluence:8080";

	private String confluencePageId = "1345151";

	@Before
	public void setUp() throws Exception {
		ReflectionTestUtils.setField(confluenceContentService, "confluenceUrl", confluenceUrl);
		ReflectionTestUtils.setField(confluenceContentService, "confluencePageId", confluencePageId);
	}

	@Test
	public void testGetAllAttachments() {
		// Prepare
		confluenceContentService.getAllAttachments();
	}

	@Test
	public void testReplacePageId() {
		String confluenceAttachmentList = DemoGwtServiceEndpoint.CONFLUENCE_ATTACHMENT_LIST;
		String url = confluenceUrl.concat(confluenceAttachmentList);

		URI uri = confluenceContentService.replacePageId(url);

		assertEquals("URI", confluenceUrl + "/rest/api/content/" + confluencePageId + "/child/attachment", "");
	}


}
