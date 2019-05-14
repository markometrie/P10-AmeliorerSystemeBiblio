--ALTER TABLE utilisateur ADD CONSTRAINT ac_pseudo UNIQUE (pseudo, email);

--ALTER TABLE utilisateur DROP CONSTRAINT ac_pseudo;

ALTER TABLE utilisateur ADD CONSTRAINT ac_email UNIQUE (email);

