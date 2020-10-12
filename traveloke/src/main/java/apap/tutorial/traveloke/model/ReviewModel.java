package apap.tutorial.traveloke.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import javax.persistence.*;
import javax.validation.constraints.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name="review")
public class ReviewModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReview;

    @NotNull
    @Size(max=10)
    @Column(name="nama_reviewer", nullable=false)
    private String nama_reviewer;

    @NotNull
    @Size(max=50)
    @Column(name="isi_review", nullable=false)
    private String isi_review;

    @ManyToOne(fetch = FetchType.EAGER,optional=false)
    @JoinColumn(name="noKamar", referencedColumnName="noKamar",nullable=false)
    @OnDelete(action=OnDeleteAction.CASCADE)
    @JsonIgnore
    private KamarModel kamar;


    public Long getIdReview() {
        return idReview;
    }

    public void setIdReview(Long idReview) {
        this.idReview = idReview;
    }

    public String getNama_reviewer() {
        return nama_reviewer;
    }

    public void setNama_reviewer(String nama_reviewer) {
        this.nama_reviewer = nama_reviewer;
    }

    public String getIsi_review() {
        return isi_review;
    }

    public void setIsi_review(String isi_review) {
        this.isi_review = isi_review;
    }

    public String getSaran() {
        return saran;
    }

    public void setSaran(String saran) {
        this.saran = saran;
    }

    @NotNull
    @Size(max=50)
    @Column(name="saran", nullable=false)
    private String saran;

}
