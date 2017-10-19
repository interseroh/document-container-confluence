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

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.lofidewanto.demo.server.domain.Attachment;

@Service
public class ConfluenceContentServiceImpl implements ConfluenceContentService {

	private static final Logger logger = LoggerFactory
			.getLogger(ConfluenceContentServiceImpl.class);

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public List<Attachment> getAllAttachments() {
		// Connect to Confluence

		return null;
	}

	@Override
	public List<Attachment> getAllAttachmentsByPageId(String pageId) {
		return null;
	}

	@Override
	public Attachment getAttachmentById() {
		return null;
	}

}
