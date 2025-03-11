import java.util.*;

class TicketBookingSystem {
    private final Set<Integer> bookedSeats = new HashSet<>();
    
    public synchronized boolean bookSeat(int seatNumber) {
        if (bookedSeats.contains(seatNumber)) {
            return false;
        }
        bookedSeats.add(seatNumber);
        return true;
    }
}

class BookingThread extends Thread {
    private TicketBookingSystem system;
    private int seatNumber;

    public BookingThread(TicketBookingSystem system, int seatNumber, int priority) {
        this.system = system;
        this.seatNumber = seatNumber;
        setPriority(priority);
    }

    public void run() {
        if (system.bookSeat(seatNumber)) {
            System.out.println(Thread.currentThread().getName() + " booked seat " + seatNumber);
        } else {
            System.out.println(Thread.currentThread().getName() + " failed to book seat " + seatNumber);
        }
    }
}

public class TicketBooking {
    public static void main(String[] args) {
        TicketBookingSystem system = new TicketBookingSystem();
        Thread vip1 = new BookingThread(system, 1, Thread.MAX_PRIORITY);
        Thread vip2 = new BookingThread(system, 2, Thread.MAX_PRIORITY);
        Thread user1 = new BookingThread(system, 1, Thread.NORM_PRIORITY);
        Thread user2 = new BookingThread(system, 2, Thread.NORM_PRIORITY);
        Thread user3 = new BookingThread(system, 3, Thread.MIN_PRIORITY);
        
        vip1.start();
        vip2.start();
        user1.start();
        user2.start();
        user3.start();
    }
}
