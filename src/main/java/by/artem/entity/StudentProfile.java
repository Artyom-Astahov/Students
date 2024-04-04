package by.artem.entity;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = "student")
@Entity
@Table(name = "student_profile")
public class StudentProfile {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer score;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id")
    private Student student;


    public void setStudent(Student student){
        this.student = student;
        student.setStudentProfile(this);
    }
}
