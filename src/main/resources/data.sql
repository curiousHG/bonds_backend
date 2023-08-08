INSERT INTO BOOK (id, BOOK_NAME) VALUES (1, 'Introduction to AI');
INSERT INTO BOOK (id, BOOK_NAME) VALUES (2, 'Database Management');
INSERT INTO BOOK (id, BOOK_NAME) VALUES (3, 'Data Structures');
INSERT INTO BOOK (id, BOOK_NAME) VALUES (4, 'Machine Learning');
INSERT INTO BOOK (id, BOOK_NAME) VALUES (5, 'Networking');
INSERT INTO BOOK (id, BOOK_NAME) VALUES (6, 'Operating Systems');
INSERT INTO BOOK (id, BOOK_NAME) VALUES (7, 'OOP');
INSERT INTO BOOK (id, BOOK_NAME) VALUES (8, 'Mathematics');
INSERT INTO BOOK (id, BOOK_NAME) VALUES (9, 'Python');
INSERT INTO BOOK (id, BOOK_NAME) VALUES (10, 'Physics');
INSERT INTO BOOK (id, BOOK_NAME) VALUES (11, 'Chemistry');
INSERT INTO BOOK (id, BOOK_NAME) VALUES (12, 'English');
INSERT INTO BOOK (id, BOOK_NAME) VALUES (13, 'History');
INSERT INTO BOOK (id, BOOK_NAME) VALUES (14, 'Geography');
INSERT INTO BOOK (id, BOOK_NAME) VALUES (15, 'Civics');



INSERT INTO users (id, name, email, photo, password, role)
VALUES
    (101, 'John Doe', 'john.doe@email.com', 'test', 'test', 'Regular User'),
    (102, 'Jane Smith', 'jane.smith@email.com', 'test','test','Admin'),
    (103, 'Mike Brown', 'mike.brown@email.com', 'test','test','Regular User'),
    (104, 'Emily Lee', 'emily.lee@email.com', 'test','test','Regular User'),
    (105, 'Alex Chen', 'alex.chen@email.com', 'test','test','Regular User'),
    (106, 'Mohinder Laine', 'mohinder.laine@email.com', 'test','test','Admin'),
    (107, 'Bran Sulzbach', 'bran.sulzbach@email.com', 'test','test','Admin'),
    (108, 'Slavko Doherty', 'slavko.doherty@email.com', 'test','test','Regular User'),
    (109, 'Sally Sebastiani', 'sally.sebastiani@email.com', 'test','test','Regular User'),
    (110, 'Layla Caiazzo', 'layla.caiazzo@email.com', 'test','test','Regular User'),
    (111, 'Augusts Nyman', 'augusts.nyman@email.com', 'test','test','Admin'),
    (112, 'Ara Palomer', 'ara.palomer@email.com', 'test','test','Regular User'),
    (113, 'Oskar Boyadjiev', 'oskar.boyadjiev@email.com', 'test','test','Regular User'),
    (114, 'Madhuri Joshi', 'madhuri.joshi@email.com', 'test','test','Regular User'),
    (115, 'Devi Kaur', 'devi.kaur@email.com', 'test','test','Regular User');



INSERT INTO book_user (book_id, user_id)
VALUES
    (1, 101),
    (2, 102),
    (3, 103),
    (1, 104),
    (2, 105),
    (1, 106),
    (1, 107),
    (2, 108),
    (3, 109),
    (1, 110),
    (3, 111),
    (3, 112),
    (1, 113),
    (2, 114),
    (2, 115);



INSERT INTO security (id, ISIN, CUSIP, issuer, maturity_date, coupon, type, face_value, status)
VALUES
    (301, 'US1234567890', '1234567890', 'ABC Corp', '2025-12-31', 4.50, 'Bond', 1000, 'Active'),
    (302, 'US0987654321', '0987654321', 'XYZ Inc', '2028-06-30', 2.75, 'Stock', 600, 'Active'),
    (303, 'US9876543210', '9876543212', 'DEF Ltd', '2030-03-15', 3.20, 'Bond', 500, 'Inactive'),
    (304, 'US0987854213', '9987654323', 'RYZ Inc', '2025-06-30', 3.35, 'Stock', 600, 'Active'),
    (305, 'US6987654271', '1876543214', 'ABZ Inc', '2024-07-25', 2.65, 'Bond', 700, 'Active'),
    (306, 'US0587454121', '2987654325', 'GHI Inc', '2024-04-20', 2.70, 'Stock', 200, 'Active'),
    (307, 'US0888843213', '3987654326', 'PYZ Inc', '2028-05-12', 3.55, 'Stock', 300, 'Inactive'),
    (308, 'US4985554321', '4987654327', 'GVG Inc', '2027-05-13', 2.75, 'Bond', 600, 'Active'),
    (309, 'US3987653321', '5987654328', 'HVG Ltd', '2026-09-15', 3.25, 'Stock', 400, 'Inactive'),
    (310, 'US1967654321', '6987654329', 'VGM Inc', '2025-04-07', 4.75, 'Bond', 100, 'Inactive'),
    (311, 'US2987654321', '7987654310', 'APG Ltd', '2024-03-19', 3.75, 'Stock', 800, 'Active'),
    (312, 'US9987654320', '3987654311', 'VVG Inc', '2025-09-23', 2.75, 'Stock', 600, 'Active'),
    (313, 'US8987654321', '2987654312', 'XPZ Ltd', '2029-07-25', 2.65, 'Bond', 800, 'Active'),
    (314, 'US1987654321', '3987654313', 'VKG Ltd', '2027-02-29', 2.55, 'Stock', 700, 'Active'),
    (315, 'US2987654325', '4987654314', 'ABT Inc', '2026-01-31', 3.75, 'Bond', 800, 'Inactive');


    
INSERT INTO counterparty (id, Name)
VALUES
    (201, 'Alpha Traders'),
    (202, 'Beta Brokers'),
    (203, 'Gamma Corp'),
    (204, 'Delta Corp'),
    (205, 'Alpha Traders'),
    (206, 'Gamma Corp'),
    (207, 'Beta Brokers'),
    (208, 'Delta Corp'),
    (209, 'Gamma Corp'),
    (210, 'Delta Corp'),
    (211, 'Alpha Traders'),
    (212, 'Beta Brokers'),
    (213, 'Gamma Corp'),
    (214, 'Beta Brokers'),
    (215, 'Gamma Corp');
    
INSERT INTO trade (id, book_id, counter_party_id, security_id, quantity, status, price, buy_sell, trade_date, settlement_date)
VALUES
    (1001, 1, 201, 301, 100, 'Completed', 50.00, 'Buy', '2023-08-01', '2023-08-05'),
    (1002, 2, 202, 302, 50, 'Pending', 75.25, 'Sell', '2023-08-02', '2023-08-06'),
    (1003, 3, 203, 303, 200, 'Completed', 30.80, 'Buy', '2023-08-03', '2023-08-07'),
    (1004, 4, 204, 304, 250, 'Pending', 35.70, 'Sell', '2023-08-04', '2023-08-08'),
    (1005, 5, 205, 305, 50, 'Completed', 20.00, 'Sell', '2023-08-05', '2023-08-09'),
    (1006, 6, 206, 306, 100, 'Pending', 10.60, 'Buy', '2023-08-06', '2023-08-10'),
    (1007, 7, 207, 307, 300, 'Pending', 70.20, 'Sell', '2023-08-07', '2023-08-11'),
    (1008, 8, 208, 308, 350, 'Completed', 40.80, 'Sell', '2023-08-08', '2023-08-12'),
    (1009, 9, 209, 309, 250, 'Pending', 30.70, 'Buy', '2023-08-09', '2023-08-13'),
    (1010, 10, 210, 310, 150, 'Completed', 60.90, 'Sell', '2023-08-10', '2023-08-14'),
    (1011, 11, 211, 311, 250, 'Pending', 90.10, 'Buy', '2023-08-11', '2023-08-15'),
    (1012, 12, 212, 312, 270, 'Completed', 50.20, 'Sell', '2023-08-12', '2023-08-16'),
    (1013, 13, 213, 313, 170, 'Pending', 30.10, 'Sell', '2023-08-13', '2023-08-17'),
    (1014, 14, 214, 314, 300, 'Completed', 50.80, 'Buy', '2023-08-14', '2023-08-18'),
    (1015, 15, 215, 315, 150, 'Completed', 60.00, 'Buy', '2023-08-15', '2023-08-19');
