-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 15-06-2025 a las 05:04:57
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `cafeina`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE `clientes` (
  `cedula` varchar(10) NOT NULL COMMENT 'Cédula del cliente',
  `nombre` varchar(15) NOT NULL COMMENT 'Nombre del cliente',
  `apellido` varchar(15) NOT NULL COMMENT 'Apellido del cliente',
  `telefono` varchar(15) NOT NULL COMMENT 'Número Telefónico del cliente',
  `direccion` varchar(100) NOT NULL COMMENT 'Dirección del domocilio del cliente'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `contproducto`
--

CREATE TABLE `contproducto` (
  `nomIngrediente` varchar(20) NOT NULL COMMENT 'Nombre del ingrediente',
  `stockDisponible` float NOT NULL COMMENT 'Cantidad disponible en inventario'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalles`
--

CREATE TABLE `detalles` (
  `codFactura` varchar(15) NOT NULL COMMENT 'Código de la factura',
  `codProducto` varchar(10) NOT NULL COMMENT 'Código del producto',
  `cantidad` varchar(50) NOT NULL COMMENT 'cantidad a llevar',
  `precio` varchar(6) NOT NULL COMMENT 'precio total'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleado`
--

CREATE TABLE `empleado` (
  `emp_codigo` varchar(10) NOT NULL COMMENT 'Código del empleado',
  `emp_cedula` varchar(10) NOT NULL COMMENT 'Cédula del empleado',
  `emp_nombre1` varchar(15) NOT NULL COMMENT 'Nombre del empleado',
  `emp_nombre2` varchar(15) NOT NULL COMMENT '2do Nombre del empleado',
  `emp_apellido1` varchar(15) NOT NULL COMMENT 'Apellido del empleado',
  `emp_apellido2` varchar(15) NOT NULL COMMENT '2do Apellido del empleado',
  `emp_telefono` varchar(15) NOT NULL COMMENT 'Número telefónico del empleado',
  `emp_direccion` varchar(100) NOT NULL COMMENT 'Dirección del domicilio del empleado\r\n'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `factura`
--

CREATE TABLE `factura` (
  `codFactura` varchar(10) NOT NULL COMMENT 'Código de la factura',
  `cl_cedula` varchar(10) NOT NULL COMMENT 'Cédula del cliente',
  `emp_codigo` varchar(10) NOT NULL COMMENT 'Código del empleado',
  `detalles` text NOT NULL COMMENT 'Detalles de la factura',
  `precioTotal` float NOT NULL COMMENT 'Precio final de la factura'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `codProducto` varchar(10) NOT NULL COMMENT 'Código del producto',
  `nomProducto` varchar(20) NOT NULL COMMENT 'Nombre del producto',
  `precioProducto` varchar(5) NOT NULL COMMENT 'Precio del producto',
  `tipoProducto` varchar(10) NOT NULL COMMENT 'Tipo de producto',
  `nomIngrediente` varchar(20) NOT NULL COMMENT 'Nombre del ingrediente'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Índices para tablas volcadas
--

-- 
-- Indices de la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`cedula`);

--
-- Indices de la tabla `contproducto`
--
ALTER TABLE `contproducto`
  ADD PRIMARY KEY (`nomIngrediente`);

--
-- Indices de la tabla `detalles`
--
ALTER TABLE `detalles`
  ADD UNIQUE KEY `codFactura` (`codFactura`),
  ADD KEY `codProducto` (`codProducto`);

--
-- Indices de la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD PRIMARY KEY (`emp_codigo`),
  ADD UNIQUE KEY `emp_cedula` (`emp_cedula`);

--
-- Indices de la tabla `factura`
--
ALTER TABLE `factura`
  ADD PRIMARY KEY (`codFactura`),
  ADD KEY `cl_cedula` (`cl_cedula`),
  ADD KEY `emp_codigo` (`emp_codigo`);

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`codProducto`),
  ADD KEY `codProducto` (`codProducto`),
  ADD KEY `codProducto_2` (`codProducto`),
  ADD KEY `nomIngrediente` (`nomIngrediente`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `detalles`
--
ALTER TABLE `detalles`
  ADD CONSTRAINT `detalles_ibfk_1` FOREIGN KEY (`codFactura`) REFERENCES `factura` (`codFactura`),
  ADD CONSTRAINT `detalles_ibfk_2` FOREIGN KEY (`codProducto`) REFERENCES `productos` (`codProducto`);

--
-- Filtros para la tabla `factura`
--
ALTER TABLE `factura`
  ADD CONSTRAINT `factura_ibfk_1` FOREIGN KEY (`cl_cedula`) REFERENCES `clientes` (`cedula`),
  ADD CONSTRAINT `factura_ibfk_2` FOREIGN KEY (`emp_codigo`) REFERENCES `empleado` (`emp_codigo`);

--
-- Filtros para la tabla `productos`
--
ALTER TABLE `productos`
  ADD CONSTRAINT `productos_ibfk_1` FOREIGN KEY (`nomIngrediente`) REFERENCES `contproducto` (`nomIngrediente`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
