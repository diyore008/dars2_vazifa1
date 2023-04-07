package uz.pdp.dars1_vazifa2.controller;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import uz.pdp.dars1_vazifa2.entity.Attachment;
import uz.pdp.dars1_vazifa2.payload.Result;
import uz.pdp.dars1_vazifa2.service.AttachmentContentService;

import java.util.List;

@RestController
@RequestMapping("/attachment")
public class AttachmentContentController {

    @Autowired
    AttachmentContentService attachmentContentService;

    @SneakyThrows
    @PostMapping("/upload")
    public Result upload(@RequestBody MultipartHttpServletRequest request){
        Result result = attachmentContentService.uploadFile(request);
        return  result;
    }

    @GetMapping("/getAll")
    public List<Attachment> getAll(){
        List<Attachment> allAttachment = attachmentContentService.getAll();
        return allAttachment;
    }

    @PutMapping("/update/{id}")
    public Result update(@PathVariable Integer id, MultipartHttpServletRequest request){
        Result result = attachmentContentService.update(id, request);
        return result;
    }

    @DeleteMapping("/delete/{id}")
    public Result deleted(@PathVariable Integer id){
        Result result = attachmentContentService.deleted(id);
        return result;
    }
}
