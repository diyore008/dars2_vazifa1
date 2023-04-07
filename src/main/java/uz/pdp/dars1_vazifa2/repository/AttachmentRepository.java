package uz.pdp.dars1_vazifa2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import uz.pdp.dars1_vazifa2.entity.Attachment;
import uz.pdp.dars1_vazifa2.projection.CustomAttachment;

@RepositoryRestResource(collectionResourceRel = "list", path = "attachments",excerptProjection = CustomAttachment.class)
public interface AttachmentRepository extends JpaRepository<Attachment, Integer> {
}
