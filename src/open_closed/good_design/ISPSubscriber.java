package open_closed.good_design;

import open_closed.bad_design.InternetSessionHistory;

import java.util.List;

public class ISPSubscriber extends Subscriber {
    private long freeUsage;

    public long getFreeUsage() {
        return freeUsage;
    }

    public void setFreeUsage(long freeUsage) {
        this.freeUsage = freeUsage;
    }

    @Override
    public double calculateBill() {
        List<open_closed.bad_design.InternetSessionHistory.InternetSession> sessions = open_closed.bad_design.InternetSessionHistory.getCurrentSessions(subscriberId);
        long totalDataUsed = sessions.stream().mapToLong(InternetSessionHistory.InternetSession::getDataUsed).sum();
        long chargeableData = totalDataUsed - freeUsage;
        return (double) chargeableData * baseRate / 100;
    }
}
