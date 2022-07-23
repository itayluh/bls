
public class BLS {
    String status;
    int responseTime;
    String[] message;
    Results Results;
}

class Results {
    series[] series;
}

class series {
    String seriesID;
    data[] data;
}

class data {
    String year;
    String period;
    String periodName;
    String latest;
    String value;
    Footnotes[] footnotes;
}

class Footnotes {
    String code;
    String text;
}