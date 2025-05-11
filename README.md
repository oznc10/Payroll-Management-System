# 📊 Payroll Management System (Java)

This project was developed to demonstrate Object-Oriented Programming (OOP) principles and the use of Generics in Java. The application performs salary calculations and raise operations for different types of employees (full-time and part-time).

---

## 🚀 Features

- 📌 **Abstract Class and Interface Implementation**  
- 📌 **Polymorphism and Inheritance**  
- 📌 **Generics for Type Safety**  
- 📌 **Dynamic Employee Management with ArrayList**  
- 📌 **Salary Calculation and Raise Operations**  

---

## 🛠️ Implemented Classes and Structures

- `Employee` (Abstract Class)  
- `FullTimeEmployee` (Concrete Class - Full-Time Employee)  
- `PartTimeEmployee` (Concrete Class - Part-Time Employee)  
- `Payable` (Interface)  
- `Payroll<T extends Employee>` (Generic Class)  

---

## 📖 Application Scenario

1. Employees are added to the system.  
2. Salaries and working hours are defined for employees.  
3. Salaries are calculated, and total payroll is computed.  
4. Raises are applied, and new salaries are recalculated.  

---

## 🧩 Example Code Usage

```java
Payroll<Employee> payroll = new Payroll<>();
FullTimeEmployee ayse = new FullTimeEmployee("FT01", "Ayşe", 120000);
PartTimeEmployee mehmet = new PartTimeEmployee("PT01", "Mehmet", 50);

mehmet.setHoursWorked(80);

payroll.addEmployee(ayse);
payroll.addEmployee(mehmet);

System.out.println("Total Payroll: " + payroll.calculateTotalPayroll());
## 📅 Project Status

✅ Completed and fully functional.  
🛠️ Possible Improvements:
- Adding a Graphical User Interface (GUI)  
- Implementing file I/O for persistent data storage  
- Adding more employee types  

---

## ✍️ Developer

- **Name:** Ömer ÖZENÇ
- **University:** Akdeniz University  
- **Department:** Computer Engineering  

---

I’m open to all contributions and suggestions! 😊
