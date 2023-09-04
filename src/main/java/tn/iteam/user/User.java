package tn.iteam.user;

import jakarta.persistence.*;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity(name = "user_details")
public class User {
    @Id
    @GeneratedValue
            (strategy = GenerationType.SEQUENCE,generator = "user_generator")
    @SequenceGenerator
            (name="user_generator", sequenceName = "user_seq",
                    initialValue = 10001,
                    allocationSize=50)
    private Integer id;
    @Size(min = 2, message = "Name should has at least 2 characters")
    private String name;
    @Past(message = "Birth Date should be in the past")
    private LocalDate birthDate;
    @OneToMany(mappedBy = "user")
    private List<Post> posts;

}
