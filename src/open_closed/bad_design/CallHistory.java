package open_closed.bad_design;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class CallHistory {
    public static class Call {
        private LocalDateTime begin;
        private long duration;
        private Long subscriberId;

        public Call(LocalDateTime begin, long duration, Long subscriberId) {
            this.begin = begin;
            this.duration = duration;
            this.subscriberId = subscriberId;
        }

        public LocalDateTime getBegin() {
            return begin;
        }

        public long getDuration() {
            return duration;
        }

        public Long getSubscriberId() {
            return subscriberId;
        }
    }

    private static final HashMap<Long, List<Call>> CALLS = new HashMap<>();

    public synchronized static List<Call> getCurrentCalls(Long subscriberId) {
        return CALLS.getOrDefault(subscriberId, Collections.emptyList());
    }

    public synchronized static void addSession(Long subscriberId, LocalDateTime begin, long duration) {
        List<Call> calls;
        if (!CALLS.containsKey(subscriberId)) {
            calls = new LinkedList<>();
            CALLS.put(subscriberId, calls);
        } else {
            calls = CALLS.get(subscriberId);
        }
        calls.add(new Call(begin, duration, subscriberId));
    }
}
