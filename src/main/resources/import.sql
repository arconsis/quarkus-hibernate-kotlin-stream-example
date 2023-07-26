-- Insert Books
INSERT INTO books (id, title)
VALUES ('17a60aa5-c08d-4f5b-8b59-705a1ae6fd2c', 'Dune');
INSERT INTO books (id, title)
VALUES ('940d048e-dd3b-4ec1-a2e8-ddc896ec9949', 'Java Persistence with Hibernate, Second Edition');


-- Insert Authors
INSERT INTO authors(id, name, birthdate)
VALUES ('54be0c28-eb04-4a38-90ca-eae83a541424', 'Frank Herbert', '1920-10-08');

INSERT INTO authors(id, name)
VALUES ('4a9af4c2-a1a7-49a5-8221-a51a77644e36', 'Christian Bauer');
INSERT INTO authors(id, name)
VALUES ('ca963e56-b5fb-4a32-b2d4-48486310fa87', 'Gavin King');
INSERT INTO authors(id, name)
VALUES ('08d52416-30b3-4296-91d4-7df3d944c134', 'Gary Gregory');




-- Connect Authors and Books
INSERT INTO book_authors(books_id, authors_id)
VALUES ('17a60aa5-c08d-4f5b-8b59-705a1ae6fd2c', '54be0c28-eb04-4a38-90ca-eae83a541424');

INSERT INTO book_authors(books_id, authors_id)
VALUES ('940d048e-dd3b-4ec1-a2e8-ddc896ec9949', '4a9af4c2-a1a7-49a5-8221-a51a77644e36');
INSERT INTO book_authors(books_id, authors_id)
VALUES ('940d048e-dd3b-4ec1-a2e8-ddc896ec9949', 'ca963e56-b5fb-4a32-b2d4-48486310fa87');
INSERT INTO book_authors(books_id, authors_id)
VALUES ('940d048e-dd3b-4ec1-a2e8-ddc896ec9949', '08d52416-30b3-4296-91d4-7df3d944c134');