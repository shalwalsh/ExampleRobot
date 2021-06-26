public class CompactCountVisitor extends AbstractActionVisitor{
    int count = 0;

    @Override
    public void visitCompactObjectAction(CompactObjectAction pAction) {
        count += 1;
    }

    public int getCount(){
        return count;
    }
}
