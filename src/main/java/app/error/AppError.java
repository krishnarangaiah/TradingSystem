package app.error;

public class AppError extends RuntimeException {

    private final String msg;
    private final Throwable t;

    public AppError(String msg, Throwable t) {
        super(msg, t);
        this.msg = msg;
        this.t = t;
    }

    public AppError() {
        this(null, null);
    }

}
