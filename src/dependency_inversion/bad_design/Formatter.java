package dependency_inversion.bad_design;

public interface Formatter {
    public String format(Message message) throws FormatException;
}
