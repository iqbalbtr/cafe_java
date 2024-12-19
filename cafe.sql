CREATE DATABASE cafe_java DEFAULT CHARACTER SET = 'utf8mb4';

DROP ALL TABLE;
USE cafe_java;

CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nama VARCHAR(55) NOT NULL,
    role VARCHAR(30) NOT NULL,
    username VARCHAR(30) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE items (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nama VARCHAR(55) NOT NULL,
    harga INT NOT NULL,
    jenis VARCHAR(30) NOT NULL,
    stock INT NOT NULL,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE transactions (
    id INT AUTO_INCREMENT PRIMARY KEY,
    total INT NOT NULL,
    pembeli VARCHAR(55),
    status ENUM(
        "Disiapkan",
        "Sedang diantar",
        "Selesai"
    ) DEFAULT "Disiapkan",
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE transaction_items (
    id INT AUTO_INCREMENT PRIMARY KEY,
    transactions_id INT NOT NULL,
    qty INT NOT NULL,
    item_id INT NOT NULL,
    sub_total INT NOT NULL,
    FOREIGN KEY (transactions_id) REFERENCES transactions (id) ON DELETE CASCADE,
    FOREIGN KEY (item_id) REFERENCES items (id) ON DELETE CASCADE
);

INSERT INTO
    users (
        nama,
        password,
        role,
        username
    )
VALUES (
        'Admin',
        'admin#123',
        'admin',
        'admin'
    )

SELECT transactions.id, total, buyer, status, users.username
FROM transactions
    INNER JOIN users ON transactions.user_id = users.id

SELECT transaction_items.id, nama, qty, sub_total FROM transaction_items INNER JOIN items ON transaction_items.item_id = 1;