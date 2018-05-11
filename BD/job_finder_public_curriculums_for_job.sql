CREATE TABLE public.curriculums_for_job
(
    job_id integer NOT NULL,
    curriculum_id integer NOT NULL,
    CONSTRAINT fkf9l89mn1qculuyc62fhp1ev75 FOREIGN KEY (job_id) REFERENCES job_opportunities (id),
    CONSTRAINT fk8xvf7m8ns0ny6s6djp3srdqbs FOREIGN KEY (curriculum_id) REFERENCES curriculums (id)
);