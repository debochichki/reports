CREATE TABLE IF NOT EXISTS game_rounds
(
    id                     BIGINT PRIMARY KEY AUTO_INCREMENT,
    player                 VARCHAR(200) NOT NULL,
    bet_amount             BIGINT NOT NULL,
    win_amount             BIGINT NOT NULL,
    currency               VARCHAR(3) NOT NULL
);

INSERT INTO game_rounds (player, bet_amount, win_amount, currency) VALUES
('George', 100, 200, 'EUC'), ('Hans', 70, 30, 'MAR'), ('Stoyan', 50, 100, 'SOL'),
('George', 75, 0, 'EUC'), ('Hans', 90, 0, 'MAR'), ('Stoyan', 50, 0, 'SOL'),
('George', 50, 245, 'EUC'), ('Hans', 70, 0, 'MAR'), ('Stoyan', 50, 150, 'SOL'),
('George', 25, 55, 'EUC'), ('Hans', 70, 3500, 'MAR'), ('Stoyan', 50, 700, 'SOL'),
('George', 25, 0, 'EUC'), ('Hans', 135, 0, 'MAR'), ('Stoyan', 50, 0, 'SOL');