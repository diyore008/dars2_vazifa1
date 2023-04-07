package uz.pdp.dars1_vazifa2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.pdp.dars1_vazifa2.entity.AttachmentContent;
import uz.pdp.dars1_vazifa2.projection.CustomAttachment;
import uz.pdp.dars1_vazifa2.projection.CustomAttachmentContent;

@RepositoryRestResource(collectionResourceRel = "list", path = "attachmentContent",excerptProjection = CustomAttachmentContent.class)
public interface AttachmentContentRepository extends JpaRepository<AttachmentContent, Integer> {
}
