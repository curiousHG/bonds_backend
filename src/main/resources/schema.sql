CREATE TABLE IF NOT EXISTS BOOK(
    id INT PRIMARY KEY,
    BOOK_NAME VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS users (
    id INT PRIMARY KEY,
    photo VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    role VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS book_user (
    book_id INT,
    user_id INT,
    PRIMARY KEY (book_id, user_id),
    FOREIGN KEY (book_id) REFERENCES BOOK(id),
    FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE IF NOT EXISTS security (
    id INT PRIMARY KEY,
    ISIN VARCHAR(50) UNIQUE NOT NULL,
    CUSIP VARCHAR(50) NOT NULL,
    issuer VARCHAR(255) NOT NULL,
    maturity_date DATE NOT NULL,
    coupon DECIMAL(5, 2) NOT NULL,
    type VARCHAR(50) NOT NULL,
    face_value DECIMAL(10, 2) NOT NULL,
    status VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS counterparty (
    id INT PRIMARY KEY,
    Name VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS trade (
    id INT PRIMARY KEY,
    book_id INT,
    counter_party_id INT,
    security_id INT,
    quantity INT NOT NULL,
    status VARCHAR(50) NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    buy_sell VARCHAR(5) NOT NULL,
    trade_date DATE NOT NULL,
    settlement_date DATE NOT NULL,
    FOREIGN KEY (book_id) REFERENCES BOOK(id),
    FOREIGN KEY (counter_party_id) REFERENCES counterparty(id),
    FOREIGN KEY (security_id) REFERENCES security(id)
);


