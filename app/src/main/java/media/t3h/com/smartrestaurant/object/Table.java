package media.t3h.com.smartrestaurant.object;

/**
 * Created by Ngoc on 8/28/2016.
 */
public class Table {
    public static final int EMPTY = 0 ;
    public static final int OCCUPY = 1 ;

    private int  id;
    private String name;
    private int status;

    public Table() {
    }

    public Table(int id, String name, int status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }
}
