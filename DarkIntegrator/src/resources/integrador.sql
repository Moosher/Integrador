CREATE TABLE Motorista (
  MotoristaID NUMBER CONSTRAINT PK_Motorista PRIMARY KEY,
  MotoristaNome VARCHAR(45) NOT NULL UNIQUE,
  MotoristaDataNascimento DATE,
  MotoristaEndereco VARCHAR(200),
  MotoristaTipoCNH VARCHAR(5),
  MotoristaNumCNH NUMBER,
  MotoristaStatus CHAR(1) NOT NULL
);
  
CREATE TABLE VeiculoTipo (
  VeiculoTipoID NUMBER CONSTRAINT PK_VeiculoTipo PRIMARY KEY,
  VeiculoTipoDescricao VARCHAR(45),
  VeiculoTipoCapacidade NUMBER(*,2)
);

CREATE TABLE Usuario (
  UsuarioID NUMBER CONSTRAINT PK_Usuario PRIMARY KEY,
  UsuarioLogin VARCHAR(45),
  UsuarioPassword VARCHAR(45)
);

CREATE TABLE Veiculo (
  VeiculoID NUMBER CONSTRAINT PK_Veiculo PRIMARY KEY,
  VeiculoMarca VARCHAR(45),
  VeiculoModelo NUMBER(4),
  VeiculoAno NUMBER(4),
  VeiculoPlaca VARCHAR(7),
  MotoristaID NUMBER, CONSTRAINT FK_Motorista FOREIGN KEY(MotoristaID) REFERENCES Motorista(MotoristaID),
  VeiculoTipoID NUMBER, CONSTRAINT FK_VeiculoTipo FOREIGN KEY(VeiculoTipoID) REFERENCES VeiculoTipo(VeiculoTipoID)
);

CREATE TABLE Objeto (
  ObjetoID NUMBER CONSTRAINT PK_Objeto PRIMARY KEY,
  ObjetoCodRastreio VARCHAR(45),
  ObjetoNomeRemetente VARCHAR(45),
  EnderecoRemetente VARCHAR(150),
  ObjetoNomeDestinatario VARCHAR(45),
  ObjetoEnderecoDestinatario VARCHAR(150),
  ObjetoDataDeposito DATE,
  ObjetoPeso NUMBER(*,2),
  ObjetoStatus VARCHAR(1)
  );
    
CREATE TABLE Roteiro (
  RoteiroID NUMBER CONSTRAINT PK_Roteiro_ID PRIMARY KEY,
  RoteiroData DATE,
  RoteiroStatus CHAR(1),
  ObjetoID NUMBER, CONSTRAINT FK_Objeto FOREIGN KEY(ObjetoID) REFERENCES Objeto(ObjetoID),
  VeiculoID NUMBER, CONSTRAINT FK_Veiculo FOREIGN KEY(VeiculoID) REFERENCES Veiculo(VeiculoID)
);

CREATE TABLE RoteiroObjeto (
  RoteiroObjetoID NUMBER CONSTRAINT PK_RoteiroObjeto_ID PRIMARY KEY,
  VeiculoID NUMBER, CONSTRAINT FK_VeiculoData FOREIGN KEY(VeiculoID) REFERENCES Veiculo(VeiculoID),
  ObjetoID NUMBER, CONSTRAINT FK_ObjetoData FOREIGN KEY(ObjetoID) REFERENCES Objeto(ObjetoID)
);

CREATE SEQUENCE MOTORISTA_SEQ start with 1 increment by 1;
CREATE SEQUENCE VEICULOTIPO_SEQ start with 1 increment by 1;
CREATE SEQUENCE USUARIO_SEQ start with 1 increment by 1;
CREATE SEQUENCE VEICULO_SEQ start with 1 increment by 1;
CREATE SEQUENCE OBJETO_SEQ start with 1 increment by 1;
CREATE SEQUENCE ROTEIRO_SEQ start with 1 increment by 1;
CREATE SEQUENCE ROTEIROOBJETO_SEQ start with 1 increment by 1;

COMMIT;