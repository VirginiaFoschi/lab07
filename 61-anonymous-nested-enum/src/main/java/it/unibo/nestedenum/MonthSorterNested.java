package it.unibo.nestedenum;

import java.util.Comparator;
import java.util.Locale;
import java.util.Objects;

/**
 * Implementation of {@link MonthSorter}.
 */
public final class MonthSorterNested implements MonthSorter {

    @Override
    public Comparator<String> sortByDays() {
        return new Comparator<String>() {

            @Override
            public int compare(String arg0, String arg1) {
                // TODO Auto-generated method stub
                Month mese1 = Month.fromString(arg0);
                Month mese2 = Month.fromString(arg1);
                return mese1.days.compareTo(mese2.days);
            }
            
        };
    }

    @Override
    public Comparator<String> sortByOrder() {
        return new Comparator<String>() {

            @Override
            public int compare(String arg0, String arg1) {
                // TODO Auto-generated method stub
                return Month.fromString(arg0).compareTo(Month.fromString(arg1));
            }
            
        };
        
    }

    private enum Month{
        JANUARY("31"),
        FEBRUARY("28"),
        MARCH("31"),
        APRIL("30"),
        MAY("31"),
        JUNE("30"),
        JULY("31"),
        AGOUST("31"),
        SEPTEMBER("30"),
        OCTOBER("31"),
        NOVEMBER("30"),
        DICEMBER("31");

        public String days;

        private Month(String days) {
            this.days = days;
        }

        private String toString(Month mese) {
            return mese.name();
        }
        
        static Month fromString(String name) {
            Month month=null;
            int trovato=0;
            for(Month mese : Month.values()) {
                if(mese.toString(mese).startsWith(name.toUpperCase())) {
                    month = mese;
                    trovato++;
                }
            }
            if(trovato > 1 || month == null) {
                System.out.println("ERROR");
                return null;
            }
            else return month;
        }

    }
}
