# CalculatorGUI

A **simple, classic calculator** built with **Java Swing**.  
CalculatorGUI supports **basic arithmetic operations** and formats numbers with **thousands separators** for easier readability.

---

## Features

- Classic, clean, and simple UI  
- Supports basic operations: **addition (+), subtraction (-), multiplication (*), division (/)**  
- All operation buttons in a single row  
- Input and output numbers are displayed with **thousands separators**  
- Handles **decimal numbers** and **negative numbers**  
- **Error handling**:
  - Empty input → "Both fields are required!"  
  - Non-numeric input → "Invalid number!"  
  - Division by zero → "Cannot divide by zero!"  
- Clear button (`C`) resets all fields; color slightly different for better visibility  

---

## Input & Output Limits

| Feature | Limit |
|---------|-------|
| Input type | `double` |
| Maximum input | ±1.7 × 10^308 |
| Minimum input | ±4.9 × 10^-324 |
| Decimal precision | up to 15–16 digits |
| Output format | Thousands separator, up to 8 decimal places |
| Division by zero | Error message displayed |

---

## How to Run

1. Make sure you have **Java JDK installed** (version 8 or higher).  
2. Open **Command Prompt** (Windows) or **Terminal** (Mac/Linux).  
3. Navigate to the project folder:

```bash
cd path/to/CalculatorGUI
```


### How to Run

```bash
javac CalculatorGUI.java
```


### Run the program:

```bash
java CalculatorGUI
```