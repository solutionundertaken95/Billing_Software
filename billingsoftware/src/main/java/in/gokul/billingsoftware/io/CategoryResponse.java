package in.gokul.billingsoftware.io;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

@Builder
@Data
public class CategoryResponse {

    private String categoryId;
    private String name;
    private String description;
    private String bgColor;
    @Column(updatable = false)
    private Timestamp createdAt;
    @UpdateTimestamp
    private Timestamp updatedAt;
    private String imgUrl;
}
