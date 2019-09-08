-- liquibase formatted sql
-- changeset tuanpm:1.1

DROP TABLE IF EXISTS news;

CREATE TABLE news(
    id serial,
    content VARCHAR (255) NOT NULL,
    image_url VARCHAR (255) NOT NULL,
    created_at TIMESTAMP default null ,
    updated_at TIMESTAMP default null,
    created_by BIGINT default null ,
    updated_by BIGINT  default null,
    is_active bool default true,
    is_deleted bool default false,
    PRIMARY KEY (id)
)
