/*import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class Airlinereservation extends JFrame {

    // --------- Flight Class ---------
    static class Flight {
        private int flightId;
        private String flightName;
        private String source;
        private String destination;
        private int availableSeats;

        public Flight(int flightId, String flightName, String source, String destination, int seats) {
            this.flightId = flightId;
            this.flightName = flightName;
            this.source = source;
            this.destination = destination;
            this.availableSeats = seats;
        }

        public int getFlightId() { return flightId; }
        public String getFlightName() { return flightName; }
        public String getSource() { return source; }
        public String getDestination() { return destination; }
        public int getAvailableSeats() { return availableSeats; }

        public boolean bookSeat() {
            if (availableSeats > 0) {
                availableSeats--;
                return true;
            }
            return false;
        }

        public void cancelSeat() { availableSeats++; }
    }

    // --------- Passenger Class ---------
    static class Passenger {
        private String name;
        private int age;
        private int flightId;

        public Passenger(String name, int age, int flightId) {
            this.name = name;
            this.age = age;
            this.flightId = flightId;
        }

        public String getName() { return name; }
        public int getAge() { return age; }
        public int getFlightId() { return flightId; }
    }

    // Data Lists
    static ArrayList<Flight> flights = new ArrayList<>();
    static ArrayList<Passenger> passengers = new ArrayList<>();

    // Swing Components
    JTextArea displayArea;
    JTextField flightIdField, nameField, ageField;

    public Airlinereservation() {

        setTitle("Airline Reservation System");
        setSize(650, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        initializeFlights();

        JLabel title = new JLabel("Airline Reservation System", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setBounds(150, 10, 350, 40);
        add(title);

        JButton viewFlightsBtn = new JButton("View Flights");
        JButton bookTicketBtn = new JButton("Book Ticket");
        JButton cancelTicketBtn = new JButton("Cancel Ticket");
        JButton viewPassengersBtn = new JButton("View Passengers");

        viewFlightsBtn.setBounds(30, 80, 150, 30);
        bookTicketBtn.setBounds(200, 80, 150, 30);
        cancelTicketBtn.setBounds(370, 80, 150, 30);
        viewPassengersBtn.setBounds(530, 80, 150, 30);

        add(viewFlightsBtn);
        add(bookTicketBtn);
        add(cancelTicketBtn);
        add(viewPassengersBtn);

        JLabel flightLabel = new JLabel("Flight ID:");
        flightLabel.setBounds(30, 140, 100, 25);
        add(flightLabel);

        flightIdField = new JTextField();
        flightIdField.setBounds(120, 140, 150, 25);
        add(flightIdField);

        JLabel nameLabel = new JLabel("Passenger Name:");
        nameLabel.setBounds(300, 140, 120, 25);
        add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(430, 140, 150, 25);
        add(nameField);

        JLabel ageLabel = new JLabel("Age:");
        ageLabel.setBounds(30, 180, 100, 25);
        add(ageLabel);

        ageField = new JTextField();
        ageField.setBounds(120, 180, 150, 25);
        add(ageField);

        displayArea = new JTextArea();
        displayArea.setEditable(false);
        JScrollPane sp = new JScrollPane(displayArea);
        sp.setBounds(30, 230, 580, 300);
        add(sp);

        // ---- Button Events ----
        viewFlightsBtn.addActionListener(e -> viewFlights());
        bookTicketBtn.addActionListener(e -> bookTicket());
        cancelTicketBtn.addActionListener(e -> cancelTicket());
        viewPassengersBtn.addActionListener(e -> viewPassengers());

        setVisible(true);
    }

    // -------- Methods Logic --------

    public static void initializeFlights() {
        flights.add(new Flight(101, "Air India", "Delhi", "Mumbai", 5));
        flights.add(new Flight(102, "IndiGo", "Mumbai", "Bangalore", 5));
        flights.add(new Flight(103, "SpiceJet", "Delhi", "Bangalore", 5));
    }

    public void viewFlights() {
        StringBuilder sb = new StringBuilder("Available Flights:\n\n");
        for (Flight f : flights) {
            sb.append(f.getFlightId()).append(" | ")
              .append(f.getFlightName()).append(" | ")
              .append(f.getSource()).append(" -> ")
              .append(f.getDestination()).append(" | Seats: ")
              .append(f.getAvailableSeats()).append("\n");
        }
        displayArea.setText(sb.toString());
    }

    public void bookTicket() {
        try {
            int id = Integer.parseInt(flightIdField.getText());
            Flight selected = null;

            for (Flight f : flights) {
                if (f.getFlightId() == id) { selected = f; break; }
            }

            if (selected == null) {
                displayArea.setText("Flight not found!");
                return;
            }

            if (!selected.bookSeat()) {
                displayArea.setText("No seats available!");
                return;
            }

            String name = nameField.getText();
            int age = Integer.parseInt(ageField.getText());

            passengers.add(new Passenger(name, age, id));

            displayArea.setText("Ticket booked successfully!");

        } catch (Exception e) {
            displayArea.setText("Invalid Input. Please check values.");
        }
    }

    public void cancelTicket() {
        String name = nameField.getText();
        Passenger toRemove = null;

        for (Passenger p : passengers) {
            if (p.getName().equalsIgnoreCase(name)) {
                toRemove = p;
                break;
            }
        }

        if (toRemove == null) {
            displayArea.setText("Passenger not found!");
            return;
        }

        passengers.remove(toRemove);

        for (Flight f : flights) {
            if (f.getFlightId() == toRemove.getFlightId()) {
                f.cancelSeat();
                break;
            }
        }

        displayArea.setText("Ticket canceled successfully!");
    }

    public void viewPassengers() {
        StringBuilder sb = new StringBuilder("Passenger List:\n\n");
        for (Passenger p : passengers) {
            sb.append("Name: ").append(p.getName()).append(" | Age: ").append(p.getAge())
              .append(" | Flight ID: ").append(p.getFlightId()).append("\n");
        }
        displayArea.setText(sb.toString());
    }

    public static void main(String[] args) {
        new Airlinereservation();
    }
} */    
import java.io.*;
import java.util.*;

// Flight Class
class Flight {
    int flightNumber;
    String origin;
    String destination;
    int seatsAvailable;
    double price;

    public Flight(int flightNumber, String origin, String destination, int seatsAvailable, double price) {
        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
        this.seatsAvailable = seatsAvailable;
        this.price = price;
    }
}

// Booking Class
class Booking {
    String bookingId;
    String passengerName;
    String contact;
    int flightNumber;
    String origin;
    String destination;
    double amountPaid;

    public Booking(String bookingId, String passengerName, String contact,
                   int flightNumber, String origin, String destination, double amountPaid) {

        this.bookingId = bookingId;
        this.passengerName = passengerName;
        this.contact = contact;
        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
        this.amountPaid = amountPaid;
    }

    @Override
    public String toString() {
        return bookingId + "," + passengerName + "," + contact + "," + flightNumber + "," +
               origin + "," + destination + "," + amountPaid;
    }
}

// Main Program
public class Airlinereservation {

    static ArrayList<Flight> flights = new ArrayList<>();
    static ArrayList<Booking> bookings = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static File file = new File("airline_bookings.txt");

    public static void main(String[] args) {
        initializeFlights();
        loadBookingsFromFile();

        while (true) {
            System.out.println("\n===== AIRLINE RESERVATION SYSTEM =====");
            System.out.println("1. View Available Flights");
            System.out.println("2. Search Flights (Origin → Destination)");
            System.out.println("3. Book a Flight");
            System.out.println("4. Cancel Booking");
            System.out.println("5. View All Bookings");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int choice = getValidChoice();

            switch (choice) {
                case 1 -> viewFlights();
                case 2 -> searchFlights();
                case 3 -> bookFlight();
                case 4 -> cancelBooking();
                case 5 -> viewAllBookings();
                case 6 -> {
                    saveBookingsToFile();
                    System.out.println("Thank you !");
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    // Input Validation
    public static int getValidChoice() {
        while (!sc.hasNextInt()) {
            System.out.print("Invalid input! Enter a number: ");
            sc.next();
        }
        return sc.nextInt();
    }

    // Initialize flights
    public static void initializeFlights() {
        flights.add(new Flight(101, "Mumbai", "Delhi", 50, 4500));
        flights.add(new Flight(102, "Delhi", "Chennai", 40, 5000));
        flights.add(new Flight(103, "Bangalore", "Kolkata", 45, 5500));
        flights.add(new Flight(104, "Hyderabad", "Mumbai", 35, 4000));
        flights.add(new Flight(105, "Pune", "Goa", 60, 2500));
    }

    // View Flights
    public static void viewFlights() {
        System.out.println("\n===== AVAILABLE FLIGHTS =====");
        for (Flight f : flights) {
            System.out.println("Flight: " + f.flightNumber +
                    " | " + f.origin + " → " + f.destination +
                    " | Seats: " + f.seatsAvailable +
                    " | Price: ₹" + f.price);
        }
    }

    // Search flights
    public static void searchFlights() {
        sc.nextLine();
        System.out.print("Enter origin: ");
        String origin = sc.nextLine();

        System.out.print("Enter destination: ");
        String destination = sc.nextLine();

        boolean found = false;

        System.out.println("\nAvailable Flights:");
        for (Flight f : flights) {
            if (f.origin.equalsIgnoreCase(origin) &&
                f.destination.equalsIgnoreCase(destination) &&
                f.seatsAvailable > 0) {

                System.out.println("Flight Number: " + f.flightNumber +
                        " | Price: ₹" + f.price +
                        " | Seats: " + f.seatsAvailable);

                found = true;
            }
        }

        if (!found) System.out.println("No matching flights found.");
    }

    // Book a flight
    public static void bookFlight() {
        sc.nextLine();
        System.out.print("Enter passenger name: ");
        String name = sc.nextLine();

        System.out.print("Enter contact number: ");
        String contact = sc.nextLine();

        System.out.print("Enter flight number: ");
        int flightNo = Integer.parseInt(sc.nextLine());

        Flight chosen = null;

        for (Flight f : flights) {
            if (f.flightNumber == flightNo && f.seatsAvailable > 0) {
                chosen = f;
                break;
            }
        }

        if (chosen == null) {
            System.out.println("Invalid flight number or no seats available!");
            return;
        }

        System.out.println("\nFlight Found!");
        System.out.println("From: " + chosen.origin + " → " + chosen.destination);
        System.out.println("Ticket Price: ₹" + chosen.price);
        System.out.print("Proceed to book (yes/no)? ");

        String confirm = sc.nextLine();
        if (!confirm.equalsIgnoreCase("yes")) {
            System.out.println("Booking cancelled.");
            return;
        }

        chosen.seatsAvailable--;

        String bookingId = "AIR" + (bookings.size() + 1);

        Booking b = new Booking(bookingId, name, contact, chosen.flightNumber,
                                chosen.origin, chosen.destination, chosen.price);

        bookings.add(b);

        System.out.println("\nBooking Successful!");
        System.out.println("Your Booking ID: " + bookingId);
    }

    // Cancel booking
    public static void cancelBooking() {
        sc.nextLine();
        System.out.print("Enter Booking ID to cancel: ");
        String id = sc.nextLine();

        Booking found = null;
        for (Booking b : bookings) {
            if (b.bookingId.equalsIgnoreCase(id)) {
                found = b;
                break;
            }
        }

        if (found == null) {
            System.out.println("No booking found!");
            return;
        }

        bookings.remove(found);

        // Increase seat count again
        for (Flight f : flights) {
            if (f.flightNumber == found.flightNumber) {
                f.seatsAvailable++;
            }
        }

        System.out.println("Booking cancelled successfully!");
    }

    // View all bookings
    public static void viewAllBookings() {
        if (bookings.isEmpty()) {
            System.out.println("No bookings available.");
            return;
        }

        System.out.println("\n===== ALL BOOKINGS =====");
        for (Booking b : bookings) {
            System.out.println("ID: " + b.bookingId +
                    " | Name: " + b.passengerName +
                    " | Flight: " + b.flightNumber +
                    " | From: " + b.origin + " → " + b.destination +
                    " | Paid: ₹" + b.amountPaid);
        }
    }

    // Save bookings to file
    public static void saveBookingsToFile() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(file))) {
            for (Booking b : bookings) pw.println(b);
        } catch (Exception e) {
            System.out.println("Error saving file.");
        }
    }

    // Load bookings from file
    public static void loadBookingsFromFile() {
        if (!file.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] p = line.split(",");

                Booking b = new Booking(
                        p[0], p[1], p[2],
                        Integer.parseInt(p[3]),
                        p[4], p[5],
                        Double.parseDouble(p[6])
                );

                bookings.add(b);

                for (Flight f : flights) {
                    if (f.flightNumber == b.flightNumber)
                        f.seatsAvailable--;
                }
            }

        } catch (Exception e) {
            System.out.println("Error loading file.");
        }
    }
}
