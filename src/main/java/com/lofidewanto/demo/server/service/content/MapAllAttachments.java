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

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.lofidewanto.demo.server.domain.AllAttachments;
import com.lofidewanto.demo.server.domain.Attachment;
import com.lofidewanto.demo.server.domain.AttachmentImpl;
import com.lofidewanto.demo.server.domain.Result;

@Component
public class MapAllAttachments {

	private static final Logger logger = LoggerFactory
			.getLogger(MapAllAttachments.class);

	private static final String PARAMS_BEGIN = "version=";

	private static final String PARAMS_SEPERATOR = "&";

	public List<Attachment> mapAllAttachments2List(
			AllAttachments allAttachments) {
		List<Attachment> attachmentList = new ArrayList<>();
		List<Result> resultList = allAttachments.getResults();

		for (Result result : resultList) {
			Attachment attachment = new AttachmentImpl();
			attachment.setId(result.getId());
			attachment.setTitle(result.getTitle());

			if (result.getLinks() != null) {
				attachment.setDownloadLink(result.getLinks().getDownload());
				logger.info("Download Link: " + result.getLinks().getDownload());

				String version = getVersion(result.getLinks().getDownload());
				logger.info("Version: " + version);
				attachment.setVersion(version);
			}

			if (result.getExtensions() != null) {
				attachment.setMediaType(result.getExtensions().getMediaType());
				attachment.setFileSize(
						((Integer) result.getExtensions().getFileSize())
								.toString());
				logger.info("Comment: " + result.getExtensions().getComment());
				attachment.setComment(result.getExtensions().getComment());
			}

			attachmentList.add(attachment);
		}

		return attachmentList;
	}

	public Attachment[] mapAllAttachments2Array(AllAttachments allAttachments) {
		List<Attachment> attachmentList = mapAllAttachments2List(
				allAttachments);
		Attachment[] attachmentArray = attachmentList
				.toArray(new Attachment[attachmentList.size()]);
		return attachmentArray;
	}

	String getVersion(String downloadLink) {
		final String version = StringUtils
				.substringBetween(downloadLink, PARAMS_BEGIN, PARAMS_SEPERATOR);

		return version;
	}
}
