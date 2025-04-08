# database-connectivity-session

🚀 How to Run React + MongoDB (MERN Stack)

1️⃣ Create the file: mern/server/config.env  
Add the following content (replace <username> and <password>):
```
ATLAS_URI=mongodb+srv://<username>:<password>@sandbox.jadwj.mongodb.net/
PORT=5050
```

2️⃣ Start the Backend Server:
```
cd mern/server  
npm install  
npm start
```

3️⃣ Start the React Frontend:
```
cd mern/client  
npm install  
npm run dev
```

✅ Your MERN app should now be live on localhost (typically http://localhost:5173 for React and http://localhost:5050 for server).

🚀 How to Run JdbcDemo.java with MySQL in IntelliJ

1️⃣ Open IntelliJ IDEA and create a new **Java Project** (or open your existing project).

2️⃣ Place your `JdbcDemo.java` file inside the `src` folder.

3️⃣ Download MySQL JDBC driver (.jar) from:
https://dev.mysql.com/downloads/connector/j/

4️⃣ Extract the ZIP and locate the JAR file (e.g., mysql-connector-java-8.x.x.jar)

5️⃣ Add the JDBC JAR to your IntelliJ project:
   - Right-click your project → Open **Module Settings**
   - Go to **Libraries** tab → Click **+** → **Java**
   - Select the `.jar` file → Click **OK** and apply changes

6️⃣ In your `JdbcDemo.java`, make sure your DB credentials and database name are correct:
```java
String url = "jdbc:mysql://localhost:3306/airbnb";
String user = "root";
String password = "your_password";
```
7️⃣ Start MySQL server

8️⃣ Run the file

🚀  How to Run python-mysql.py with MySQL

1️⃣ Start MySQL server

2️⃣ Install MySQL connector:
pip install mysql-connector-python

3️⃣ Check DB details in your script:
host="localhost", user="root", password="your_password", database="airbnb"

4️⃣ Run the script:
python python-mysql.py

✅ Should print data from your Users table!


