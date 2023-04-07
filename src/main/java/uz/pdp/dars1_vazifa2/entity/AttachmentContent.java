package uz.pdp.dars1_vazifa2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.dars1_vazifa2.entity.Attachment;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "attachmentContent")
public class AttachmentContent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private byte[] bytes;
    @OneToOne
    private Attachment attachment;

}
