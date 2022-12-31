package open_closed.good_design;

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
        List<InternetSessionHistory.InternetSession> sessions = InternetSessionHistory.getCurrentSessions(subscriberId);
        long totalDataUsed = sessions.stream().mapToLong(InternetSessionHistory.InternetSession::getDataUsed).sum();
        long chargeableData = totalDataUsed - freeUsage;
        return (double) chargeableData * baseRate / 100;
    }
}
