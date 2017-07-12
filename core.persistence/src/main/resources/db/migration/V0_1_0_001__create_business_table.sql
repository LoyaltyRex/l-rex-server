CREATE TABLE public.business
(
    id uuid NOT NULL,
    name text COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT business_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.business OWNER to lrex;