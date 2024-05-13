-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 20-07-2023 a las 09:16:38
-- Versión del servidor: 8.0.31
-- Versión de PHP: 8.0.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `park23`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `administradores`
--

DROP TABLE IF EXISTS `administradores`;
CREATE TABLE IF NOT EXISTS `administradores` (
  `Id_Administrador` int NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(30) NOT NULL,
  `Apellidos` varchar(30) NOT NULL,
  `Usuario` varchar(20) NOT NULL,
  `Contraseña` varchar(8) NOT NULL,
  `TipoUsuario` int NOT NULL,
  PRIMARY KEY (`Id_Administrador`),
  KEY `TipoUsuario` (`TipoUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `administradores`
--

INSERT INTO `administradores` (`Id_Administrador`, `Nombre`, `Apellidos`, `Usuario`, `Contraseña`, `TipoUsuario`) VALUES
(1, 'Andres', 'Catalan', 'Ped@', '467821', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pagos`
--

DROP TABLE IF EXISTS `pagos`;
CREATE TABLE IF NOT EXISTS `pagos` (
  `Id_Pago` int NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(30) NOT NULL,
  `Apellido` varchar(30) NOT NULL,
  `Tarjeta` varchar(15) NOT NULL,
  `Vehiculo` varchar(15) NOT NULL,
  `Monto` decimal(10,0) NOT NULL,
  `Mes` varchar(20) NOT NULL,
  `Mes_Bol` tinyint(1) NOT NULL,
  `NIT` varchar(15) NOT NULL,
  PRIMARY KEY (`Id_Pago`),
  KEY `Tarjeta` (`Tarjeta`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pago_mensualidad`
--

DROP TABLE IF EXISTS `pago_mensualidad`;
CREATE TABLE IF NOT EXISTS `pago_mensualidad` (
  `Id_Pago` int NOT NULL AUTO_INCREMENT,
  `Tarjeta` varchar(15) NOT NULL COMMENT 'ReferenciaAUsuarios',
  `Enero` tinyint(1) DEFAULT '0',
  `Febrero` tinyint(1) DEFAULT '0',
  `Marzo` tinyint(1) DEFAULT '0',
  `Abril` tinyint(1) DEFAULT '0',
  `Mayo` tinyint(1) DEFAULT '0',
  `Junio` tinyint(1) DEFAULT '0',
  `Julio` tinyint(1) DEFAULT '0',
  `Agosto` tinyint(1) DEFAULT '0',
  `Septiembre` tinyint(1) DEFAULT '0',
  `Octubre` tinyint(1) DEFAULT '0',
  `Noviembre` tinyint(1) DEFAULT '0',
  `Diciembre` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`Id_Pago`),
  KEY `Tarjeta` (`Tarjeta`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `secretarios`
--

DROP TABLE IF EXISTS `secretarios`;
CREATE TABLE IF NOT EXISTS `secretarios` (
  `Id_Secretario` int NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(30) NOT NULL,
  `Apellidos` varchar(30) NOT NULL,
  `Usuario` varchar(20) NOT NULL,
  `Contraseña` varchar(8) NOT NULL,
  `TipoUsuario` int NOT NULL COMMENT 'Rol',
  PRIMARY KEY (`Id_Secretario`),
  KEY `TipoUsuario` (`TipoUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `secretarios`
--

INSERT INTO `secretarios` (`Id_Secretario`, `Nombre`, `Apellidos`, `Usuario`, `Contraseña`, `TipoUsuario`) VALUES
(1, 'Andres', 'Catalan', 'Alesso', '457813', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `solicitudes`
--

DROP TABLE IF EXISTS `solicitudes`;
CREATE TABLE IF NOT EXISTS `solicitudes` (
  `Id_Solicitud` int NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(100) NOT NULL,
  `Apellido` varchar(100) NOT NULL,
  `Usuario` varchar(50) NOT NULL,
  `Contraseña` varchar(100) NOT NULL,
  `Vehiculo` varchar(100) NOT NULL,
  `Placa` varchar(20) NOT NULL,
  `Licencia` varchar(20) NOT NULL,
  `Correo` varchar(100) NOT NULL,
  `TipoUsuario` int NOT NULL,
  PRIMARY KEY (`Id_Solicitud`),
  KEY `TipoUsuario` (`TipoUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipousuario`
--

DROP TABLE IF EXISTS `tipousuario`;
CREATE TABLE IF NOT EXISTS `tipousuario` (
  `Id_Usuario` int NOT NULL,
  `TipoUsuario` varchar(20) NOT NULL,
  PRIMARY KEY (`Id_Usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `tipousuario`
--

INSERT INTO `tipousuario` (`Id_Usuario`, `TipoUsuario`) VALUES
(1, 'Administrador'),
(2, 'Secretario'),
(3, 'Usuario');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
CREATE TABLE IF NOT EXISTS `usuarios` (
  `Id_Usuario` int NOT NULL,
  `Nombres` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `Apellidos` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `Usuario` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `Contraseña` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `Tarjeta` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `Vehiculo` varchar(20) NOT NULL,
  `Placa` varchar(15) NOT NULL,
  `Licencia` varchar(20) NOT NULL,
  `Correo` varchar(30) NOT NULL,
  `TipoUsuario` int NOT NULL COMMENT 'Rol',
  PRIMARY KEY (`Tarjeta`),
  KEY `TipoUsuario` (`TipoUsuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`Id_Usuario`, `Nombres`, `Apellidos`, `Usuario`, `Contraseña`, `Tarjeta`, `Vehiculo`, `Placa`, `Licencia`, `Correo`, `TipoUsuario`) VALUES
(8, 'Sofia', 'Perez', 'sofia012', 'asdfqwer', '098765432109876', 'moto', 'PQR789', '0987654321', 'sofia@example.com', 2),
(1, 'Juan', 'Perez', 'juan123', '12345678', '123456789012345', 'carro', 'ABC123', '1234567890', 'juan@example.com', 1),
(2, 'Maria', 'Gomez', 'maria456', 'abcdefgh', '234567890123456', 'moto', 'XYZ987', '0987654321', 'maria@example.com', 2),
(3, 'Pedro', 'Ramirez', 'pedro789', 'qwertyui', '345678901234567', 'carro', 'XYZ789', '0987654321', 'pedro@example.com', 1),
(4, 'Laura', 'Lopez', 'laura012', 'asdfghjk', '456789012345678', 'moto', 'LMN456', '1234567890', 'laura@example.com', 2),
(5, 'Carlos', 'Gonzalez', 'carlos345', 'zxcvbnm', '567890123456789', 'carro', 'DEF789', '0987654321', 'carlos@example.com', 1),
(6, 'Diana', 'Martinez', 'diana567', 'uiopasdf', '654321098765432', 'moto', 'JKL123', '0987654321', 'diana@example.com', 2),
(7, 'Alejandro', 'Herrera', 'alejandro7', 'hjklzxcv', '987654321098765', 'carro', 'MNO789', '1234567890', 'alejandro@example.com', 1);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `administradores`
--
ALTER TABLE `administradores`
  ADD CONSTRAINT `administradores_ibfk_1` FOREIGN KEY (`TipoUsuario`) REFERENCES `tipousuario` (`Id_Usuario`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `pago_mensualidad`
--
ALTER TABLE `pago_mensualidad`
  ADD CONSTRAINT `pago_mensualidad_ibfk_1` FOREIGN KEY (`Tarjeta`) REFERENCES `usuarios` (`Tarjeta`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `secretarios`
--
ALTER TABLE `secretarios`
  ADD CONSTRAINT `secretarios_ibfk_1` FOREIGN KEY (`TipoUsuario`) REFERENCES `tipousuario` (`Id_Usuario`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `solicitudes`
--
ALTER TABLE `solicitudes`
  ADD CONSTRAINT `solicitudes_ibfk_1` FOREIGN KEY (`TipoUsuario`) REFERENCES `tipousuario` (`Id_Usuario`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD CONSTRAINT `usuarios_ibfk_1` FOREIGN KEY (`TipoUsuario`) REFERENCES `tipousuario` (`Id_Usuario`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
