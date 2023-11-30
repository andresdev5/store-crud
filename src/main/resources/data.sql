INSERT INTO roles (id, name, description) VALUES (1, 'ADMIN', 'admin role') ON CONFLICT DO NOTHING;
INSERT INTO roles (id, name, description) VALUES (2, 'USER', 'user role') ON CONFLICT DO NOTHING;
INSERT INTO users (id, username, password, email, role_id) VALUES (1, 'admin', '$2a$12$/MZ.Vahjo1gq93oXHUWCPutAvIgX0sWvQuIzVZz30pmzTTFPMdTyi', 'admin@localhost', 1) ON CONFLICT DO NOTHING;
INSERT INTO users (id, username, password, email, role_id) VALUES (2, 'user', '$2a$12$9Wrf.I/sLTjOMlEDXPYq3.THjxeBJS8BSTWHrX5.s2KY0CyTdEpjK', 'user@localhost', 2) ON CONFLICT DO NOTHING;
