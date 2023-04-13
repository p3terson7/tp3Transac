CREATE TABLE IF NOT EXISTS UTILISATEUR(
    util_id INTEGER AUTO_INCREMENT,
    util_nom VARCHAR(255),
    util_password VARCHAR(255),
    util_type VARCHAR(255),
    PRIMARY KEY (util_id)
);

CREATE TABLE IF NOT EXISTS CLIENT(
    clt_id INTEGER,
    PRIMARY KEY (clt_id),
    FOREIGN KEY (clt_id) REFERENCES UTILISATEUR(util_id)
);

CREATE TABLE IF NOT EXISTS ATTENDANT(
    at_id INTEGER,
    PRIMARY KEY (at_id),
    FOREIGN KEY (at_id) REFERENCES UTILISATEUR(util_id)
);

CREATE TABLE IF NOT EXISTS EMPLOYE(
    emp_id INTEGER,
    PRIMARY KEY (emp_id),
    FOREIGN KEY (emp_id) REFERENCES UTILISATEUR(util_id)
);

CREATE TABLE IF NOT EXISTS AMENDE(
    amende_id INTEGER AUTO_INCREMENT,
    amende_clt_id INTEGER,
    amende_cout DOUBLE NOT NULL,
    amende_paid BOOLEAN,
    PRIMARY KEY (amende_id),
    FOREIGN KEY (amende_clt_id) REFERENCES CLIENT(clt_id)
);

CREATE TABLE IF NOT EXISTS DOCUMENT(
    doc_id INTEGER AUTO_INCREMENT,
    doc_titre VARCHAR(255),
    doc_auteur VARCHAR(30),
    doc_annee INTEGER,
    doc_nb_copies INTEGER,
    doc_type VARCHAR(255) NOT NULL,
    PRIMARY KEY (doc_id)
);

CREATE TABLE IF NOT EXISTS EMPRUNT(
    emprunt_id INTEGER AUTO_INCREMENT,
    emprunt_clt_id INTEGER,
    emprunt_doc_id INTEGER,
    emprunt_date DATE NOT NULL,
    emprunt_date_echeance DATE NOT NULL,
    emprunt_returned BOOLEAN,
    PRIMARY KEY (emprunt_id),
    FOREIGN KEY (emprunt_clt_id) REFERENCES CLIENT(clt_id),
    FOREIGN KEY (emprunt_doc_id) REFERENCES DOCUMENT(doc_id)
);

CREATE TABLE IF NOT EXISTS DVD(
    dvd_id INTEGER,
    dvd_duree INTEGER,
    PRIMARY KEY (dvd_id),
    FOREIGN KEY (dvd_id) REFERENCES DOCUMENT(doc_id)
);

CREATE TABLE IF NOT EXISTS CD(
    cd_id INTEGER,
    cd_duree VARCHAR(255),
    PRIMARY KEY (cd_id),
    FOREIGN KEY (cd_id) REFERENCES DOCUMENT(doc_id)
);

CREATE TABLE IF NOT EXISTS LIVRE(
    livre_id INTEGER,
    livre_editeur VARCHAR(255),
    livre_nb_pages INTEGER,
    livre_genre VARCHAR(255),
    PRIMARY KEY (livre_id),
    FOREIGN KEY (livre_id) REFERENCES DOCUMENT(doc_id)
);
