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
package com.lofidewanto.demo.client.ui.main;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import com.google.gwt.event.shared.EventBus;
import com.google.gwtmockito.GwtMockitoTestRunner;
import com.lofidewanto.demo.client.common.ErrorFormatter;
import com.lofidewanto.demo.client.common.LoadingMessagePopupPanel;
import com.lofidewanto.demo.client.common.WidgetName;
import com.lofidewanto.demo.client.ui.docs.DocsPanelView;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(GwtMockitoTestRunner.class)
public class MainPanelViewTest {

	private MainPanelView view;

	@Mock
	private ErrorFormatter errorFormatter;

	@Mock
	private LoadingMessagePopupPanel loadingMessagePopupPanel;

	@Mock
	private EventBus eventBus;

	@Mock
	private DocsPanelView docsPanelView;

	@Before
	public void setUp() throws Exception {
		view = new MainPanelView(eventBus, errorFormatter,
				loadingMessagePopupPanel);
	}

	@Test
	public void testAddWidget() {
		// Prepare
		doNothing().when(view.contentColumn).add(docsPanelView);

		// CUT
		view.addWidget(WidgetName.PERSONLIST, docsPanelView);

		// Asserts
		assertEquals(view.widgets.size(), 1);
		verify(docsPanelView, times(1)).setVisible(false);
		verify(view.contentColumn, times(1)).add(docsPanelView);
	}

	@Test
	public void testShowWidget() {
		// Prepare
		view.addWidget(WidgetName.PERSONLIST, docsPanelView);
		doReturn(1).when(view.contentColumn).getWidgetCount();

		// CUT
		view.showWidget(WidgetName.PERSONLIST);

		// Asserts
		assertEquals(view.widgets.size(), 1);
		verify(view.contentColumn, times(1)).getWidget(anyInt());
		verify(docsPanelView, times(1)).setVisible(false);
		verify(docsPanelView, times(1)).setVisible(true);
	}

	@Test
	public void testUpdatePersonPanelView() {
		// Prepare
		view.addWidget(WidgetName.PERSONLIST, docsPanelView);
		doReturn(1).when(view.contentColumn).getWidgetCount();

		// CUT
		view.updatePersonPanelView();

		// Asserts
		assertEquals(view.widgets.size(), 1);
	}

}
