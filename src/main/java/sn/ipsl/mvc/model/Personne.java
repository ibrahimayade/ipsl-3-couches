package sn.ipsl.mvc.model;

public class Personne {
    private Long id;
    private String telephone;
    private String nom;
    private String prenom;
    private int age;

    public Personne() {

    }

    public Personne(String nom, String prenom, String tel,int age) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "Personne{" +
                "id=" + id +
                ", telephone='" + telephone + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", age=" + age +
                '}';
    }
}
