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
package com.lofidewanto.demo.shared;

public interface DemoGwtServiceEndpoint {

	String GWT_MODULE_NAME = "/demogwt";

	String GWT_REMOTE_LOGGING = GWT_MODULE_NAME + "/remote_logging";

	String SERVER_CONTEXT_PATH = "/demogwt";

	String ATTACHMENT_LIST = "/v1/attachments";

	String ATTACHMENT_DOWNLOAD = "/v1/attachments/download";

	String CONFLUENCE_ATTACHMENT_LIST = "/rest/api/content/{pageId}/child/attachment";

	String INTEGRATION_AREA_ID = "entsorgerportal_integration_area";

	String ATTRIBUTE_BASE_URL_INTEGRATION = "data-baseurl_integration";

	String APP_VIEW_AREA_ID = "applicationViewArea";

}
