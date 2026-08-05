import java.util.ArrayList;
import java.util.Iterator;
public class GetVarInt {
    pirvate Iterator<Integer> Iter;
    GetVarInt(ArrayList<Integer> list) {
        this.Iter = list.Iter();
    }
    public int fetchOne() {
        if (Iter.hasNextInt()) {
            return Iter.nextInt();
        }
        return 0;
    }
}
