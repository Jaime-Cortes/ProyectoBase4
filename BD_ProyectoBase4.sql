use proyectobase4;
create table categoria(
	idCategoria int not null primary key auto_increment,
    nombreCategoria varchar(50) not null,
    descripcionCategoria varchar(150) not null
);

create table articulo(
	idArticulo int primary key auto_increment, 
    nombre varchar(50), 
    cantidad int,
    precio float, 
    idCategoria int,
    foreign key(idCategoria) references Categoria(idCategoria) on delete cascade
);

/*Categoria PA*/
delimiter **
create procedure spInsertar(nom varchar(50), descrip varchar(150))
begin
	insert into categoria(nombreCategoria, descripcionCategoria) values(nom, descrip);
end **
delimiter ;

delimiter **
create procedure spActualizar(id int, nom varchar(50), descrip varchar(50))
begin
	update categoria set nombreCategoria=nom, descripcionCategoria=descrip where idCategoria=id;
end **
delimiter ;

delimiter **
create procedure spEliminar(id int)
begin 
	delete from categoria where idCategoria = id;
end **
delimiter ;

delimiter **
create procedure spSeleccionarUno(id int)
begin
	select * from categoria where idCategoria = id;
end **
delimiter ; 

delimiter **
create procedure spSeleccionarTodo()
begin 
	select * from categoria;
end **
delimiter ;
/**/

/*Articulo PA*/
delimiter **
create procedure spInsertarA(nombre varchar(50), cantidad int, precio float, idCategoria int)
begin
	insert into articulo(nombre, cantidad, precio, idCategoria) values(nombre, cantidad, precio, idCategoria);
end **
delimiter ;

delimiter **
create procedure spActualizarA(id int, nombre varchar(50), cantidad int, precio float, idCategoria int)
begin
	update articulo set nombre=nombre, cantidad=cantidad, precio=precio, idCategoria=idCategoria where idArticulo=id;
end **
delimiter ;

delimiter **
create procedure spEliminarA(id int)
begin 
	delete from articulo where idArticulo = id;
end **
delimiter ;

delimiter **
create procedure spSeleccionarUnoA(id int)
begin
	select * from articulo where idArticulo  = id;
end **
delimiter ; 

delimiter **
create procedure spSeleccionarTodoA()
begin 
	select * from articulo;
end **
delimiter ;

/**/