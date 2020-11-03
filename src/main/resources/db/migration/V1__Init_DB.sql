
create table ums.groups (
                            id int8 generated by default as identity,
                            name varchar(255) not null,
                            headman_id int8,
                            primary key (id)
);


create table ums.students (
                              id int8 generated by default as identity,
                              date_of_birth date not null,
                              first_name varchar(255) not null,
                              last_name varchar(255) not null,
                              phone_number varchar(255),
                              group_id int8,
                              primary key (id)
);


create table ums.subjects (
                              id int8 not null,
                              description varchar(200),
                              name varchar(255) not null,
                              primary key (id)
);


create table ums.subjects_teachers (
                                       subject_id int8 not null,
                                       teachers_id int8 not null,
                                       primary key (subject_id, teachers_id)
);


create table ums.teacher (
                             id int8 generated by default as identity,
                             date_of_birth date not null,
                             first_name varchar(255) not null,
                             last_name varchar(255) not null,
                             phone_number varchar(255) not null,
                             primary key (id)
);


alter table if exists ums.groups
    add constraint groups_students_FK
        foreign key (headman_id)
            references ums.students
            ON DELETE SET NULL;


alter table if exists ums.students
    add constraint students_groups_FK
        foreign key (group_id)
            references ums.groups
            ON DELETE SET NULL;


alter table if exists ums.subjects_teachers
    add constraint subjects_teachers_FK
        foreign key (teachers_id)
            references ums.teacher;



alter table if exists ums.subjects_teachers
    add constraint teachers_subjects_FK
        foreign key (subject_id)
            references ums.subjects;


