package open_closed.good_design;

import open_closed.bad_design.CallHistory;

import java.util.List;

public class PhoneSubscriber extends Subscriber {
    @Override
    public double calculateBill() {
        List<open_closed.bad_design.CallHistory.Call> calls = open_closed.bad_design.CallHistory.getCurrentCalls(subscriberId);
        long totalDuration = calls.stream().mapToLong(CallHistory.Call::getDuration).sum();
        return (double) totalDuration * baseRate / 100;
    }
}
