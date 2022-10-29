package open_closed.bad_design;

import java.util.List;

public class PhoneSubscriber {
    private Long subscriberId;
    private String address;
    private Long phoneNumber;
    private int baseRate;

    public Long getSubscriberId() {
        return subscriberId;
    }

    public void setSubscriberId(Long subscriberId) {
        this.subscriberId = subscriberId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getBaseRate() {
        return baseRate;
    }

    public void setBaseRate(int baseRate) {
        this.baseRate = baseRate;
    }

    public double calculateBill() {
        List<CallHistory.Call> calls = CallHistory.getCurrentCalls(subscriberId);
        long totalDuration = calls.stream().mapToLong(CallHistory.Call::getDuration).sum();
        return (double) totalDuration * baseRate / 100;
    }
}
