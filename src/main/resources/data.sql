INSERT INTO Failure (id,failure_type, name, date, potential_cost, potential_date,
                     status, repair_description)
VALUES (nextval('failure_seq'),'LOW', 'Example Failure', '2024-03-06', 100.00,
        '2024-03-07', 'NEW', 'To be repaired');

INSERT INTO Failure (id, failure_type, name, date, potential_cost, potential_date,
                     status, repair_description)
VALUES (nextval('failure_seq'), 'MILD', 'Second Failure', '2024-03-06', 150.00,
        '2024-03-08', 'NEW', 'To be repaired');

INSERT INTO Failure (id, failure_type, name, date, potential_cost, potential_date,
                     status, repair_description)
VALUES (nextval('failure_seq'), 'HIGH', 'Third Failure', '2024-03-07', 200.00,
        '2024-03-09', 'NEW', 'To be repaired');

INSERT INTO Failure (id, failure_type, name, date, potential_cost, potential_date,
                     status, repair_description)
VALUES (nextval('failure_seq'), 'CRITICAL', 'Fourth Failure', '2024-03-08',
        300.00, '2024-03-10', 'NEW', 'To be repaired');

INSERT INTO Failure (id, failure_type, name, date, potential_cost, potential_date,
                     status, repair_description)
VALUES (nextval('failure_seq'), 'LOW', 'Fifth Failure', '2024-03-09', 120.00,
        '2024-03-11', 'NEW', 'To be repaired');