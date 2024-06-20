CREATE TABLE PET_OWNER
(
    owner_id   BIGINT PRIMARY KEY,
    owner_name VARCHAR(100) NOT NULL
);

CREATE TABLE PET
(
    id                 UUID PRIMARY KEY,
    owner_id           BIGINT       NOT NULL,
    weight             BIGINT       NOT NULL,
    breed              VARCHAR(100) NOT NULL,
    vaccination_status BOOLEAN      NOT NULL,
    training_level     SMALLINT     NOT NULL,
    CONSTRAINT fk_owner
        FOREIGN KEY (owner_id)
            REFERENCES PET_OWNER (owner_id)
);

-- PET_OWNER Mock data
INSERT INTO PET_OWNER (owner_id, owner_name)
VALUES (101020203030, 'John Doe'),
       (112233445588, 'Jane Smith');

-- PET_INFORMATION Mock data
INSERT INTO PET (id, owner_id, weight, breed, vaccination_status, training_level)
VALUES (gen_random_uuid(), 101020203030, 20, 'Golden Retriever', true, 3),
       (gen_random_uuid(), 112233445588, 15, 'Beagle', false, 1);

INSERT INTO PET (id, owner_id, weight, breed, vaccination_status, training_level)
VALUES (gen_random_uuid(), 101020203030, 20, 'Golden 2', true, 4),
       (gen_random_uuid(), 112233445588, 15, 'Beagle', false, 1);

INSERT INTO PET (id, owner_id, weight, breed, vaccination_status, training_level)
VALUES (gen_random_uuid(), 101020203030, 20, 'Golden 3', true, 9),
       (gen_random_uuid(), 112233445588, 15, 'Beagle', false, 1);