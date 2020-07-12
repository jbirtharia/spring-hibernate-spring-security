

create table users (
       id integer not null auto_increment,
        enabled bit,
        password varchar(255),
        username varchar(255),
        primary key (id)
    ) engine=InnoDB;



create table authorities (
       id integer not null auto_increment,
        authority varchar(255),
        username varchar(255),
        userId integer,
        primary key (id)
    ) engine=InnoDB;


alter table authorities
       add constraint FK29qa4y05balt07ma4ajfsqqrm
       foreign key (userId)
       references users (id);



insert into users values (1,'jayendra','{noop}123',true);
insert into users values (2,'dhoni','{noop}123',true);
insert into users values (3,'sachin','{noop}123',true);

insert into authorities values (1,'EMPLOYEE','jayendra',1);
insert into authorities values (2,'ADMIN','jayendra',1);
insert into authorities values (3,'EMPLOYEE','dhoni',2);
insert into authorities values (4,'EMPLOYEE','sachin',3);
insert into authorities values (5,'MANAGER','sachin',3);