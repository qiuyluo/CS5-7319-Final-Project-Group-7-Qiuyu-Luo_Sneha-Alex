-- create tables

CREATE TABLE books (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255),
    author VARCHAR(255),
    genre VARCHAR(255),
    topic VARCHAR(255),
    coverImage VARCHAR(255)
);

CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    userId VARCHAR(255) UNIQUE,
    password VARCHAR(255),
    role VARCHAR(255) CHECK (role IN ('USER', 'LIBRARIAN'))
);

CREATE TABLE holds (
    id SERIAL PRIMARY KEY,
    user_id INTEGER REFERENCES users(id),
    book_id INTEGER REFERENCES books(id),
    holdDate DATE,
    isReadyToPickup BOOLEAN
);

-- Initialize users table
INSERT INTO users(userid, password, role) VALUES('Lucy', '123', 'USER');
INSERT INTO users(userid, password, role) VALUES('librarian', '123', 'LIBRARIAN');

-- Initialize books table
INSERT INTO books(title, author, genre, topic) VALUES('The Great Gatsby', 'F. Scott Fitzgerald', 'Novel', 'A story about the mysterious millionaire Jay Gatsby.');
INSERT INTO books(title, author, genre, topic) VALUES('Moby Dick', 'Herman Melville', 'Novel', 'The story of Captain Ahab''s quest to avenge the whale.');
INSERT INTO books(title, author, genre, topic) VALUES('To Kill a Mockingbird', 'Harper Lee', 'Novel', 'A novel about racism in the American South.');
INSERT INTO books(title, author, genre, topic) VALUES('1984', 'George Orwell', 'Novel', 'Dystopian society and surveillance.');
INSERT INTO books(title, author, genre, topic) VALUES('Brave New World', 'Aldous Huxley', 'Novel', 'Dystopian future and technological control.');
INSERT INTO books(title, author, genre, topic) VALUES('Pride and Prejudice', 'Jane Austen', 'Novel', 'Romance and social commentary in early 19th century England.');
INSERT INTO books(title, author, genre, topic) VALUES('Sense and Sensibility', 'Jane Austen', 'Novel', 'The lives and loves of the Dashwood sisters.');
INSERT INTO books(title, author, genre, topic) VALUES('Jane Eyre', 'Charlotte Brontë', 'Novel', 'Gothic romance and social criticism.');
INSERT INTO books(title, author, genre, topic) VALUES('Wuthering Heights', 'Emily Brontë', 'Novel', 'A tragic love story set on the Yorkshire moors.');
INSERT INTO books(title, author, genre, topic) VALUES('The Catcher in the Rye', 'J.D. Salinger', 'Novel', 'A teenager''s critique of adult hypocrisy.');
INSERT INTO books(title, author, genre, topic) VALUES('The Hobbit', 'J.R.R. Tolkien', 'Fantasy', 'The adventure of Bilbo Baggins in a fantasy world.');
INSERT INTO books(title, author, genre, topic) VALUES('The Lord of the Rings', 'J.R.R. Tolkien', 'Fantasy', 'The epic quest to destroy the One Ring.');
INSERT INTO books(title, author, genre, topic) VALUES('The Chronicles of Narnia', 'C.S. Lewis', 'Fantasy', 'Children discover a magical world where they become heroes.');
INSERT INTO books(title, author, genre, topic) VALUES('Fahrenheit 451', 'Ray Bradbury', 'Dystopian', 'A future where books are banned and burned.');
INSERT INTO books(title, author, genre, topic) VALUES('The Handmaid''s Tale', 'Margaret Atwood', 'Dystopian', 'A woman''s struggle in a repressive theocratic society.');
INSERT INTO books(title, author, genre, topic) VALUES('The Road', 'Cormac McCarthy', 'Dystopian', 'A father and son travel through a post-apocalyptic world.');
INSERT INTO books(title, author, genre, topic) VALUES('A Tale of Two Cities', 'Charles Dickens', 'Historical Novel', 'The turmoil of the French Revolution.');
INSERT INTO books(title, author, genre, topic) VALUES('War and Peace', 'Leo Tolstoy', 'Historical Novel', 'A narrative of families during the Napoleonic wars.');
INSERT INTO books(title, author, genre, topic) VALUES('Crime and Punishment', 'Fyodor Dostoevsky', 'Philosophical Novel', 'The psychological impact of crime on the criminal.');
INSERT INTO books(title, author, genre, topic) VALUES('Animal Farm', 'George Orwell', 'Political Satire', 'An allegory about the rise of Stalinism.');
INSERT INTO books(title, author, genre, topic) VALUES('Catch-22', 'Joseph Heller', 'Satire', 'Absurdities of war and military life.');
INSERT INTO books(title, author, genre, topic) VALUES('Beloved', 'Toni Morrison', 'Historical Novel', 'The effects of slavery in post-Civil War America.');
INSERT INTO books(title, author, genre, topic) VALUES('Life of Pi', 'Yann Martel', 'Adventure Fiction', 'A boy''s survival tale at sea with a Bengal tiger.');


-- Initialize holds table
INSERT INTO holds(user_id, book_id, hold_date, is_ready_to_pickup) VALUES(1, 1, current_date, false);
INSERT INTO holds(user_id, book_id, hold_date, is_ready_to_pickup) VALUES(1, 2, current_date, false);



