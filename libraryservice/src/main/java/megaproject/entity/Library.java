package megaproject.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="library")
public class Library {

    @Id
    @Column(name="lib_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long libId;

    @Column(name="book_id")
    private Long bookId;

    @Column(name="user_id")
    private Long userId;

}
