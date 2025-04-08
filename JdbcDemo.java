import java.sql.*;
import java.util.Scanner;

public class JdbcDemo {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/airbnb";
        String user = "root";
        String password = "root";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Scanner sc = new Scanner(System.in)) {

            Class.forName("com.mysql.cj.jdbc.Driver");

            int choice;
            do {
                System.out.println("\n--- MENU ---");
                System.out.println("1. INSERT");
                System.out.println("2. DELETE");
                System.out.println("3. SELECT");
                System.out.println("0. EXIT");
                System.out.print("Enter choice: ");
                choice = sc.nextInt();
                sc.nextLine(); // consume newline

                switch (choice) {
                    case 1: // INSERT
                        System.out.print("Enter email: ");
                        String email = sc.nextLine();
                        System.out.print("Enter bio: ");
                        String bio = sc.nextLine();
                        System.out.print("Enter country code: ");
                        String country = sc.nextLine();

                        String insertSQL = "INSERT INTO Users (email, bio, country) VALUES (?, ?, ?)";
                        try (PreparedStatement insertStmt = conn.prepareStatement(insertSQL)) {
                            insertStmt.setString(1, email);
                            insertStmt.setString(2, bio);
                            insertStmt.setString(3, country);
                            insertStmt.executeUpdate();
                            System.out.println("✅ User inserted.");
                        }
                        break;

                    case 2: // DELETE
                        System.out.print("Enter email to delete: ");
                        String emailToDelete = sc.nextLine();
                        String deleteSQL = "DELETE FROM Users WHERE email = ?";
                        try (PreparedStatement deleteStmt = conn.prepareStatement(deleteSQL)) {
                            deleteStmt.setString(1, emailToDelete);
                            deleteStmt.executeUpdate();
                            System.out.println("🗑️ User deleted.");
                        }
                        break;

                    case 3: // SELECT
                        String selectSQL = "SELECT * FROM Users";
                        try (Statement selectStmt = conn.createStatement();
                             ResultSet rs = selectStmt.executeQuery(selectSQL)) {
                            System.out.println("\n📋 Current Users:");
                            System.out.println("ID | Email | Bio | Country");
                            while (rs.next()) {
                                System.out.printf("%d | %s | %s | %s\n",
                                        rs.getInt("id"),
                                        rs.getString("email"),
                                        rs.getString("bio"),
                                        rs.getString("country"));
                            }
                        }
                        break;

                    case 0:
                        System.out.println("👋 Exiting...");
                        break;

                    default:
                        System.out.println("❌ Invalid choice.");
                }
            } while (choice != 0);

        } catch (ClassNotFoundException e) {
            System.out.println("Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("SQL Error.");
            e.printStackTrace();
        }
    }
}
