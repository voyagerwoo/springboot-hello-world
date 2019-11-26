create table if not exists book (
    id bigint NOT NULL AUTO_INCREMENT,
    author varchar(255),
    isbn varchar(255),
    name varchar(255),
    published_date timestamp,
    publisher varchar(255),
    primary key (id)
)