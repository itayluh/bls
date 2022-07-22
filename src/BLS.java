
public class BLS {
    String status;
    int responseTime;
    String[] message;
    Results Results;

    public class Results {
        String seriesID;
        data[] data;

        public class data {
            String year;
            String period;
            String periodName;
            String latest;
            String value;
            Footnotes[] footnotes;

            public class Footnotes {
                String code;
                String text;
            }
        }
    }
}
