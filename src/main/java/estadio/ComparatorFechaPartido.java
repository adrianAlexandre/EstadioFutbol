package estadio;

import java.util.Comparator;

public class ComparatorFechaPartido<Partido> implements Comparator {

    @Override
    public int compare(Object o, Object t1) {
        estadio.Partido obj1=(estadio.Partido) o;
        estadio.Partido obj2=(estadio.Partido) t1;
        return compare(obj1.getFecha(),obj2.getFecha());
    }
}

