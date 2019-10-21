package at.htl.model.objects;

import at.htl.model.building.ExhibitionRoom;

import javax.persistence.*;

@Entity
@Table(name = "MINERALS")
public class Mineral extends Exhibit
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", updatable = false, nullable = false)
    private Long id;
    @Version
    @Column(name = "VERSION")
    private int version;

    @Column(name = "CHEMICAL_NAME")
    private String chemicalName;
    @Column(name = "CHEMICAL_FORMULA")
    private String chemicalFormula;
    @Column(name = "DENSITY")
    private Double density;

    public Mineral() { }

    public String getChemicalName()
    {
        return chemicalName;
    }

    public void setChemicalName(String chemicalName)
    {
        this.chemicalName = chemicalName;
    }

    public String getChemicalFormula()
    {
        return chemicalFormula;
    }

    public void setChemicalFormula(String chemicalFormula)
    {
        this.chemicalFormula = chemicalFormula;
    }

    public Double getDensity()
    {
        return density;
    }

    public void setDensity(Double density)
    {
        this.density = density;
    }

    public Mineral(String exhibitName, String origin, ExhibitionRoom room, String chemicalName, String chemicalFormula, Double density)
    {
        super(exhibitName, origin, room);
        this.chemicalName = chemicalName;
        this.chemicalFormula = chemicalFormula;
        this.density = density;
    }
}
