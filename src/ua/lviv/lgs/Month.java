package ua.lviv.lgs;

public enum Month {
    JANUARY(Seassons.WINTER,31),
    FEBRUARY(Seassons.WINTER,28),
    MARCH(Seassons.SPRING,31),
    APRIL(Seassons.SPRING,30),
    MAY(Seassons.SPRING,31),
    JUNE(Seassons.SUMMER,30),
    JULY(Seassons.SUMMER,31),
    AUGUST(Seassons.SUMMER,31),
    SEPTEMBER(Seassons.AUTUMN,30),
    OCTOBER(Seassons.AUTUMN,31),
    NOVEMBER(Seassons.AUTUMN,30),
    DECEMBER(Seassons.WINTER,31);

    Seassons seassons;
    private int days;

    Month(Seassons seassons, int days) {
        this.seassons = seassons;
        this.days = days;
    }

    public Seassons getSeassons() {
        return seassons;
    }

    public int getDays() {
        return days;
    }
}
