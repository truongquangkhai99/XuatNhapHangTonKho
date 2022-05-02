﻿Create database Assigment
go
use Assigment
go


CREATE TABLE ACCOUNT(
USERNAME   NVARCHAR(100) PRIMARY KEY,
PASSWORD   NVARCHAR(100),
ROLE       NVARCHAR(10),
)
go
INSERT ACCOUNT VALUES ('ThuKho','202cb962ac59 75b964b 7152d234b70',N'Thủ Kho')
INSERT ACCOUNT VALUES ('QuanLy','202cb962ac59 75b964b 7152d234b70',N'Quản lý')
go
SELECT*FROM ACCOUNT
------------------------------------------------------------------------//
-----------------------------------------------------------------------//
CREATE TABLE CATEGORY(
CATEGORYID   INT PRIMARY KEY IDENTITY(1,1),
CATEGORYNAME NCHAR(20)
)
INSERT  CATEGORY VALUES ('QUAN')
INSERT CATEGORY VALUES ('AO')
GO
select*from CATEGORY
-----------------------------------------------------------------------//
-----------------------------------------------------------------------//


CREATE TABLE CLOTHES(
ID             INT PRIMARY KEY IDENTITY(1,1),
CATEGORYID     INT,
PRODUCTNAME    NCHAR(20),
CURRENTPRICE   money,
QUANTITY       INT,
COLOR          NCHAR(15),
SIZE           NCHAR(5),
IDLIST         BIT
)
ALTER TABLE CLOTHES ADD FOREIGN KEY (CATEGORYID) REFERENCES CATEGORY(CATEGORYID)
INSERT CLOTHES VALUES (1,N'Quần Jeans','200000','3','Xanh','XL',1)
INSERT CLOTHES VALUES (2,N'Áo Sweater','100000','3',N'Trắng','XL',1)
INSERT CLOTHES VALUES (1,N'Quần Kaki','200000','3',N'Nâu','XL',1)
INSERT CLOTHES VALUES (1,N'Quần bò','0.1','3',N'Nâu','XL',1)
INSERT CLOTHES VALUES (2,N'Quần sock','0.1','3',N'Nâu','XL',0)
select*From CLOTHES

-----------------------------------------------------------------------//
-----------------------------------------------------------------------//

CREATE TABLE INVENTORYLOG(
PRODUCTID  INT,
IEDATE     DATETIME,
IOE        BIT,
QUANTITY   INT,
PRICE      money,
PRIMARY KEY(PRODUCTID,IEDATE)
)
ALTER TABLE INVENTORYLOG ADD FOREIGN KEY (PRODUCTID) REFERENCES CLOTHES(ID)




--------------------------------
SELECT*FROM INVENTORYLOG 
SELECT*FROM CLOTHES
--3 sản phẩm có doanh thu cao nhất tháng, kèm số lượng và doanh thu



go
declare @bang table
(  PRODUCTID INT,
   PRICE     FLOAT,
   QUANTITY  INT
)
INSERT @BANG 
select TOP 3 PRODUCTID,sum(price),sum(quantity) from
INVENTORYLOG where ioe=0 
group by PRODUCTID,ABS( MONTH(GETDATE())-MONTH(IEDATE))
ORDER BY ABS( MONTH(GETDATE())-MONTH(IEDATE)) ASC
declare @bang2  table
(
   PRODUCTID INT,
   PRICE     money,
   QUANTITY1  INT,
   CATEGORYNAME nchar(10),
   PRODUCTNAME nchar(30),
   CURRENTPRICE Float,
   QUANTITY  INT,
   COLOR    NCHAR(20),
   SIZE     NCHAR(10),
   IOE      BIT,
   IEDATE   DATE
)
INSERT  @bang2
SELECT B.PRODUCTID,B.PRICE,B.QUANTITY,CG.CATEGORYNAME,CL.PRODUCTNAME,
CL.CURRENTPRICE,CL.QUANTITY, CL.COLOR,CL.SIZE, IG.IOE,IG.IEDATE FROM CLOTHES CL  
JOIN @BANG B         ON B.PRODUCTID = CL.ID
join INVENTORYLOG IG ON B.PRODUCTID =IG.PRODUCTID
join CATEGORY CG  ON CG.CATEGORYID=CL.CATEGORYID
where cl.IDLIST=1 and ioe =0
SELECT PRODUCTID, SUM(PRICE),SUM(QUANTITY1),CATEGORYNAME,PRODUCTNAME,
CURRENTPRICE,QUANTITY,COLOR,SIZE,IOE FROM @bang2
GROUP BY  PRODUCTID, PRICE,QUANTITY1,CATEGORYNAME,PRODUCTNAME,
CURRENTPRICE,QUANTITY,COLOR,SIZE,IOE 
ORDER BY SUM(PRICE) DESC



select CL.PRODUCTNAME,IEDATE, IV.IOE, IV.QUANTITY,
IV.PRICE FROM INVENTORYLOG IV JOIN CLOTHES CL ON 
CL.ID= IV.PRODUCTID order by IEDATE DESC

declare @bang table
 (  PRODUCTID INT,
   PRICE     money,
    QUANTITY  INT
  )
INSERT @BANG
select TOP 3 PRODUCTID,sum(price),sum(quantity) from
 INVENTORYLOG where ioe=0 
 group by PRODUCTID,ABS( MONTH(GETDATE())-MONTH(IEDATE))
 ORDER BY ABS( MONTH(GETDATE())-MONTH(IEDATE)) ASC
 SELECT B.PRODUCTID,B.PRICE,B.QUANTITY,CG.CATEGORYNAME,CL.PRODUCTNAME,
 CL.CURRENTPRICE,CL.QUANTITY, CL.COLOR,CL.SIZE, IG.IOE,IG.IEDATE FROM CLOTHES CL 
 JOIN @BANG B ON B.PRODUCTID = CL.ID
 join INVENTORYLOG IG ON B.PRODUCTID =IG.PRODUCTID
join CATEGORY CG  ON CG.CATEGORYID=CL.CATEGORYID
 where cl.IDLIST=1
ORDER BY IEDATE DESC

drop table INVENTORYLOG
drop table CLOTHES

SELECT*FROM INVENTORYLOG






--2222222222222222222222222222222
declare @bang table
(  PRODUCTID INT,
   PRICE     FLOAT,
   QUANTITY  INT
)
INSERT @BANG 
select TOP 3 PRODUCTID,sum(price),sum(quantity) from
INVENTORYLOG where ioe=0
group by PRODUCTID,PRICE,ABS( MONTH(GETDATE())-MONTH(IEDATE))
having ABS( MONTH(GETDATE())-MONTH(IEDATE))=0
ORDER BY sum(price) DESC
declare @bang2  table
(
   PRODUCTID INT,
   PRICE     money,
   QUANTITY1  INT,
   CATEGORYNAME nchar(10),
   PRODUCTNAME nchar(30),
   CURRENTPRICE Float,
   QUANTITY  INT,
   COLOR    NCHAR(20),
   SIZE     NCHAR(10),
   IOE      BIT,

)
INSERT  @bang2
SELECT B.PRODUCTID,B.PRICE,B.QUANTITY,CG.CATEGORYNAME,CL.PRODUCTNAME,
CL.CURRENTPRICE,CL.QUANTITY, CL.COLOR,CL.SIZE, IG.IOE,IG.IEDATE FROM CLOTHES CL  
JOIN @BANG B         ON B.PRODUCTID = CL.ID
join INVENTORYLOG IG ON B.PRODUCTID =IG.PRODUCTID
join CATEGORY CG  ON CG.CATEGORYID=CL.CATEGORYID
where cl.IDLIST=1 and ioe =0
SELECT PRODUCTID, SUM(PRICE),SUM(QUANTITY1),CATEGORYNAME,PRODUCTNAME,
CURRENTPRICE,QUANTITY,COLOR,SIZE,IOE FROM @bang2
GROUP BY  PRODUCTID, PRICE,QUANTITY1,CATEGORYNAME,PRODUCTNAME,
CURRENTPRICE,QUANTITY,COLOR,SIZE,IOE 
ORDER BY SUM(PRICE) DESC

--nnnnnnnnnnnnnnnnnnnnnn
declare @bang table
(  PRODUCTID INT,
   PRICE     FLOAT,
   QUANTITY  INT
)
INSERT @BANG 
select TOP 3 PRODUCTID,sum(price),sum(quantity) from
INVENTORYLOG where ioe=0
group by PRODUCTID,PRICE,ABS( MONTH(GETDATE())-MONTH(IEDATE))
having ABS( MONTH(GETDATE())-MONTH(IEDATE))=0
ORDER BY sum(price) DESC
declare @bang2  table
(
   PRODUCTID INT,
   PRICE     money,
   QUANTITY1  INT,
   CATEGORYNAME nchar(10),
   PRODUCTNAME nchar(30),
   CURRENTPRICE Float,
   QUANTITY  INT,
   COLOR    NCHAR(20),
   SIZE     NCHAR(10),
   IOE      BIT

)
INSERT  @bang2
SELECT B.PRODUCTID,B.PRICE,B.QUANTITY,CG.CATEGORYNAME,CL.PRODUCTNAME,
CL.CURRENTPRICE,CL.QUANTITY, CL.COLOR,CL.SIZE, IG.IOE FROM CLOTHES CL  
JOIN @BANG B         ON B.PRODUCTID = CL.ID
join INVENTORYLOG IG ON B.PRODUCTID =IG.PRODUCTID
join CATEGORY CG  ON CG.CATEGORYID=CL.CATEGORYID
where cl.IDLIST=1 and ioe =0
group by  B.PRODUCTID,B.PRICE,B.QUANTITY,CG.CATEGORYNAME,CL.PRODUCTNAME,
CL.CURRENTPRICE,CL.QUANTITY, CL.COLOR,CL.SIZE, IG.IOE
ORDER BY SUM(b.PRICE) DESC
select*from @bang2 order by PRICE desc
