package com.lofidewanto.demo.server.service.content;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MapAllAttachmentsTest {

	private MapAllAttachments mapAllAttachments = new MapAllAttachments();

	@Test
	public void getVersion1() throws Exception {
		String result = mapAllAttachments.getVersion(
				"/demogwt/v1/attachments/download?"
						+ "link=/download/attachments/20351049/"
						+ "Softwareentwicklung-Tech-"
						+ "Interseroh.pdf?version=2&modificationDate=1511294475501&api=v2"
						+ "&mediatype=application/pdf");

		assertEquals("2", result);
	}

	@Test
	public void getVersion2() throws Exception {
		String result = mapAllAttachments.getVersion(
				"/demogwt/v1/attachments/download?"
						+ "link=/download/attachments/20351049/"
						+ "Test%20Dokument%20Entsorger%20Por"
						+ "tal.pdf?version=1&modificationDate=1510763470000&api=v2"
						+ "&mediatype=application/pdf");

		assertEquals("1", result);
	}



	@Test
	public void getVersion3() throws Exception {
		String result = mapAllAttachments.getVersion(
				"/download/attachments/20351049/2016-Scrum-Guide-German.pdf?"
						+ "?version=3&modificationDate=1511293595000&api"
						+ "=v2 2016-Scrum-Guide-German.pdf");

		assertEquals("3", result);
	}
}