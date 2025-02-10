1. Create Employee API
   ======================
   Endpoint:
   POST http://localhost:8080/employees
   Headers: Content-Type: application/json

Sample JSON Request Body 1:
{
"id": 1,
"firstName": "Barack",
"lastName": "Obama",
"salary": 55000.00
}

Expected Response : "Employee added successfully"

Sample JSON Request Body 2:
{
"id": 2,
"firstName": "Joe",
"lastName": "Bidden",
"salary": 72000.00
}

Sample JSON Request Body 3:
{
"id": 3,
"firstName": "Murugan",
"lastName": "K",
"salary": 60000.00
}

2. Get Employee by Id API
   ========================
   Retrieve employees’ details by Id

Example:
GET http://localhost:8080/employees/1
{
"id": 1,
"firstName": "Barack",
"lastName": "Obama",
"salary": 55000.0
}



G3. et Employees API
====================
 The query parameters are optional (name & fromSalary & toSalary)
 If the name parameter is passed, the api should search for all employees that their first name or last name contains
the search text.
 If fromSalary or toSalary or both passed, consider the following.
• fromSalary only  Retrieve all employees who have salary >= fromSalary
• toSalary only  Retrieve all employees who have salary <= toSalary
• Both  Retrieve all employees who have salary between fromSalary and toSalary inclusive.

Base URL
http://localhost:8080/employees

1. Get All Employees (No Filters)  
   GET http://localhost:8080/employees This will return all employees stored in the JSON file.
   Example :
   [
   {
   "id": 1,
   "firstName": "Barack",
   "lastName": "Obama",
   "salary": 55000.0
   },
   {
   "id": 2,
   "firstName": "Joe",
   "lastName": "Bidden",
   "salary": 72000.0
   },
   {
   "id": 3,
   "firstName": "Murugan",
   "lastName": "K",
   "salary": 60000.0
   }
   ]
2. Get Employees by Name (First Name or Last Name)
   Request URL: GET http://localhost:8080/employees?name=Barack : This will return employees whose first name contains "
   Barack".

   [
   {
   "id": 1,
   "firstName": "Barack",
   "lastName": "Obama",
   "salary": 55000.0
   }
   ]

   Request URL: GET http://localhost:8080/employees?name=Bidden : This will return employees whose last name contains "
   Bidden".

   [
   {
   "id": 2,
   "firstName": "Joe",
   "lastName": "Bidden",
   "salary": 72000.0
   }
   ]

3.Get Employees by Minimum Salary (fromSalary)

Request URL: GET http://localhost:8080/employees?fromSalary=60000 : This will return all employees who have a salary ≥
60000.

    [
    {
        "id": 2,
        "firstName": "Joe",
        "lastName": "Bidden",
        "salary": 72000.0
    },
    {
        "id": 3,
        "firstName": "Murugan",
        "lastName": "Swami",
        "salary": 60000.0
    }

]

4. Get Employees by Maximum Salary (toSalary)
   Request URL: GET http://localhost:8080/employees?toSalary=60000 : This will return all employees who have a salary ≤
   60000.

   [
   {
   "id": 1,
   "firstName": "Barack",
   "lastName": "Obama",
   "salary": 55000.0
   },
   {
   "id": 3,
   "firstName": "Murugan",
   "lastName": "Swami",
   "salary": 60000.0
   }

]

5. Get Employees Within a Salary Range (fromSalary & toSalary)

Request URL: GET http://localhost:8080/employees?fromSalary=55000&toSalary=70000 : This will return all employees who
have a salary between 55000 and 70000.

    [
    {
        "id": 1,
        "firstName": "Barack",
        "lastName": "Obama",
        "salary": 55000.0
    },
    {
        "id": 3,
        "firstName": "Murugan",
        "lastName": "Swami",
        "salary": 60000.0
    }

]

