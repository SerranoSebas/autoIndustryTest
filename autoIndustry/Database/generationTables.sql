-- This script was generated by a beta version of the ERD tool in pgAdmin 4.
-- Please log an issue at https://redmine.postgresql.org/projects/pgadmin4/issues/new if you find any bugs, including reproduction steps.
BEGIN;


CREATE TABLE IF NOT EXISTS public.inventory
(
    id bigint NOT NULL,
    created_date date,
    quantity integer,
    updated_date date,
    id_product bigint,
    id_user bigint,
    CONSTRAINT inventory_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.products
(
    id bigint NOT NULL,
    name character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT products_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.users
(
    id bigint NOT NULL,
    age integer,
    created_date date,
    lastname character varying(255) COLLATE pg_catalog."default",
    name character varying(255) COLLATE pg_catalog."default",
    "position" character varying(255) COLLATE pg_catalog."default",
    updated_date date,
    CONSTRAINT users_pkey PRIMARY KEY (id)
);

ALTER TABLE IF EXISTS public.inventory
    ADD CONSTRAINT fkhswsc1325j491ecwn05kiso20 FOREIGN KEY (id_user)
    REFERENCES public.users (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;


ALTER TABLE IF EXISTS public.inventory
    ADD CONSTRAINT fkmx3pes0uhrr0qn5veeype1j56 FOREIGN KEY (id_product)
    REFERENCES public.products (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;

END;