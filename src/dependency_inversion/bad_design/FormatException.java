package dependency_inversion.bad_design;

import java.io.IOException;

public class FormatException extends IOException {
    public FormatException(Exception cause) {
        super(cause);
    }
}
