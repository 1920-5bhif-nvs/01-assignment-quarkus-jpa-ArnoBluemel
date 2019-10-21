package at.htl.model.objects;

import at.htl.model.building.ExhibitionRoom;

import javax.persistence.*;

@Entity
@Table(name = "FOSSILS")
public class Fossil extends Exhibit
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", updatable = false, nullable = false)
    private Long id;
    @Version
    @Column(name = "VERSION")
    private int version;
    @Column(name = "AGE_IN_MY")
    private Long age_in_my;
    //tax = taxonomic
    @Column(name = "TAX_SPECIES", nullable = false)
    private String tax_species;
    @Column(name = "TAX_GENUS", nullable = false)
    private String tax_genus;
    @Column(name = "TAX_FAMILY", nullable = false)
    private String tax_family;
    @Column(name = "TAX_ORDER", nullable = false)
    private String tax_order;
    @Column(name = "TAX_CLASS", nullable = false)
    private String tax_class;
    @Column(name = "TAX_PHYLUM", nullable = false)
    private String tax_phylum;
    @Column(name = "TAX_KINGDOM", nullable = false)
    private String tax_kingdom;
    @Column(name = "TAX_DOMAIN", nullable = false)
    private String tax_domain;

    public Fossil() { }

    public Long getAge_in_my()
    {
        return age_in_my;
    }

    public void setAge_in_my(Long age)
    {
        this.age_in_my = age;
    }

    public String getTax_species()
    {
        return tax_species;
    }

    public void setTax_species(String species)
    {
        this.tax_species = species;
    }

    public String getTax_genus()
    {
        return tax_genus;
    }

    public void setTax_genus(String genus)
    {
        this.tax_genus = genus;
    }

    public String getTax_family() {
        return tax_family;
    }

    public void setTax_family(String family)
    {
        this.tax_family = family;
    }

    public String getTax_order()
    {
        return tax_order;
    }

    public void setTax_order(String order)
    {
        this.tax_order = order;
    }

    public String getTax_class()
    {
        return tax_class;
    }

    public void setTax_class(String tax_class)
    {
        this.tax_class = tax_class;
    }

    public String getTax_phylum()
    {
        return tax_phylum;
    }

    public void setTax_phylum(String phylum)
    {
        this.tax_phylum = phylum;
    }

    public String getTax_kingdom()
    {
        return tax_kingdom;
    }

    public void setTax_kingdom(String kingdom)
    {
        this.tax_kingdom = kingdom;
    }

    public String getTax_domain()
    {
        return tax_domain;
    }

    public void setTax_domain(String domain)
    {
        this.tax_domain = domain;
    }

    public Fossil(String exhibitName, String origin, ExhibitionRoom room, Long age, String tax_species, String genus, String family, String order, String tax_class, String phylum, String kingdom, String domain)
    {
        super(exhibitName, origin, room);
        this.age_in_my = age;
        this.tax_species = tax_species;
        this.tax_genus = genus;
        this.tax_family = family;
        this.tax_order = order;
        this.tax_class = tax_class;
        this.tax_phylum = phylum;
        this.tax_kingdom = kingdom;
        this.tax_domain = domain;
    }
}
