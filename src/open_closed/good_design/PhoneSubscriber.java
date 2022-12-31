package open_closed.good_design;

import java.util.List;

public class PhoneSubscriber extends Subscriber {
    @Override
    public double calculateBill() {
        List<CallHistory.Call> calls = CallHistory.getCurrentCalls(subscriberId);
        long totalDuration = calls.stream().mapToLong(CallHistory.Call::getDuration).sum();
        return (double) totalDuration * baseRate / 100;
    }
}
