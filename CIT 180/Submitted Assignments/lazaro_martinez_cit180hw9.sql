--q1:
SELECT ROUND(AVG(Shipping), 2) AS "Average Shipping Cost"
FROM Sale
WHERE EXTRACT(MONTH from SaleDate) = 6;

--q2:
SELECT SUM(Quantity * ListPrice) AS "Total"
FROM Product p
JOIN SaleItem si ON si.ProductID = p.ProductID
JOIN Sale s ON s.SaleID = si.SaleID
WHERE CustomerID = 144;

--q3:
SELECT MAX(SalePrice * Quantity) AS "LargestItemSale"
FROM SaleItem;

--q4:
SELECT Category, Color, MAX(ListPrice) AS "Maximum Price"
FROM Product
WHERE Gender = 'M'
GROUP BY Category, Color
ORDER BY Category;

--q5:
SELECT ProductName, ListPrice
FROM Product
WHERE ProductID in
    (SELECT ProductID FROM SaleItem WHERE SaleID in
        (SELECT SaleID FROM Sale WHERE Shipping > 60));

--q6:
SELECT COUNT(ProductID)
FROM Product
WHERE ManufacturerID IN
    (SELECT ManufacturerID
    FROM Manufacturer
    WHERE State = 'CA');

--q7:
CREATE VIEW MenShoesNJ AS
SELECT ProductName, Color, ListPrice
FROM REDCAT.Product p
JOIN REDCAT.Manufacturer m ON m.ManufacturerID = p.ManufacturerID
WHERE Gender = 'M' AND State = 'NJ';

--q8:
SELECT AVG(ListPrice)
FROM MenShoesNJ
WHERE LOWER(Color) = LOWER('Black');