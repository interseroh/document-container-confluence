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
import org.gwtbootstrap3.client.ui.constants.ButtonSize;
import org.gwtbootstrap3.client.ui.constants.ButtonType;
import org.gwtbootstrap3.client.ui.gwt.ButtonCell;
import org.gwtbootstrap3.client.ui.gwt.DataGrid;
import org.gwtbootstrap3.extras.bootbox.client.Bootbox;

import com.google.gwt.cell.client.TextCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.cellview.client.Column;
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

	@UiField
	Button refreshButton;

	@UiField
	DataGrid<AttachmentDto> dataGrid1;

	@UiField
	Pagination dataGridPagination1;

	@Inject
	public DocsPanelView(EventBus eventbus, ErrorFormatter errorFormatter,
			LoadingMessagePopupPanel loadingMessagePopupPanel, Messages messages,
			ConfluenceContentClient confluenceContentClient) {
		initWidget(uiBinder.createAndBindUi(this));
		this.eventBus = eventbus;
		this.messages = messages;
		eventBinder.bindEventHandlers(this, eventBus);

		this.confluenceContentClient = confluenceContentClient;
	}

	@Override
	public void start() {

	}

	@Override
	public void init() {
		logger.info("DocsPanelView created...");

		initTableColumns(dataGrid1);
		initListDataProvider(dataGrid1);

		getDocuments();
	}

	@UiHandler("refreshButton")
	public void onButtonClick(final ClickEvent event) {
		// Event handling in GWT UiBinder
		logger.info("Click Detected by GWT UiBinder");

		// Both buttons disable
		refreshButton.setEnabled(false);

		boolean result = runTimerRefreshButton();

		if (result == false) {

		}

		logger.info("Result runTimerRefreshButton: " + result);
	}

	boolean runTimerRefreshButton() {
		// This is a GWT timer implementation so you won't see this running in Java!
		new Timer() {
			@Override
			public void run() {
				runTimerRefreshButtonExecutor();
			}
		}.schedule(5000);

		return true;
	}

	void runTimerRefreshButtonExecutor() {
		refreshButton.setEnabled(true);
		logger.info("Enable the button again...");
	}

	private void initTableColumns(DataGrid<AttachmentDto> dataGrid) {
		dataGrid.setWidth("100%");
		dataGrid.setAutoHeaderRefreshDisabled(true);

		// Title
		Column<AttachmentDto, String> titleColumn = new Column<AttachmentDto, String>(new TextCell()) {
			@Override
			public String getValue(AttachmentDto object) {
				return object.getTitle();
			}
		};
		dataGrid.addColumn(titleColumn, messages.table_title());
		dataGrid.setColumnWidth(titleColumn, 40, Style.Unit.PCT);

		// Media type
		Column<AttachmentDto, String> contentTypeColumn = new Column<AttachmentDto, String>(new TextCell()) {
			@Override
			public String getValue(AttachmentDto object) {
				return object.getMediaType();
			}
		};
		dataGrid.addColumn(contentTypeColumn, messages.table_contentType());
		dataGrid.setColumnWidth(contentTypeColumn, 40, Style.Unit.PCT);

		// Download link Button
		Column<AttachmentDto, String> downloadColumn = new Column<AttachmentDto, String>(new ButtonCell(
				ButtonType.INFO, ButtonSize.SMALL)) {
			@Override
			public String getValue(AttachmentDto object) {
				return messages.table_downloadButton();
			}
		};
		dataGrid.addColumn(downloadColumn, messages.table_download());
		dataGrid.setColumnWidth(downloadColumn, 40, Style.Unit.PCT);
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

	private void filterPerson() {
		MethodCallback<List<AttachmentDto>> filterCallBack = new MethodCallback<List<AttachmentDto>>() {
			@Override
			public void onFailure(Method method, Throwable throwable) {
				Bootbox.alert("Method call back has ERROR: " + throwable.getLocalizedMessage());
				throwable.printStackTrace();
			}

			@Override
			public void onSuccess(Method method, List<AttachmentDto> persons) {
				Bootbox.alert("Method call back is OK, first Person: " + persons.get(0).getTitle());
				refreshGrid(persons, dataProviderList);
			}
		};

		logger.info("Calling filterPerson Service...");
	}

	private void getDocuments() {
		logger.info("Get persons begins...");

		confluenceContentClient.getAllAttachments(new MethodCallback<List<AttachmentDto>>() {
			@Override
			public void onFailure(Method method, Throwable throwable) {
				logger.log(Level.SEVERE, "Error: " + throwable.getMessage());
			}

			@Override
			public void onSuccess(Method method,
					List<AttachmentDto> attachmentDtos) {
				logger.info("Get persons successfully ends: " + attachmentDtos.size());
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
