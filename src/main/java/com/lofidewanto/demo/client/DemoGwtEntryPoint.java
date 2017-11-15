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
package com.lofidewanto.demo.client;

import java.util.logging.Logger;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootPanel;
import com.lofidewanto.demo.client.common.ServicePreparator;
import com.lofidewanto.demo.shared.DemoGwtServiceEndpoint;

public class DemoGwtEntryPoint implements EntryPoint {

    private static Logger logger = Logger
            .getLogger(DemoGwtEntryPoint.class.getName());

    private static final String INTEGRATION_AREA_ID = "entsorgerportal_integration_area";

    private static final String ATTRIBUTE_BASE_URL_INTEGRATION = "data-baseurl_integration";

    // Create Gin Injector
    private final DemoGwtWebAppGinjector injector = GWT
            .create(DemoGwtWebAppGinjector.class);

    @Override
    public void onModuleLoad() {
        logger.info("DemoGwtEntryPoint onModuleLoad...");

        // We need to prepare the services with RestyGwt before...
        RootPanel integrationArea = getWidgets(INTEGRATION_AREA_ID);
        String baseUrl = DemoGwtServiceEndpoint.SERVER_CONTEXT_PATH;
        if (integrationArea != null) {
            baseUrl = integrationArea.getElement()
                    .getAttribute(ATTRIBUTE_BASE_URL_INTEGRATION);
        }

        logger.info("Base URL: " + baseUrl);

        ServicePreparator servicePreparator = injector.getServicePreparator();
        servicePreparator.prepare(baseUrl);

        // Create webapp
        DemoGwtWebApp demoGwtWebApp = injector.getDemoGwtWebApp();
    }

    private RootPanel getWidgets(String element) {
        return RootPanel.get(element);
    }

}
