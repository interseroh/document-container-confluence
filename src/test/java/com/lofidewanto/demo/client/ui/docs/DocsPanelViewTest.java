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

import org.gwtbootstrap3.extras.select.client.ui.Option;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import com.google.gwt.event.shared.EventBus;
import com.google.gwtmockito.GwtMockitoTestRunner;
import com.lofidewanto.demo.client.Messages;
import com.lofidewanto.demo.client.common.ErrorFormatter;
import com.lofidewanto.demo.client.common.LoadingMessagePopupPanel;
import com.lofidewanto.demo.client.domain.ConfluenceContentClient;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Unit test with GwtMockito.
 * <p>
 * Created by dewanto on 29.05.2017.
 */
@RunWith(GwtMockitoTestRunner.class)
public class DocsPanelViewTest {

	// CUT: Class Under Test
	private DocsPanelView view;

	@Mock
	private ErrorFormatter errorFormatter;

	@Mock
	private LoadingMessagePopupPanel loadingMessagePopupPanel;

	@Mock
	private EventBus eventBus;

	@Mock
	private ConfluenceContentClient confluenceContentClient;

	@Mock
	private Option mustardOption;

	@Mock
	private Messages messages;

	@Mock
	private DocsDataGrid docsDataGrid;

	@Before
	public void setUp() throws Exception {
		// CUT create
		view = new DocsPanelView(eventBus, errorFormatter,
				loadingMessagePopupPanel, messages, confluenceContentClient,
				docsDataGrid);

		// Create a spy on the view to mock view.runtimer()
		view = spy(view);
	}
	@Test
	public void test() {

	}

}