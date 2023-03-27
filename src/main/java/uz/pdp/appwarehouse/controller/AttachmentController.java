package uz.pdp.appwarehouse.controller;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import uz.pdp.appwarehouse.entity.Attachment;
import uz.pdp.appwarehouse.payload.Result;
import uz.pdp.appwarehouse.service.AttachmentService;

import java.util.List;

@RestController
@RequestMapping("/attachment")
public class AttachmentController {

    @Autowired
    AttachmentService attachmentService;

    @SneakyThrows
    @PostMapping("/upload")
    public Result upload(@RequestBody MultipartHttpServletRequest request){
        Result result = attachmentService.uploadFile(request);
        return  result;
    }

    @GetMapping("/getAll")
    public List<Attachment> getAll(){
        List<Attachment> allAttachment = attachmentService.getAll();
        return allAttachment;
    }

    @PutMapping("/update/{id}")
    public Result update(@PathVariable Integer id, MultipartHttpServletRequest request){
        Result result = attachmentService.update(id, request);
        return result;
    }

    @DeleteMapping("/delete/{id}")
    public Result deleted(@PathVariable Integer id){
        Result result = attachmentService.deleted(id);
        return result;
    }
}
