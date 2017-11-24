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

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;
import org.gwtbootstrap3.client.ui.Button;
import org.gwtbootstrap3.client.ui.Label;
import org.gwtbootstrap3.client.ui.Pagination;
import org.gwtbootstrap3.client.ui.gwt.DataGrid;
import org.gwtbootstrap3.extras.bootbox.client.Bootbox;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.ListDataProvider;
import com.google.web.bindery.event.shared.binder.EventBinder;
import com.google.web.bindery.event.shared.binder.EventHandler;
import com.lofidewanto.demo.client.Messages;
import com.lofidewanto.demo.client.common.ErrorFormatter;
import com.lofidewanto.demo.client.common.LoadingMessagePopupPanel;
import com.lofidewanto.demo.client.common.Startable;
import com.lofidewanto.demo.client.domain.ConfluenceContentClient;
import com.lofidewanto.demo.client.ui.event.FilterEvent;
import com.lofidewanto.demo.shared.AttachmentDto;

@Singleton
public class DocsPanelView extends Composite implements Startable {

	private static Logger logger = Logger.getLogger(DocsPanelView.class.getName());

	interface PersonPanelViewUiBinder extends UiBinder<Widget, DocsPanelView> {
	}

	private static PersonPanelViewUiBinder uiBinder = GWT.create(PersonPanelViewUiBinder.class);

	interface PersonPanelEventBinder extends EventBinder<DocsPanelView> {
	}

	private final PersonPanelEventBinder eventBinder = GWT.create(PersonPanelEventBinder.class);

	private final EventBus eventBus;

	private final Messages messages;

	private final ConfluenceContentClient confluenceContentClient;

	private ListDataProvider<AttachmentDto> dataProviderList;

	private final DocsDataGrid docsDataGrid;

	@UiField
	DataGrid<AttachmentDto> dataGrid1;

	@UiField
	Pagination dataGridPagination1;

	@Inject
	public DocsPanelView(EventBus eventbus, ErrorFormatter errorFormatter,
			LoadingMessagePopupPanel loadingMessagePopupPanel, Messages messages,
			ConfluenceContentClient confluenceContentClient, DocsDataGrid docsDataGrid) {
		initWidget(uiBinder.createAndBindUi(this));
		this.eventBus = eventbus;
		this.messages = messages;
		eventBinder.bindEventHandlers(this, eventBus);

		this.confluenceContentClient = confluenceContentClient;
		this.docsDataGrid = docsDataGrid;

		initContent();
	}

	@Override
	public void start() {
	}

	@Override
	public void init() {
	}

	private void initContent() {
		logger.info("DocsPanelView created...");

		initListDataProvider(dataGrid1);
		docsDataGrid.initTableColumns(dataGrid1);

		getDocuments();
	}

	private void initListDataProvider(DataGrid<AttachmentDto> dataGrid) {
		dataProviderList = new ListDataProvider<>(new ArrayList<AttachmentDto>(0));
		dataProviderList.addDataDisplay(dataGrid);

		// Set the message to display when the table is empty.
		dataGrid.setEmptyTableWidget(new Label(messages.table_nodata()));
	}

	private void initFilterDataProvider(DataGrid<AttachmentDto> dataGrid) {
		// Set the message to display when the table is empty.
		dataGrid.setEmptyTableWidget(new Label(messages.table_nodata()));
	}

	private void getDocuments() {
		logger.info("Get docs begins...");

		confluenceContentClient.getAllAttachments(new MethodCallback<List<AttachmentDto>>() {
			@Override
			public void onFailure(Method method, Throwable throwable) {
				logger.log(Level.SEVERE, "Error: " + throwable);
			}

			@Override
			public void onSuccess(Method method,
					List<AttachmentDto> attachmentDtos) {
				logger.info("Get docs successfully ends: " + attachmentDtos.size());
				refreshGrid(attachmentDtos, dataProviderList);
			}
		});
	}

	private void refreshGrid(List<AttachmentDto> attachmentDtos, ListDataProvider<AttachmentDto> dataProvider) {
		for (AttachmentDto attachment : attachmentDtos) {
			logger.info("File: " + attachment.getDownloadLink() + " " + attachment.getTitle());
		}

		dataProvider.setList(attachmentDtos);
	}

	@EventHandler
	public void onEvent(FilterEvent event) {
		logger.info("Get Event:" + event);
		Bootbox.alert("FilterEvent is received in DocsPanelView...");
	}
}
