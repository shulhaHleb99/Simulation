public class Responce {

    private boolean successfull;
    private Class<? extends Creature> whom;
    private int targetId;
    private int x;
    private int y;
    private int additionalCode = 0;

    public Responce(boolean successfull, Class<? extends Creature> whom, int targetId, int y, int x) {
        this.successfull = successfull;
        this.whom = whom;
        this.targetId = targetId;
        this.x = x;
        this.y = y;
    }

    public Responce(int y, int x) {
        this.x = x;
        this.y = y;
    }

    public Responce (int additionalCode) {
        this.additionalCode = additionalCode;
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

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getAdditionalCode() {
        return additionalCode;
    }
}
