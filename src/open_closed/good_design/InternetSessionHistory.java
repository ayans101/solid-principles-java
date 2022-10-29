package open_closed.good_design;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class InternetSessionHistory {
    public static class InternetSession {
        private LocalDateTime begin;
        private long dataUsed;
        private Long subscriberId;

        public InternetSession(LocalDateTime begin, long dataUsed, Long subscriberId) {
            this.begin = begin;
            this.dataUsed = dataUsed;
            this.subscriberId = subscriberId;
        }

        public LocalDateTime getBegin() {
            return begin;
        }

        public long getDataUsed() {
            return dataUsed;
        }

        public Long getSubscriberId() {
            return subscriberId;
        }
    }

    private static final HashMap<Long, List<InternetSession>> SESSIONS = new HashMap<>();

    public synchronized static List<InternetSession> getCurrentSessions(Long subscriberId) {
        return SESSIONS.getOrDefault(subscriberId, Collections.emptyList());
    }

    public synchronized static void addSession(Long subscriberId, LocalDateTime begin, long dataUsed) {
        List<InternetSession> sessions;
        if (!SESSIONS.containsKey(subscriberId)) {
            sessions = new LinkedList<>();
            SESSIONS.put(subscriberId, sessions);
        } else {
            sessions = SESSIONS.get(subscriberId);
        }
        sessions.add(new InternetSession(begin, dataUsed, subscriberId));
    }
}
