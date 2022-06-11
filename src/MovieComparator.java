import java.util.Comparator;

public enum MovieComparator {
    TITLE("Title", 1, Comparator.comparing(Movie::getTitle)),
    RATING("Rating", 2, Comparator.comparing(Movie::getRating).reversed()),
    YEAR("Year",3, Comparator.comparing(Movie::getYear).reversed());

    private final String criteria;
    private final Comparator<Movie> comparator;
    private final int number;

    MovieComparator(String criteria, int number, Comparator<Movie> comparator) {
        this.criteria = criteria;
        this.comparator = comparator;
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public String getCriteria() {
        return criteria;
    }

    public Comparator<Movie> getComparator() {
        return comparator;
    }

    public static MovieComparator convert(String criteria) {
        MovieComparator[] values = MovieComparator.values();
        try {
            final int i = Integer.parseInt(criteria);
            for (MovieComparator value : values) {
                if(value.getNumber() == (i))
                    return value;
            }
        } catch (NumberFormatException ignored){
            for (MovieComparator value : values) {
                if(value.getCriteria().equalsIgnoreCase(criteria))
                    return value;
            }
        }
        throw new IllegalArgumentException("Nieprawid³owe kryterium sortowania " + criteria);
    }

    @Override
    public String toString() {
        return "> " + number + " " + criteria;
    }
}
