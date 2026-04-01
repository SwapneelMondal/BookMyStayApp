public class GuessBookingTask implements Runnable {

    private final ConcurrentBookingProcessor processor;

    public GuessBookingTask(ConcurrentBookingProcessor processor) {
        this.processor = processor;
    }

    @Override
    public void run() {
        processor.processBooking();
    }
}