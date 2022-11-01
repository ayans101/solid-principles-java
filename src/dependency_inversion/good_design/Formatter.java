package dependency_inversion.good_design;

public interface Formatter {
    public String format(Message message) throws FormatException;
}
