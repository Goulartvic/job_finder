CREATE TABLE public.job_opportunities
(
    id integer PRIMARY KEY NOT NULL,
    company varchar(255),
    jobstatus integer,
    name varchar(255),
    salary real,
    schedule varchar(255),
    typeofjob integer,
    workplace varchar(255)
);