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
        return null;
    }

    @Override
    public Comparator<String> sortByOrder() {
        return null;
    }

    private enum Month{
        GENNAIO(31,"Gennaio"),
        FEBBRAIO(28,"Febbraio"),
        MARZO(31,"Marzo"),
        APRILE(30,"Aprile"),
        MAGGIO(31,"Maggio"),
        GIUGNO(30,"Giugno"),
        LUGLIO(31,"Luglio"),
        AGOSTO(31,"Agosto"),
        SETTEMBRE(30,"Settembre"),
        OTTOBRE(31,"Ottobre"),
        NOVEMBRE(30,"Novembre"),
        DICEMBRE(31,"Dicembre");

        private int days;
        private String actualName;

        private Month(int days, String actualName) {
            this.days = days;
            this.actualName=actualName;
        }
        
        Month fromString(String name) {
            for (Month mese : Month.values()) {
                if(mese.actualName.equals(name)) return mese;
            }
            return null;
        }

    }
}
