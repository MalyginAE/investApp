CREATE TABLE IF NOT EXISTS chats
(
    id
    BIGSERIAL
    PRIMARY
    KEY,
    chat_id
    BIGSERIAL
    NOT
    NULL
    UNIQUE
);
CREATE TABLE IF NOT EXISTS subscribers_telegram_bot
(
    id BIGSERIAL PRIMARY KEY,
    user_name VARCHAR UNIQUE,
    first_name
    VARCHAR,
    last_name VARCHAR,
    chat_id BIGSERIAL REFERENCES chats(id)
    )
;

CREATE TABLE IF NOT EXISTS message_to_bot_from_user
(
    id BIGSERIAL PRIMARY KEY,
    message
    VARCHAR,
    date
    DATE,
    subscriber_id
    BIGSERIAL
    REFERENCES
    subscribers_telegram_bot
(
    id
)
    );