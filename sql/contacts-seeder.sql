USE blog_db;
INSERT INTO contacts (email, name) VALUES
                                       ('justin@email.com', 'Justin'),
                                       ('laura@email.com', 'Laura'),
                                       ('audrey@email.com', 'Audrey'),
                                       ('steve@email.com', 'Steve');
truncate blogs;
truncate users;
drop table blogs;
drop table users;