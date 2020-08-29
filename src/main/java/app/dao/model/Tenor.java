package app.dao.model;

public enum Tenor {

    Y_0_M_0_W_0_D_1(0, 0, 0, 1);

    private final double year;
    private final double month;
    private final double week;
    private final int day;
    private final String code;

    private Tenor(double year, double month, double week, int day) {
        this.year = year;
        this.month = month;
        this.week = week;
        this.day = day;
        this.code = "";
    }

    private String generateCode(double year, double month, double week, int day) {
        return String.format("Y_%.2f_M_%.2f_W_%.2f_D_%i", year, month, week, day);
    }

}
