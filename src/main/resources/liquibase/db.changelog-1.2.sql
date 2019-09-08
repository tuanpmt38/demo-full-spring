-- liquibase formatted sql
-- changeset tuanpm:1.2

DROP TABLE IF EXISTS author;

CREATE TABLE author(
    id serial,
    name VARCHAR (255) NOT NULL,
    created_at TIMESTAMP default null ,
    updated_at TIMESTAMP default null,
    created_by BIGINT default null ,
    updated_by BIGINT default null,
    is_active bool default true,
    is_deleted bool default false,
    PRIMARY KEY (id)
)
