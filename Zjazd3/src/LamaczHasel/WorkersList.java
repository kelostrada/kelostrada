package LamaczHasel;

import java.util.ArrayList;

/**
 * @author bartosz.kalinowski
 */

public class WorkersList {
    ArrayList<Worker> workers = new ArrayList<>();
    
    public void add(Worker worker) {
        workers.add(worker);
    }
    
    public Worker getAt(int i) {
        return workers.get(i);
    }
    
    public ArrayList<ArrayList<Worker>> getWorkersDivided(int n) {
        ArrayList<ArrayList<Worker>> workersDivided;
        
        workersDivided = new ArrayList<>();
        int size = (n>workers.size())?workers.size():n;
        
        for (int i=0;i<size;i++) {
            workersDivided.add(new ArrayList<Worker>());
        }
        
        int workerPerTask = (int)Math.ceil(workers.size()/(double)size);
        int k = 0;
        
        for (int i=0;i<workers.size();i++) {
            workersDivided.get(k++).add(workers.get(i));
            if (k==size) {
                k = 0;
            }
            
        }
        
        return workersDivided;
    }
}
