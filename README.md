# ✈️ Plane Management System

A comprehensive Java-based airline seat reservation system that manages aircraft seating, ticket booking, and passenger information. The system provides an interactive console interface for airline staff to handle seat reservations, cancellations, and passenger management.

## ✨ Key Features

🎫 **Seat Booking Management**
- Interactive seat selection with row (A-D) and seat number
- Real-time seat availability checking
- Automatic price calculation based on seat location
- Duplicate booking prevention

💰 **Dynamic Pricing System**
- **Premium seats (1-5)**: £200
- **Standard seats (6-9)**: £150  
- **Economy seats (10+)**: £180

👤 **Passenger Information System**
- Complete passenger details collection (name, surname, email)
- Secure data storage and retrieval
- Ticket generation with passenger information

📊 **Comprehensive Reporting**
- Visual seating plan display (O = Available, X = Occupied)
- Total sales calculation and reporting
- Individual ticket information lookup
- Complete booking history

💾 **File Management**
- Automatic ticket file generation (e.g., `A1.txt`, `B5.txt`)
- Persistent storage of booking details
- Error handling for file operations

🔍 **Advanced Search & Management**
- Find first available seat functionality
- Search specific tickets by seat location
- Cancel existing reservations
- Real-time seat status updates

## 🛠️ Built With

| Technology | Purpose |
|------------|---------|
| **Java 8+** | Core programming language |
| **ArrayList** | Dynamic ticket storage |
| **Scanner** | User input handling |
| **File I/O** | Ticket data persistence |
| **Exception Handling** | Input validation and error management |

## 🚀 How to Run

### 🧑‍💻 Prerequisites
- Java Development Kit (JDK) 8 or higher
- Any Java IDE (IntelliJ IDEA, Eclipse, VS Code) or command line

### Installation & Usage

1. **Clone or download the project files:**
```bash
git clone [your-repository-url]
cd plane-management-system
```

2. **Compile the Java files:**
```bash
javac PlaneManagement.java Person.java Ticket.java
```

3. **Run the application:**
```bash
java PlaneManagement
```

4. **Follow the interactive menu:**
```
****************************************************
*                   Menu Options                   *
****************************************************

        1) Buy a seat
        2) Cancel a seat
        3) Find first available seat
        4) Show seating plan
        5) Print tickets information and total sales
        6) Search ticket
        0) Quit
*****************************************************
```

## 🏗️ System Architecture

### Aircraft Configuration
```
Row A: 14 seats (A1-A14)
Row B: 12 seats (B1-B12)  
Row C: 12 seats (C1-C12)
Row D: 14 seats (D1-D14)
Total: 52 seats
```

### Class Structure
```
PlaneManagement/
├── PlaneManagement.java     # Main application controller
├── Person.java              # Passenger data model
├── Ticket.java              # Ticket management and file operations
└── Generated ticket files/  # Auto-generated booking records
    ├── A1.txt
    ├── B5.txt
    └── ...
```

## 📋 Core Functionality

### 🎫 Booking Process
1. **Seat Selection**: Choose row (A-D) and seat number
2. **Availability Check**: System verifies seat availability
3. **Passenger Details**: Enter name, surname, and email
4. **Price Calculation**: Automatic pricing based on seat location
5. **Confirmation**: Ticket generated and saved to file

### 📊 Seating Plan Visualization
```
Example Output:
Aircraft Seating Plan

XXXXXXXXXXXXXX    (Row A - 14 seats)
OOOOXXXXXXXX      (Row B - 12 seats)
XXXXXXXXXXOO      (Row C - 12 seats)  
OOOOOOXXXXXXXX    (Row D - 14 seats)

Legend: O = Available, X = Occupied
```

### 🔍 Search & Management
- **Quick Search**: Find tickets by seat location
- **First Available**: Automatically locate next open seat
- **Cancellation**: Remove bookings and update availability
- **Sales Report**: Complete financial summary with passenger details

## 🛡️ Input Validation

- **Row Validation**: Accepts only A, B, C, D (case-insensitive)
- **Seat Number Validation**: Ensures seat exists in selected row
- **Duplicate Prevention**: Blocks booking of occupied seats
- **Input Type Checking**: Handles non-integer inputs gracefully
- **Exception Handling**: Comprehensive error management

## 📄 File Output Format

Each ticket generates a file named `[ROW][SEAT].txt`:
```
Ticket and Person Information.

Row: A
Seat: 1
Price: 200.0
Name: John
Surname: Doe
Email: john.doe@email.com
```

## 🔧 Error Handling

- **Invalid Menu Options**: Prompts for valid selection
- **File I/O Errors**: Graceful handling of file operation failures
- **Input Mismatches**: Clear error messages for invalid data types
- **Boundary Checks**: Prevents out-of-range seat selections

## 🎯 Use Cases

- **Airlines**: Small to medium aircraft seat management
- **Travel Agencies**: Booking system integration
- **Event Management**: Venue seating arrangements
- **Educational**: Object-oriented programming demonstration

