--q1: Zhang, Yoon
SELECT FirstName, LastName
FROM REDCAT.SALE s
JOIN REDCAT.CUSTOMER c ON c.CustomerID = s.CustomerID
WHERE LOWER(State) = LOWER('MN')
ORDER BY LastName DESC;;

--q2: Florence Rodhain
SELECT DISTINCT FirstName || ' ' || LastName AS Full_Name --CONCAT(CONCAT(FirstName, ' '), LastName)
FROM CUSTOMER
WHERE LOWER(LastName) LIKE LOWER('__D%');

--q3:
SELECT * 
FROM REDCAT.SALE
WHERE Tax > 0
AND (Tax + Shipping) < 15;

--q4:
SELECT SaleDate AS "Date of Sale", (Tax + Shipping) AS SUM --I hope this is correct but it returned zero records
FROM redcat.sale
WHERE SaleDate BETWEEN DATE '2021-12-20' AND DATE '2021-12-25';

--q5:
SELECT ManufacturerName, City
FROM Manufacturer
WHERE LOWER(City) LIKE LOWER('C%');

--q6:
SELECT ProductName
FROM Product p
JOIN Manufacturer m ON m.ManufacturerID = p.ManufacturerID
WHERE State = 'WA';

--q7:
SELECT c.FirstName, c.LastName
FROM Customer c
JOIN Sale s ON s.CustomerID = c.CustomerID
JOIN Product p ON p.ProductID = s.ProductID
WHERE State = 'IL'
AND (Price > 100
OR Category = 'flats');

--q8:
SELECT we.Wage, 
e.FirstName,
e.LastName,
e.HireDate,
m.FirstName AS MgrFirstN,
m.LastName AS MgrLastN
FROM REDCAT.Employee e
JOIN REDCAT.Employee m ON m.EmployeeID = e.ManagerID
JOIN REDCAT.WageEmployee we ON we.EmployeeID = e.EmployeeID;

--q9:
SELECT ProductName, ListPrice
FROM REDCAT.Product p
JOIN REDCAT.SaleItem si ON si.ProductID = p.ProductID
JOIN REDCAT.Sale s ON s.SaleID = si.SaleID
WHERE SaleDate = DATE '2015-02-15';

--q10: 3 records
SELECT DISTINCT e.FirstName, e.LastName
FROM REDCAT.Employee e
JOIN REDCAT.Purchase pu ON pu.EmployeeID = e.EmployeeID
JOIN REDCAT.Manufacturer m ON m.ManufacturerID = pu.ManufacturerID
JOIN REDCAT.Product pr ON pr.ManufacturerID = m.ManufacturerID
JOIN REDCAT.SaleItem si ON si.ProductID = pr.ProductID
JOIN REDCAT.Sale s ON s.SaleID = si.SaleID
JOIN REDCAT.Customer c ON c.CustomerID = s.CustomerID
WHERE ManufacturerName = 'Timberland';
