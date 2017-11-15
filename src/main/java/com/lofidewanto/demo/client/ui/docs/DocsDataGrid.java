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

import java.util.logging.Logger;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.gwtbootstrap3.client.ui.constants.ButtonSize;
import org.gwtbootstrap3.client.ui.constants.ButtonType;
import org.gwtbootstrap3.client.ui.gwt.ButtonCell;
import org.gwtbootstrap3.client.ui.gwt.DataGrid;

import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.cell.client.TextCell;
import com.google.gwt.dom.client.Style;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.client.Window;
import com.lofidewanto.demo.client.Messages;
import com.lofidewanto.demo.client.common.ServicePreparator;
import com.lofidewanto.demo.shared.AttachmentDto;
import com.lofidewanto.demo.shared.UrlCoding;

import static com.lofidewanto.demo.shared.DemoGwtServiceEndpoint.ATTACHMENT_DOWNLOAD;

@Singleton
public class DocsDataGrid {

	private static Logger logger = Logger.getLogger(DocsDataGrid.class.getName());

	private final Messages messages;

	private final ServicePreparator servicePreparator;

	@Inject
	public DocsDataGrid(Messages messages, ServicePreparator servicePreparator) {
		this.messages = messages;
		this.servicePreparator = servicePreparator;
	}

	void initTableColumns(DataGrid<AttachmentDto> dataGrid) {
		dataGrid.setWidth("100%");
		dataGrid.setAutoHeaderRefreshDisabled(true);

		// Title
		Column<AttachmentDto, String> titleColumn = new Column<AttachmentDto, String>(
				new TextCell()) {
			@Override
			public String getValue(AttachmentDto object) {
				return object.getTitle();
			}
		};
		dataGrid.addColumn(titleColumn, messages.table_title());
		dataGrid.setColumnWidth(titleColumn, 40, Style.Unit.PCT);

		// Media type
		Column<AttachmentDto, String> contentTypeColumn = new Column<AttachmentDto, String>(
				new TextCell()) {
			@Override
			public String getValue(AttachmentDto object) {
				return object.getMediaType();
			}
		};
		dataGrid.addColumn(contentTypeColumn, messages.table_contentType());
		dataGrid.setColumnWidth(contentTypeColumn, 40, Style.Unit.PCT);

		// Size
		Column<AttachmentDto, String> fileSizeColumn = new Column<AttachmentDto, String>(
				new TextCell()) {
			@Override
			public String getValue(AttachmentDto object) {
				return object.getFileSize();
			}
		};
		dataGrid.addColumn(fileSizeColumn, messages.table_fileSize());
		dataGrid.setColumnWidth(fileSizeColumn, 40, Style.Unit.PCT);

		// Download link Button
		Column<AttachmentDto, String> downloadColumn = new Column<AttachmentDto, String>(
				new ButtonCell(ButtonType.INFO, ButtonSize.SMALL)) {
			@Override
			public String getValue(AttachmentDto object) {
				return messages.table_downloadButton();
			}
		};
		dataGrid.addColumn(downloadColumn, messages.table_download());
		dataGrid.setColumnWidth(downloadColumn, 40, Style.Unit.PCT);

		downloadColumn.setFieldUpdater(new FieldUpdater<AttachmentDto, String>() {
			@Override
			public void update(int index, AttachmentDto attachmentDto, String value) {
				// Download clicked
				UrlCoding urlCoding = new UrlCoding(attachmentDto.getDownloadLink());

				String baseUrl = servicePreparator.getBaseUrl();

				String url = baseUrl + 	ATTACHMENT_DOWNLOAD + "?link=" +
							urlCoding.encode() + "&mediatype=" +
							attachmentDto.getMediaType();

				logger.info("Base URL: " + baseUrl);
				logger.info("URL: " + url);

				Window.open( url, "_blank", "status=0,toolbar=0,menubar=0,location=0");
			}
		});
	}
}