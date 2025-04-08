import mysql.connector as connection

conn = connection.connect(
    host="localhost",
    user="root",
    password="root",
    database="airbnb"
)

cursor = conn.cursor()

while True:
    print("\n--- MENU ---")
    print("1. INSERT")
    print("2. DELETE")
    print("3. SELECT")
    print("0. EXIT")
    choice = input("Enter choice: ")

    if choice == "1":
        email = input("Enter email: ")
        bio = input("Enter bio: ")
        country = input("Enter country code (e.g., US): ")
        cursor.execute(
            "INSERT INTO Users (email, bio, country) VALUES (%s, %s, %s)",
            (email, bio, country)
        )
        conn.commit()
        print("✅ User inserted.")

    elif choice == "2":
        email = input("Enter email to delete: ")
        cursor.execute(
            "DELETE FROM Users WHERE email = %s",
            (email,)
        )
        conn.commit()
        print("🗑️ User deleted.")

    elif choice == "3":
        cursor.execute("SELECT * FROM Users")
        rows = cursor.fetchall()
        print("\n📋 Current Users:")
        print("ID | Email | Bio | Country")
        for row in rows:
            print(f"{row[0]} | {row[1]} | {row[2]} | {row[3]}")

    elif choice == "0":
        print("👋 Exiting...")
        break

    else:
        print("❌ Invalid choice.")

# Close everything
cursor.close()
conn.close()
