package hello.advanced.trace;

import java.util.UUID;

public class TraceId {

    private String id;
    private int level;

    public TraceId() {
        this.id = createId();
        this.level = 0;
    }
    
    private TraceId(String id, int level) {
        this.id = id;
        this.level = level;
    }

    private String createId() {
        //c2767d9c-c158-4a65-87d6-835642c2f253
        //c2767d9c로 만든다. -> 중복이 되긴하는데 로그 남길때는 괜찮다.
        return UUID.randomUUID().toString().substring(0, 8);
    }

    public TraceId createNextId() {
        return new TraceId(id, level + 1);
    }

    public TraceId createPreviousId() {
        return new TraceId(id, level - 1);
    }

    public boolean isFirstLevel() {
        return level == 0;
    }

    public String getId() {
        return id;
    }

    public int getLevel() {
        return level;
    }
}
