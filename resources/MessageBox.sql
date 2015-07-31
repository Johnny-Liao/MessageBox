drop database if exists MessageBox;
create database MessageBox;

use MessageBox;

drop table if exists m_user;
drop table if exists m_admin;
drop table if exists message;
drop table if exists natice;

-- �û�
create table m_user (		
	u_id varchar(10) primary key,
	u_name varchar(10) not null, 
	u_password varchar(18) not null	
);

-- ����Ա
create table m_admin (	
	a_id varchar(10) primary key,
	a_name varchar(10) not null, 
	a_password varchar(18) not null
);

-- ���Ա�
create table message (
	m_name varchar(10),
	theme varchar(10),		
	email varchar(50),
	address varchar(20),
	picture varchar(100),
	qq varchar(20),
	myhome varchar(60),
	message varchar(300),
	admonly varchar(5),			-- ����0��1
	m_time varchar(20),
	m_level int auto_increment primary key
);			
-- �����
create table natice (
	n_name varchar(10),
	title varchar(10),
	content varchar(300),
	n_time varchar(60)
);

insert into m_user values('123456','�������','123456');
insert into m_user values('hahaha','������','123456');
insert into m_admin values('admin','������','admin');

select* from m_user;
select* from m_admin;
select* from message;
select* from natice;