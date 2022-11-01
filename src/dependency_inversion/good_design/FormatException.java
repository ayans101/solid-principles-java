package dependency_inversion.good_design;

import java.io.IOException;

public class FormatException extends IOException {
    public FormatException(Exception cause) {
        super(cause);
    }
}
