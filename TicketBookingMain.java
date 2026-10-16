
import java.util.Scanner;

// Ticket Booking class
class TicketBooking
{
    String passengerName;
    String bookingStatus;

    TicketBooking(String passengerName)
    {
        this.passengerName = passengerName;
        this.bookingStatus = "Confirmed";
    }

    void bookTicket()
    {
        if(passengerName == null || passengerName.trim().isEmpty())
        {
            System.out.println("Invalid passenger name!");
            bookingStatus = "Failed";
            return;
        }

        System.out.println("Passenger Name: " + passengerName);
        System.out.println("Booking Status: " + bookingStatus);
        System.out.println("Thread Name: " +
                           Thread.currentThread().getName());
        System.out.println("Thread ID: " +
                           Thread.currentThread().getId());
    }
}

// Thread class
class BookingThread extends Thread
{
    TicketBooking booking;

    BookingThread(TicketBooking booking)
    {
        this.booking = booking;
    }

    public void run()
    {
        if(booking == null)
        {
            System.out.println("Error: Booking object is null!");
            return;
        }

        booking.bookTicket();
    }
}

// Runnable interface
class BookingRunnable implements Runnable
{
    TicketBooking booking;

    BookingRunnable(TicketBooking booking)
    {
        this.booking = booking;
    }

    public void run()
    {
        if(booking == null)
        {
            System.out.println("Error: Booking object is null!");
            return;
        }

        booking.bookTicket();
    }
}

// Main class
public class TicketBookingMain
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int choice = -1;

        do
        {
            System.out.println("\n===== TICKET BOOKING TEST MENU =====");
            System.out.println("1. Booking using Thread class");
            System.out.println("2. Booking using Runnable interface");
            System.out.println("3. Multiple passengers concurrently");
            System.out.println("4. Verify start() method");
            System.out.println("5. Display thread information");
            System.out.println("6. Five booking requests");
            System.out.println("7. Display booking status");
            System.out.println("8. Mixed Thread and Runnable");
            System.out.println("9. Verify thread termination");
            System.out.println("10. 50 booking threads");
            System.out.println("11. Empty passenger name");
            System.out.println("12. Null passenger name");
            System.out.println("13. Call run() directly");
            System.out.println("14. Start same thread twice");
            System.out.println("15. Null Runnable object");
            System.out.println("16. Interrupt a thread");
            System.out.println("17. Null booking object");
            System.out.println("18. Shared booking object");
            System.out.println("19. 500 booking threads");
            System.out.println("20. Simulate thread creation failure");
            System.out.println("0. Exit");
            System.out.print("Select one test case: ");

            try
            {
                choice = sc.nextInt();
                sc.nextLine();
            }
            catch(Exception e)
            {
                System.out.println("Please enter a valid number.");
                sc.nextLine();
                continue;
            }

            try
            {
                switch(choice)
                {
                    case 1:
                    {
                        System.out.print("Passenger name: ");
                        String name = sc.nextLine();

                        BookingThread t = new BookingThread(
                            new TicketBooking(name));

                        t.start();
                        t.join();
                        break;
                    }

                    case 2:
                    {
                        System.out.print("Passenger name: ");
                        String name = sc.nextLine();

                        Thread t = new Thread(
                            new BookingRunnable(new TicketBooking(name)));

                        t.start();
                        t.join();
                        break;
                    }

                    case 3:
                    {
                        System.out.print("Enter number of passengers: ");
                        int n = sc.nextInt();
                        sc.nextLine();

                        if(n <= 0 || n > 500)
                        {
                            System.out.println("Enter a number from 1 to 500.");
                            break;
                        }

                        Thread[] threads = new Thread[n];

                        for(int i = 0; i < n; i++)
                        {
                            System.out.print("Passenger " + (i + 1) + ": ");
                            String name = sc.nextLine();

                            threads[i] = new Thread(
                                new BookingRunnable(new TicketBooking(name)));
                            threads[i].start();
                        }

                        for(Thread t : threads)
                            t.join();

                        break;
                    }

                    case 4:
                    {
                        BookingThread t = new BookingThread(
                            new TicketBooking("Rahul"));

                        t.start();
                        t.join();

                        System.out.println("Thread state: " + t.getState());
                        break;
                    }

                    case 5:
                    {
                        BookingThread t = new BookingThread(
                            new TicketBooking("Rahul"));

                        t.setName("PassengerBookingThread");
                        t.start();
                        t.join();

                        System.out.println("Thread ID: " + t.getId());
                        break;
                    }

                    case 6:
                    {
                        Thread[] threads = new Thread[5];

                        for(int i = 0; i < 5; i++)
                        {
                            threads[i] = new Thread(
                                new BookingRunnable(
                                    new TicketBooking("Passenger" + (i + 1))));
                            threads[i].start();
                        }

                        for(Thread t : threads)
                            t.join();

                        break;
                    }

                    case 7:
                    {
                        TicketBooking b = new TicketBooking("Priya");
                        b.bookTicket();
                        break;
                    }

                    case 8:
                    {
                        BookingThread t1 = new BookingThread(
                            new TicketBooking("Rahul"));

                        Thread t2 = new Thread(
                            new BookingRunnable(new TicketBooking("Priya")));

                        t1.start();
                        t2.start();

                        t1.join();
                        t2.join();
                        break;
                    }

                    case 9:
                    {
                        BookingThread t = new BookingThread(
                            new TicketBooking("Aman"));

                        t.start();
                        t.join();

                        System.out.println("Thread terminated: " +
                            (t.getState() == Thread.State.TERMINATED));
                        break;
                    }

                    case 10:
                    case 19:
                    {
                        int n = (choice == 10) ? 50 : 500;
                        Thread[] threads = new Thread[n];

                        for(int i = 0; i < n; i++)
                        {
                            final int id = i + 1;

                            threads[i] = new Thread(() ->
                            {
                                if(id <= 5)
                                    new TicketBooking("Passenger" + id)
                                        .bookTicket();
                            });

                            threads[i].start();
                        }

                        for(Thread t : threads)
                            t.join();

                        System.out.println(n + " threads completed.");
                        break;
                    }

                    case 11:
                    {
                        BookingThread t = new BookingThread(
                            new TicketBooking(""));

                        t.start();
                        t.join();
                        break;
                    }

                    case 12:
                    {
                        BookingThread t = new BookingThread(
                            new TicketBooking(null));

                        t.start();
                        t.join();
                        break;
                    }

                    case 13:
                    {
                        BookingThread t = new BookingThread(
                            new TicketBooking("Rahul"));

                        t.run();

                        System.out.println("Current thread: " +
                            Thread.currentThread().getName());
                        break;
                    }

                    case 14:
                    {
                        BookingThread t = new BookingThread(
                            new TicketBooking("Priya"));

                        t.start();

                        try
                        {
                            t.start();
                        }
                        catch(IllegalThreadStateException e)
                        {
                            System.out.println(
                                "Error: A thread cannot be started twice.");
                        }

                        t.join();
                        break;
                    }

                    case 15:
                    {
                        Runnable r = null;
                        Thread t = new Thread(r);

                        t.start();
                        t.join();

                        System.out.println(
                            "Thread completed with a null Runnable.");
                        break;
                    }

                    case 16:
                    {
                        Thread t = new Thread(() ->
                        {
                            try
                            {
                                Thread.sleep(5000);
                                System.out.println("Booking completed.");
                            }
                            catch(InterruptedException e)
                            {
                                System.out.println(
                                    "Booking thread interrupted.");
                                Thread.currentThread().interrupt();
                            }
                        });

                        t.start();
                        t.interrupt();
                        t.join();
                        break;
                    }

                    case 17:
                    {
                        BookingThread t = new BookingThread(null);
                        t.start();
                        t.join();
                        break;
                    }

                    case 18:
                    {
                        TicketBooking shared =
                            new TicketBooking("SharedPassenger");

                        Thread t1 = new Thread(() -> shared.bookTicket());
                        Thread t2 = new Thread(() -> shared.bookTicket());

                        t1.start();
                        t2.start();

                        t1.join();
                        t2.join();
                        break;
                    }

                    case 20:
                    {
                        System.out.println(
                            "Simulating thread creation failure.");
                        try
                        {
                            throw new OutOfMemoryError(
                                "Simulated thread creation failure");
                        }
                        catch(OutOfMemoryError e)
                        {
                            System.out.println(e.getMessage());
                        }
                        break;
                    }

                    case 0:
                        System.out.println("Program terminated.");
                        break;

                    default:
                        System.out.println("Invalid choice.");
                }
            }
            catch(InterruptedException e)
            {
                System.out.println("Main thread interrupted.");
                Thread.currentThread().interrupt();
                break;
            }
            catch(Exception e)
            {
                System.out.println("Error: " + e.getMessage());
            }

        } while(choice != 0);

        sc.close();
    }
}
