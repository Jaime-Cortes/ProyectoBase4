use proyectobase4;
create table categoria(
	idCategoria int not null primary key auto_increment,
    nombreCategoria varchar(50) not null,
    descripcionCategoria varchar(150) not null
);

create table articulo(
	idArticulo int primary key, 
    nombre varchar(50), 
    cantidad int,
    precio float, 
    idCategoria int,
    foreign key(idCategoria) references Categoria(idCategoria) on delete cascade
);


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
