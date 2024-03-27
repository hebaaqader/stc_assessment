CREATE DATABASE stc_file_manager;

CREATE TABLE IF NOT EXISTS public.permission_group
(
    id integer NOT NULL DEFAULT nextval('permission_group_id_seq'::regclass),
    group_name character varying(100) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT permission_group_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.permission
(
    id integer NOT NULL DEFAULT nextval('permissions_id_seq'::regclass),
    user_email character varying(255) COLLATE pg_catalog."default" NOT NULL,
    permission_level character varying(20) COLLATE pg_catalog."default" NOT NULL,
    group_id integer,
    CONSTRAINT permissions_pkey PRIMARY KEY (id),
    CONSTRAINT permissions_group_id_fkey FOREIGN KEY (group_id)
        REFERENCES public.permission_group (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

CREATE TABLE IF NOT EXISTS public.item
(
    id integer NOT NULL DEFAULT nextval('item_id_seq'::regclass),
    type character varying(20) COLLATE pg_catalog."default" NOT NULL,
    name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    permission_group_id integer,
    parent_id integer,
    CONSTRAINT item_pkey PRIMARY KEY (id),
    CONSTRAINT item_parent_item_id_fkey FOREIGN KEY (parent_id)
        REFERENCES public.item (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID,
    CONSTRAINT item_permission_group_id_fkey FOREIGN KEY (permission_group_id)
        REFERENCES public.permission_group (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

CREATE TABLE IF NOT EXISTS public.file
(
    id integer NOT NULL DEFAULT nextval('files_id_seq'::regclass),
    "binary" bytea NOT NULL,
    item_id integer,
    CONSTRAINT files_pkey PRIMARY KEY (id),
    CONSTRAINT files_item_id_fkey FOREIGN KEY (item_id)
        REFERENCES public.item (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

