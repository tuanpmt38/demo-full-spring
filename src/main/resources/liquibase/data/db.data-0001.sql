-- liquibase formatted sql
-- changeset tuanpm:0001

INSERT INTO news (content, image_url, created_at, updated_at, is_active)
VALUES ('News1', 'https://www.24h.com.vn', now(), now(), true),
       ('News2', 'https://www.24h.com.vn', now(), now(), true),
       ('News3', 'https://www.24h.com.vn', now(), now(), true),
       ('News4', 'https://www.24h.com.vn', now(), now(), true),
       ('News5', 'https://www.24h.com.vn', now(), now(), true),
       ('News6', 'https://www.24h.com.vn', now(), now(), true)
