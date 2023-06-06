package TAM;

/**
 *
 * @author xdavi
 */
public class Thread {
    public int start, end, size, currentInstruction;
    public boolean run;

    public Thread(int start) {
        this.start = start;
        this.currentInstruction = start+1;
        this.run = true;
        this.end = 0;
        this.size = 0;
    }
    
}
