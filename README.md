Indicaciones Base de Datos:

Nombre de la base de datos: poll_service
Usuario base de datos: "root"
Contraseña base de datos: "";

--------------------------------------------------------

Creación de tablas:

CREATE TABLE candidates (
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    url_image VARCHAR(255)
    shift_time ENUM('DAY', 'AFTERNOON', 'NIGHT') NOT NULL,
	
);

CREATE TABLE votes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    candidate_id INT NOT NULL,
    student_document VARCHAR(10) NOT NULL,
    FOREIGN KEY (candidate_id) REFERENCES candidates(id)
);

------------------------------------------------------------

Datos de Inicialización (Garantizan el funcionamiento del sistema)

INSERT INTO candidates (first_name, last_name, url_image, shift_time) VALUES ('John', 'Doe', 'https://img.freepik.com/free-photo/latin-man-smiling-mockup-psd-cheerful-expression-closeup-portrai_53876-145665.jpg', 'NIGHT');
INSERT INTO candidates (first_name, last_name, url_image, shift_time) VALUES ('Alice', 'Johnson', 'https://img.freepik.com/free-photo/confident-cheerful-young-businesswoman_1262-20881.jpg', 'DAY');
INSERT INTO candidates (first_name, last_name, url_image, shift_time) VALUES ('Bob', 'Smith', 'https://img.freepik.com/premium-photo/hyper-realistic-happiest-indian-handsome-man-chex-shirt-hands-up-isolated-yellow-background_862994-259262.jpg', 'AFTERNOON');

INSERT INTO candidates (first_name, last_name, url_image, shift_time) VALUES ('Charlie', 'Brown', 'https://img.freepik.com/free-photo/young-bearded-man-with-striped-shirt_273609-5677.jpg', 'DAY');
INSERT INTO candidates (first_name, last_name, url_image, shift_time) VALUES ('Diana', 'Prince', 'https://img.freepik.com/free-photo/close-up-portrait-smiling-short-haired-business-woman-white-t-shirt-posing-with-arms-crossed-white-office_197531-10725.jpg', 'NIGHT');
INSERT INTO candidates (first_name, last_name, url_image, shift_time) VALUES ('Eve', 'White', 'https://img.freepik.com/free-photo/young-beautiful-woman-pink-warm-sweater-natural-look-smiling-portrait-isolated-long-hair_285396-896.jpg', 'DAY');

INSERT INTO candidates (first_name, last_name, url_image, shift_time) VALUES ('Frank', 'Castle', 'https://img.freepik.com/free-photo/latin-man-smiling-mockup-psd-cheerful-expression-closeup-portrai_53876-145665.jpg', 'AFTERNOON');
INSERT INTO candidates (first_name, last_name, url_image, shift_time) VALUES ('Grace', 'Hopper', 'https://img.freepik.com/free-photo/portrait-beautiful-young-woman-standing-grey-wall_231208-10760.jpg', 'DAY');
INSERT INTO candidates (first_name, last_name, url_image, shift_time) VALUES ('Hank', 'Pym', 'https://img.freepik.com/free-photo/close-up-portrait-smiling-short-haired-business-woman-white-t-shirt-posing-with-arms-crossed-white-office_197531-10725.jpg', 'NIGHT');
