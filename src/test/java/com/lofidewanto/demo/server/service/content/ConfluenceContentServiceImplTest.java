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

import java.net.MalformedURLException;
import java.net.URI;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;

import com.lofidewanto.demo.server.domain.Attachment;
import com.lofidewanto.demo.server.domain.AttachmentImpl;
import com.lofidewanto.demo.shared.DemoGwtServiceEndpoint;

import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.util.AssertionErrors.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class ConfluenceContentServiceImplTest {

	@InjectMocks
	private ConfluenceContentServiceImpl confluenceContentService;

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
	public void testReplacePageId() throws MalformedURLException {
		// Prepare
		String confluenceAttachmentList = DemoGwtServiceEndpoint.CONFLUENCE_ATTACHMENT_LIST;
		String url = confluenceUrl.concat(confluenceAttachmentList);

		// CUT
		URI uri = confluenceContentService.replacePageId(url);

		// Verify
		final String expected = confluenceUrl + "/rest/api/content/" + confluencePageId
						+ "/child/attachment";
		assertEquals("URI", expected, uri.toURL().toString());
	}

	@Test
	public void testGetAllAttachments() {
		// Prepare
		Attachment[] attachments = new Attachment[3];
		Attachment attach1 = new AttachmentImpl();
		Attachment attach2 = new AttachmentImpl();
		Attachment attach3 = new AttachmentImpl();
		attachments[0] = attach1;
		attachments[1] = attach2;
		attachments[2] = attach3;

		ResponseEntity attachmentsWithResponseEntity =
				new ResponseEntity<Attachment[]>(HttpStatus.ACCEPTED);

		when(restTemplate.exchange(anyString(), eq(HttpMethod.GET), Matchers.<HttpEntity<?>>any(),
				Matchers.<Class<Attachment[]>>any(), Matchers.<Object>anyVararg())).
				thenReturn(attachmentsWithResponseEntity);

		// CUT
		List<Attachment> allAttachments = confluenceContentService.getAllAttachments();

		// Verify

	}

}
