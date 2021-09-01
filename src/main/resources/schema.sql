DROP TABLE IF EXISTS TBL_EMPLOYEES;
  
create table prices(Brand_Id,Start_Date,End_Date,Price_List,Product_Id,Priority,Price,Currency,Last_Update,Last_Update_By) as 
select convert( BrandId, bigint), parseDateTime(StartDate, 'yyyy-MM-dd-hh.mm.ss'), parseDateTime(EndDate, 'yyyy-MM-dd-hh.mm.ss'), convert(PriceList, bigint), 
convert(ProductId, bigint), convert(Priority, bigint), convert(Price, numeric), Currency, parseDateTime(LastUpdate, 'yyyy-MM-dd-hh.mm.ss'), LastUpdateBy 
from CSVREAD( 'classpath:prices.csv')