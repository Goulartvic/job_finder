CREATE TABLE public.users
(
    id integer PRIMARY KEY NOT NULL,
    company varchar(255),
    cpf bigint,
    login varchar(255),
    name varchar(255),
    password varchar(255),
    phone varchar(255),
    curriculum_id integer,
    job_id integer,
    CONSTRAINT fkev4q8s6hjy629c9o1vo83c30a FOREIGN KEY (curriculum_id) REFERENCES curriculums (id),
    CONSTRAINT fkdavewn4gnp715hime2xm7x04c FOREIGN KEY (job_id) REFERENCES job_opportunities (id)
);
CREATE UNIQUE INDEX uk_ow0gan20590jrb00upg3va2fn ON public.users (login);
INSERT INTO public.users (id, company, cpf, login, name, password, phone, curriculum_id, job_id) VALUES (11, 'ddfasd', 99987654321, 'da', 'toiço', '123', '231231', null, null);
INSERT INTO public.users (id, company, cpf, login, name, password, phone, curriculum_id, job_id) VALUES (7, 'teste', 12345678900, 'te', 'teste', '123', '12541531', 15, null);