-- Tabela de Usuários
CREATE TABLE Usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    senha VARCHAR(255) NOT NULL,
    perfil VARCHAR(20) NOT NULL,
    codigo_verificacao VARCHAR(6),
    data_criacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    data_expiracao DATE,
    data_atualizacao DATETIME
);

-- Tabela de Posts
CREATE TABLE Posts (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(200) NOT NULL,
    conteudo TEXT NOT NULL,
    data_publicacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    usuario_id INT,
    FOREIGN KEY (usuario_id) REFERENCES Usuarios(id) ON DELETE CASCADE
);

-- Tabela de Comentários
CREATE TABLE Comentarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    conteudo TEXT NOT NULL,
    data_comentario TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    usuario_id INT,
    post_id INT,
    FOREIGN KEY (usuario_id) REFERENCES Usuarios(id) ON DELETE CASCADE,
    FOREIGN KEY (post_id) REFERENCES Posts(id) ON DELETE CASCADE
);

-- Tabela de Categorias
CREATE TABLE Categorias (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL UNIQUE
);

-- Tabela de Posts_Categorias (tabela associativa para relacionamento muitos-para-muitos)
CREATE TABLE Posts_Categorias (
    post_id INT,
    categoria_id INT,
    PRIMARY KEY (post_id, categoria_id),
    FOREIGN KEY (post_id) REFERENCES Posts(id) ON DELETE CASCADE,
    FOREIGN KEY (categoria_id) REFERENCES Categorias(id) ON DELETE CASCADE
);
