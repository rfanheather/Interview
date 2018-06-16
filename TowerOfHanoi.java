public class TowerOfHanoi{
    Stack<Integer> disks;
    
    public TowerOfHanoi(){
        disks = new Stack<>();
    }
    
    public boolean add(int d) {
        if (!disks.isEmpty() && disks.peek() <= d) {
            return false;
        } else {
            disks.push(d);
            return true;
        }
    }
    
    private void moveTopTo(TowerOfHanoi t) {
        int d = disks.peek();
        if (t.add(d)){
            disks.pop();
        }
    }
    
    public Stack<Integer> getDisks() {
        return disks;
    }
    
    public void moveToDestination(int n, TowerOfHanoi destination, TowerOfHanoi buffer) {
        if (n <= 0) {
            return;
        }
        
        moveToDestination(n - 1, buffer, destination);
        moveTopTo(destination);
        buffer.moveToDestination(n - 1, destination, this);
    }
    
    public static void main(String[] args) {
        TowerOfHanoi[] towers = new TowerOfHanoi[3];
        for (int i = 0; i < 3; i++) {
            towers[i] = new TowerOfHanoi();
        }
     
        int numOfDisks = 3;
        for (int i = numOfDisks - 1; i >= 0; i--) {
            towers[i].add(i);
        }
     
        towers[i].moveToDestination(numOfDisks, towers[2], towers[1]);
        System.out.println(towers[0]);
        System.out.println(towers[1]);
        System.out.println(towers[2]);
    }
}
