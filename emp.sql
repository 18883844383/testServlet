create table t_emp(
    id int primary key auto_increment,
    name varchar(20),
    salary float(7,2),
    age int
)
drop table t_emp
insert into t_emp values(1,'Lisa',3000.00,20)
insert into t_emp values(2,'花儿',3000.00,20)
insert into t_emp values(3,'少年',3000.00,20)
select * from t_emp