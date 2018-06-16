public class TowerOfHanoi{
    Stack<Integer> disks;
    
    public TowerOfHanoi(){
        disks = new Stack<>();
    }
    
    private boolean add(int d) {
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
}
