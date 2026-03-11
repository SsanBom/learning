CREATE TABLE books (
    id BIGSERIAL PRIMARY KEY,
    title varchar(255) NOT NULL,
    genre varchar(100) NOT NULL,
    year INTEGER NOT NULL,
    pages INTEGER NOT NULL
);