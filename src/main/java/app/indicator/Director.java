package app.indicator;

public class Director {
    public Indicator construct(Builder builder, float end, float metka) {

        builder = new BuilderFirst();

        builder.addTitle("Норма");

        builder.lineMark(String.format("%.1f", metka));
        builder.setMark(metka);
        builder.lineBounds(0, end);
        Indicator indicator = builder.build();
        return indicator;
    }
}
