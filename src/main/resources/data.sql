INSERT INTO BOOK (id, BOOK_NAME) VALUES (1, 'Introduction to AI');
INSERT INTO BOOK (id, BOOK_NAME) VALUES (2, 'Database Management');
INSERT INTO BOOK (id, BOOK_NAME) VALUES (3, 'Data Structures');

INSERT INTO users (id, name, email, role)
VALUES
    (101, 'John Doe', 'john.doe@email.com', 'Regular User'),
    (102, 'Jane Smith', 'jane.smith@email.com', 'Admin'),
    (103, 'Mike Brown', 'mike.brown@email.com', 'Regular User'),
    (104, 'Emily Lee', 'emily.lee@email.com', 'Regular User'),
    (105, 'Alex Chen', 'alex.chen@email.com', 'Regular User');

INSERT INTO book_user (book_id, user_id)
VALUES
    (1, 101),
    (2, 102),
    (3, 103),
    (1, 104),
    (2, 105);

INSERT INTO security (id, ISIN, CUSIP, issuer, maturity_date, coupon, type, face_value, status)
VALUES
    (301, 'US1234567890', '1234567890', 'ABC Corp', '2025-12-31', 4.50, 'Bond', 1000, 'Active'),
    (302, 'US0987654321', '0987654321', 'XYZ Inc', '2028-06-30', 2.75, 'Stock', 600, 'Active'),
    (303, 'US9876543210', '9876543210', 'DEF Ltd', '2030-03-15', 3.20, 'Bond', 500, 'Inactive');

    
INSERT INTO counterparty (id, Name)
VALUES
    (201, 'Alpha Traders'),
    (202, 'Beta Brokers'),
    (203, 'Gamma Corp');
    
INSERT INTO trade (id, book_id, counter_party_id, security_id, quantity, status, price, buy_sell, trade_date, settlement_date)
VALUES
    (1, 1, 201, 301, 100, 'Completed', 50.00, 'Buy', '2023-08-01', '2023-08-05'),
    (2, 2, 202, 302, 50, 'Pending', 75.25, 'Sell', '2023-08-02', '2023-08-06'),
    (3, 3, 203, 303, 200, 'Completed', 30.80, 'Buy', '2023-08-03', '2023-08-07');