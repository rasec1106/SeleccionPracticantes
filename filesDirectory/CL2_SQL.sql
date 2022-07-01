use CL2 
GO
/*
	PREGUNTA 01-a
*/
INSERT INTO Producto
(nomPro, unidadMedida, precioUnitario, descontinuado)
VALUES
('Inka Kola','500 ml', '2.00', '0');
GO
/*
	PREGUNTA 01-b
*/
--Para este caso se adaptó el txt para cumplir con los requisitos de la tabla
/*
ABCD1,IMPORTACIONES ROMERO SAC,Jr Piura 206,Lima,PERU
ABCD2,COMERCIAL MODERNA SRL,Calle Los Cedros 3365,Lima,PERU
ABCD3,DISTRIBUIDORA UNIVERSAL SAC,Avenida La Marina 4089,Lima,PERU
*/
bulk insert Cliente
from 'C:\Users\Adminzeit\Desktop\CL2_BDA_HerreraVillacortaCesarHumberto\registros.txt'
with(FieldTerminator=',',RowTerminator='\n')
go
/*
set identity_insert Cliente on;
select * from Cliente
INSERT INTO Cliente
(codCli, nomCli, dirCli, ciudadCli, paisCli)
VALUES
('ABCD1','IMPORTACIONES ROMERO SAC','Jr Piura 206','Lima','PERU'),
('ABCD2','COMERCIAL MODERNA SRL','Calle Los Cedros 3365','Lima','PERU'),
('ABCD3','DISTRIBUIDORA UNIVERSAL SAC','Avenida La Marina 4089','Lima','PERU');
GO*/
/*
	PREGUNTA 01-c
*/
--Crear la tabla TempCliente--
CREATE TABLE [dbo].[TempCliente](
	[codCli] [nchar](5) NOT NULL,
	[nomCli] [nvarchar](40) NOT NULL,
	[dirCli] [nvarchar](60) NULL,
	[ciudadCli] [nvarchar](15) NULL,
	[paisCli] [nvarchar](15) NULL,
 CONSTRAINT [PK_TempCliente] PRIMARY KEY CLUSTERED 
(
	[codCli] ASC
)
) ON [PRIMARY]
GO
--Insertar 4 registros--
INSERT INTO TempCliente
SELECT TOP (4) *
FROM Cliente
ORDER BY codCli DESC

SELECT * FROM TempCliente
--Registros en PEDIDO--
SELECT * FROM Pedido
/*
	PREGUNTA 01-d
*/
insert Pedido (nroPed, codCli, codEmp,codTran, flete, total) values
(11078,'ABCD1', 1, 2, 152.3, 400), 
(11079,'ABCD2', 4, 2, 29.8, 355.5), 
(11080,'ABCD3', 7, 2, 8.8, 1250)
go

Select * from Pedido
go

--2da Pregunta--
Select codCli,dirCli,ciudadCli,paisCli into ClienteT from Cliente --copiar tabla con columnas personalizadas
go
-- select * from Cliente
-- select * from ClienteT
/*
	PREGUNTA 02-a
*/
Select codCli,dirCli,ciudadCli,paisCli into ClienteT from Cliente
begin
	declare @codigo char(5),@direc nvarchar(60), @ciudad nvarchar(15), @pais nvarchar(15)
	set @codigo='BERGS'
	set @direc='Av La Paz nro 2577'
	set @ciudad='Lima'
	set @pais='Peru'
	merge ClienteT as target
	using (select @codigo,@direc,@ciudad,@pais) as source(codCli,dirCli,ciudadCli,paisCli)
	on (source.codCli=target.codCli)
	when matched then 
		update set target.ciudadCli=source.ciudadCli,
			   target.dirCli=source.dirCli,
			   target.paisCli=source.paisCli			   
	when not matched then
		insert values(source.codCli,source.dirCli,source.ciudadCli,source.paisCli);
end

Select * from ClienteT
go

/*
	PREGUNTA 02-b
*/
UPDATE Producto 
SET precioUnitario= precioUnitario*1.5 
WHERE codCate=1

SELECT * FROM Producto WHERE codCate=1

/*
	PREGUNTA 02-c
*/
-- Renueve el código del TRANSPORTISTA (codTran) a “1” solo para la fecha de orden sean del año 1996 en la tabla Pedidos.
SELECT * FROM Pedido
WHERE YEAR(fechaPedido) = 1996
/*
	PREGUNTA 02-c
*/
UPDATE Pedido
SET codTran=1
WHERE YEAR(fechaPedido) = 1996

-- Aumente el stock de los productos si el precio del producto esté en el rango de 20 a 50.
SELECT * FROM Producto
WHERE precioUnitario >=20 
AND precioUnitario <= 50
/*
	PREGUNTA 02-d
*/
-- Aumentamos el stock en 50 unidades
UPDATE Producto
SET stock = stock + 50
WHERE precioUnitario >=20 
AND precioUnitario <= 50

/*
	PREGUNTA 03
*/
Select codPro, nomPro, stock into Producto_QA from Producto
begin
	declare @codigo int ,@nombre nvarchar(40)
	set @codigo=30
	set @nombre='Inka Kola'
	merge Producto_QA as target
	using (select @codigo,@nombre) as source(codPro,nomPro)
	on (source.codPro=target.codPro)
	when matched and stock <= 0 then 
		delete		   
	when matched then
		update SET nomPro = @nombre;
end

SELECT * FROM Producto_QA

/*
	NOTA: Si se desea copiar la tabla con TODOS sus registros podemos utilizar el siguiente codigo
*/
SELECT * into Cliente2 FROM Cliente
/*
	NOTA: Podemos usar este artificio para evitar crear la tabla con DDL
*/
SELECT * into Cliente3 FROM Cliente WHERE codCli IS NULL
SELECT * FROM Cliente3

Select * from Categorias
Select * from Cliente
Select * from Empleado
Select * from Pedido
Select * from PedidoDetalle
Select * from Producto
Select * from Transportista
/*
	PREGUNTA 04
*/
-- Mostrar por cada empleado del pais de UK, la suma del importe total de los pedidos que posean mas de 20 productos vendidos 
-- cuyas ventas fueron realizadas en 1996 ordenados de mayor a menor
SELECT p.codEmp, e.apeEmp, e.nomEmp, SUM(p.total) as 'importe total de Ventas 1996'
FROM Pedido p
JOIN Empleado e on e.codEmp=p.codEmp
WHERE e.Pais = 'UK'
AND p.nroPed IN (
	SELECT nroPed 
	FROM PedidoDetalle
	GROUP BY nroPed
	HAVING SUM(cantidad) >= 50
)
AND DATEPART(year,p.fechaPedido) = 1996
GROUP BY p.codEmp,e.apeEmp, e.nomEmp
ORDER BY SUM(p.total) ASC

