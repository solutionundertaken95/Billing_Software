package in.gokul.billingsoftware.io;


import lombok.*;

@Builder
@Data
@RequiredArgsConstructor
@AllArgsConstructor
//@NoArgsConstructor
public class CategoryRequest {


    private String name;
    private String description;
    private String bgColor;

}
