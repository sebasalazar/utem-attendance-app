BEGIN TRANSACTION;

-- DROP CONSTRAINT IF EXISTS per_rut_uidx;
DROP TABLE IF EXISTS persons CASCADE;
CREATE TABLE persons (
    pk bigserial NOT NULL,
    rut bigint NOT NULL,
    name varchar(255) NOT NULL,
    created timestamptz NOT NULL DEFAULT NOW(),
    updated timestamptz NOT NULL DEFAULT NOW(),
    PRIMARY KEY (pk)
);
CREATE UNIQUE INDEX per_rut_uidx ON persons(rut);
INSERT INTO persons (rut,name) VALUES (12111111,'Juan Perez');


DROP TABLE IF EXISTS rooms CASCADE;
CREATE TABLE rooms (
    pk bigserial NOT NULL,
    code varchar(255) NOT NULL,
    created timestamptz NOT NULL DEFAULT NOW(),
    updated timestamptz NOT NULL DEFAULT NOW(),
    PRIMARY KEY (pk)
);
CREATE UNIQUE INDEX rms_code_uidx ON rooms(UPPER(code));
INSERT INTO rooms (code) VALUES ('LAB01');



DROP TABLE IF EXISTS attendances CASCADE;
CREATE TABLE attendances (
    pk bigserial NOT NULL,
    person_fk bigint NOT NULL,
    room_fk bigint NOT NULL,
    attendance_date timestamptz NOT NULL,
    created timestamptz NOT NULL DEFAULT NOW(),
    updated timestamptz NOT NULL DEFAULT NOW(),
    FOREIGN KEY (person_fk) REFERENCES persons(pk) ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (room_fk) REFERENCES rooms(pk) ON UPDATE CASCADE ON DELETE CASCADE,
    PRIMARY KEY (pk)
);

COMMIT;