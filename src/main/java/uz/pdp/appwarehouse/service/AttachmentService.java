package uz.pdp.appwarehouse.service;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import uz.pdp.appwarehouse.entity.Attachment;
import uz.pdp.appwarehouse.entity.AttachmentContent;
import uz.pdp.appwarehouse.payload.Result;
import uz.pdp.appwarehouse.repository.AttachmentContentRepository;
import uz.pdp.appwarehouse.repository.AttachmentRepository;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class AttachmentService {

    @Autowired
    AttachmentRepository attachmentRepository;
    @Autowired
    AttachmentContentRepository attachmentContentRepository;
    @SneakyThrows
    public Result uploadFile(MultipartHttpServletRequest request) throws IOException {
        Iterator<String> fileNames = request.getFileNames();
        MultipartFile file = request.getFile(fileNames.next());

        Attachment attachment = new Attachment();
        attachment.setName(file.getOriginalFilename());
        attachment.setSize(file.getSize());
        attachment.setContentType(file.getContentType());
        Attachment savedAttachment = attachmentRepository.save(attachment);

        AttachmentContent attachmentContent = new AttachmentContent();
        attachmentContent.setBytes(file.getBytes());
        attachmentContent.setAttachment(savedAttachment);
        attachmentContentRepository.save(attachmentContent);
        return new Result("Saved file", true, savedAttachment.getId());

    }

    public List<Attachment> getAll(){
        List<Attachment> allAttachment = attachmentRepository.findAll();
        return allAttachment;
    }

    @SneakyThrows
    public Result update(@PathVariable Integer id, MultipartHttpServletRequest request){
        Iterator<String> fileNames = request.getFileNames();
        MultipartFile file = request.getFile(fileNames.next());

        Optional<Attachment> optionalAttachment = attachmentRepository.findById(id);
        if (!optionalAttachment.isPresent())
            return new Result("Attachment not found", false);
        Attachment attachment = optionalAttachment.get();
        attachment.setName(file.getOriginalFilename());
        attachment.setSize(file.getSize());
        attachment.setContentType(file.getContentType());
        Attachment savedAttachment = attachmentRepository.save(attachment);

        AttachmentContent attachmentContent = new AttachmentContent();
        attachmentContent.setBytes(file.getBytes());
        attachmentContent.setAttachment(savedAttachment);
        attachmentContentRepository.save(attachmentContent);
        return new Result("Update attachment", true);
    }

    public Result deleted( Integer id){
        Optional<Attachment> optionalAttachment = attachmentRepository.findById(id);
        if (optionalAttachment.isPresent()){
            attachmentRepository.deleteById(id);
            return new Result("Deleted attachment", true);
        }
        return new Result("Attachment not found", false);
    }

}
