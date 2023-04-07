package uz.pdp.dars1_vazifa2.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.dars1_vazifa2.entity.Attachment;

@Projection(types = Attachment.class )
public interface CustomAttachment {
    Integer getId();
    String getName();
    long getSize();
    String getContentType();
}
