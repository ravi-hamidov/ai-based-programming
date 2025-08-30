
public class Manufacturer {

    private String name;
    private int foundationYear;
    private String country;

    public Manufacturer(String name, int foundationYear, String country) {
        this.name = name;
        this.foundationYear = foundationYear;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return name + " (" + country + ", Founded: " + foundationYear + ")";
    }
}
