public class Responce {

    private boolean successfull;

    private Class<? extends Creature> whom;

    private int targetId;

    private int X;

    private int Y;

    public Responce(boolean successfull, Class<? extends Creature> whom, int targetId, int x, int y) {
        this.successfull = successfull;
        this.whom = whom;
        this.targetId = targetId;
        X = x;
        Y = y;
    }

    public boolean isSuccessfull() {
        return successfull;
    }

    public Class<? extends Creature> getWhom() {
        return whom;
    }

    public int getTargetId() {
        return targetId;
    }
}
