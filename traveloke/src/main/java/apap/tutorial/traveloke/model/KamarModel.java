package apap.tutorial.traveloke.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import javax.persistence.*;
import javax.validation.constraints.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="kamar")
public class KamarModel implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long noKamar;

    @NotNull
    @Size(max=30)
    @Column(name="namaKamar", nullable=false)
    private String namaKamar;

    @NotNull
    @Column(name="tipe",nullable=false)
    private Integer tipe;

    @NotNull
    @Column(name="kapasitasKamar",nullable=false)
    private Integer kapasitasKamar;

    @OneToMany(mappedBy = "review",fetch=FetchType.LAZY,cascade = CascadeType.ALL)
    private List<ReviewModel> reviewModel;

    public Long getNoKamar() {
        return noKamar;
    }

    public void setNoKamar(Long noKamar) {
        this.noKamar = noKamar;
    }

    public String getNamaKamar() {
        return namaKamar;
    }

    public void setNamaKamar(String namaKamar) {
        this.namaKamar = namaKamar;
    }

    public Integer getTipe() {
        return tipe;
    }

    public void setTipe(Integer tipe) {
        this.tipe = tipe;
    }

    public Integer getKapasitasKamar() {
        return kapasitasKamar;
    }

    public void setKapasitasKamar(Integer kapasitasKamar) {
        this.kapasitasKamar = kapasitasKamar;
    }


}
