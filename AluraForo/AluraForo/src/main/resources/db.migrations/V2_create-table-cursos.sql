CREATE TABLE IF NOT EXISTS cursos(
                                     id BIGINT AUTO_INCREMENT,
                                     nombre VARCHAR(100) NOT NULL,
    categoria  VARCHAR(100) NOT NULL,
    PRIMARY KEY(id)
    )ENGINE=InnoDB DEFAULT CHARSET=UTF8;