package TAM;

/**
 *
 * @author xdavi
 */
public class Thread {
    public int start, end, CP, id;
    public boolean run, active;

    public Thread(int start, int end, int id) {
        this.start = start;
        this.CP = start+1;
        this.run = true;
        this.active = false;
        this.end = end;
        this.id = id;
    }
    
}
