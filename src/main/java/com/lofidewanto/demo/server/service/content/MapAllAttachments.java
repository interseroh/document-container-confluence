package com.lofidewanto.demo.server.service.content;

import com.lofidewanto.demo.server.domain.Attachment;
import com.lofidewanto.demo.server.domain.AttachmentImpl;
import com.lofidewanto.demo.server.domain.AllAttachments;
import com.lofidewanto.demo.server.domain.Result;

import java.util.ArrayList;
import java.util.List;

public class MapAllAttachments {

    public List<Attachment> mapAllAttachments2List(AllAttachments allAttachments) {
        List<Attachment> attachmentList = new ArrayList<>();
        List<Result> resultList = allAttachments.getResults();
        for(Result result : resultList) {
            Attachment attachment = new AttachmentImpl();
            attachment.setId(result.getId());
            attachment.setTitle(result.getTitle());
            if(result.getLinks() != null)
                attachment.setDownloadLink(result.getLinks().getDownload());
            if(result.getExtensions() != null) {
                attachment.setMediaType(result.getExtensions().getMediaType());
                attachment.setFileSize(((Integer)result.getExtensions().getFileSize()).toString());
            }
            //attachment.setFileContent(buildInputStreamFromResult(result));
            attachmentList.add(attachment);
        }

        return attachmentList;
    }

    /*private InputStream buildInputStreamFromResult(Result result) {
        InputStream inputStream = new
    }*/

    public Attachment[] mapAllAttachments2Array(AllAttachments allAttachments) {
        List<Attachment> attachmentList = mapAllAttachments2List(allAttachments);
        Attachment[] attachmentArray = attachmentList.toArray(new Attachment[attachmentList.size()]);
        return attachmentArray;
    }
}
