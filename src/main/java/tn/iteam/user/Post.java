package tn.iteam.user;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Post {
    @Id
    @GeneratedValue
            (strategy = GenerationType.SEQUENCE,generator = "post_generator")
    @SequenceGenerator
            (name="post_generator", sequenceName = "post_seq",
                    initialValue = 20005,
                    allocationSize=50)
    private Integer id;
    @Size(min = 10)
    private String description;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private User user;
}
