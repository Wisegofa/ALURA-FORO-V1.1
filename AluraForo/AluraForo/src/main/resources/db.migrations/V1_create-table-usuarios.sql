CREATE TABLE IF NOT EXISTS usuarios(
                                       id BIGINT AUTO_INCREMENT,
                                       nombre VARCHAR(150) NOT NULL,
    email  VARCHAR(100) NOT NULL UNIQUE,
    contrasena VARCHAR(200) NOT NULL,
    tipo VARCHAR(30) NOT NULL,
    PRIMARY KEY(id)
    )ENGINE=InnoDB DEFAULT CHARSET=UTF8;