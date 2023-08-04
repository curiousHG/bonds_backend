import pandas as pd
from faker import Faker
import random

# Create a Faker object to generate random data
fake = Faker()

# Function to generate random data for the User table
def generate_users(num_users):
    users = []
    for _ in range(num_users):
        user = {
            'User ID': fake.uuid4(),
            'Name': fake.name(),
            'Email': fake.email(),
            'Role': random.choice(['Administrator', 'Trader', 'Analyst'])
        }
        users.append(user)
    return users

# Function to generate random data for the Book table
def generate_books(num_books):
    books = []
    for _ in range(num_books):
        book = {
            'Book ID': fake.uuid4(),
            'BookName': fake.catch_phrase()
        }
        books.append(book)
    return books

# Function to generate random data for the BookUser table
def generate_book_users(num_book_users, books, users):
    book_users = []
    for _ in range(num_book_users):
        book = random.choice(books)
        user = random.choice(users)
        book_user = {
            'Book ID': book['Book ID'],
            'User ID': user['User ID']
        }
        book_users.append(book_user)
    return book_users

# Function to generate random data for the Trade table
def generate_trades(num_trades, books, users, counterparties, securities):
    trades = []
    for _ in range(num_trades):
        book = random.choice(books)
        counterparty = random.choice(counterparties)
        security = random.choice(securities)
        trade = {
            'Trade ID': fake.uuid4(),
            'Book ID': book['Book ID'],
            'Counterparty ID': counterparty['Counterparty ID'],
            'Security ID': security['Security ID'],
            'Quantity': random.randint(1, 100),
            'Status': random.choice(['Pending', 'Completed']),
            'Price': random.uniform(50, 200),
            'Buy_Sell': random.choice(['Buy', 'Sell']),
            'TradeDate': fake.date_time_between(start_date='-30d', end_date='now'),
            'Settlement Date': fake.date_time_between(start_date='now', end_date='+30d')
        }
        trades.append(trade)
    return trades

# Function to generate random data for the Security table
def generate_securities(num_securities):
    securities = []
    for _ in range(num_securities):
        security = {
            'Security ID': fake.uuid4(),
            'ISIN': fake.isbn10(),
            'CUSIP': fake.isbn13(),
            'Issuer': fake.company(),
            'MaturityDate': fake.date_between(start_date='+30d', end_date='+5y'),
            'Coupon': random.uniform(0.5, 10),
            'Type': random.choice(['Stock', 'Bond', 'ETF']),
            'FaceValue': random.uniform(1000, 100000),
            'Status': random.choice(['Active', 'Inactive'])
        }
        securities.append(security)
    return securities

# Function to generate random data for the Counterparty table
def generate_counterparties(num_counterparties):
    counterparties = []
    for _ in range(num_counterparties):
        counterparty = {
            'Counterparty ID': fake.uuid4(),
            'Name': fake.company()
        }
        counterparties.append(counterparty)
    return counterparties

# Generating random data for each table
num_users = 5
num_books = 10
num_book_users = 15
num_trades = 20
num_securities = 8
num_counterparties = 4

users = generate_users(num_users)
books = generate_books(num_books)
book_users = generate_book_users(num_book_users, books, users)
securities = generate_securities(num_securities)
counterparties = generate_counterparties(num_counterparties)
trades = generate_trades(num_trades, books, users, counterparties, securities)

# Create dataframes from the generated data
users_df = pd.DataFrame(users)
books_df = pd.DataFrame(books)
book_users_df = pd.DataFrame(book_users)
securities_df = pd.DataFrame(securities)
counterparties_df = pd.DataFrame(counterparties)
trades_df = pd.DataFrame(trades)

# Optionally, you can save the data to CSV files if needed
users_df.to_csv('users.csv', index=False)
books_df.to_csv('books.csv', index=False)
book_users_df.to_csv('book_users.csv', index=False)
securities_df.to_csv('securities.csv', index=False)
counterparties_df.to_csv('counterparties.csv', index=False)
trades_df.to_csv('trades.csv', index=False)
