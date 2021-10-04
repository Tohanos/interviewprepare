drop table if exists students cascade;

drop sequence if exists student_seq;
create sequence student_seq start 1 increment 1;

create table students
(
    id   int8 not null,
    name varchar(31),
    age  int8 not null,
    primary key (id)
);
