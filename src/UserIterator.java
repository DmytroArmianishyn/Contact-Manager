import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UserIterator<Osoba> implements Iterator<Osoba> {

    List<Osoba> list = new ArrayList<>();
    int id ;

    public UserIterator(List<Osoba> list) {
        this.list = list;
        id=0;
    }

    @Override
    public boolean hasNext() {



        return id<list.size();
    }

    @Override
    public Osoba next() {
        Osoba o1 = list.get(id);
        id++;
        return o1;
    }
}
