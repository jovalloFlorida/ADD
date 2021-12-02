-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 08-11-2021 a las 10:04:41
-- Versión del servidor: 10.4.17-MariaDB
-- Versión de PHP: 8.0.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bibliotecaadd`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `bibliotecaadd`
--

CREATE TABLE `bibliotecaadd` (
  `id` int(3) NOT NULL,
  `titulo` varchar(30) NOT NULL,
  `autor` varchar(30) NOT NULL,
  `nacimiento` varchar(4) NOT NULL,
  `publicacion` varchar(4) NOT NULL,
  `editorial` varchar(30) NOT NULL,
  `numpaginas` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `bibliotecaadd`
--

INSERT INTO `bibliotecaadd` (`id`, `titulo`, `autor`, `nacimiento`, `publicacion`, `editorial`, `numpaginas`) VALUES
(57, 'El señor de los anillos', 'J.R.R. Tolkien', '1890', '1950', 'Minotauro', '1392'),
(58, 'El juego de Ender', 'Orson Scott Card', '1951', '1977', 'Ediciones B', '509'),
(59, 'Lazarillo de Tormes', 'Anónimo', 'N.C', '1554', 'Clásicos Populares', '150'),
(60, 'Las uvas de la ira', 'John Steinbeck', '1902', '1939', 'Alianza', '619'),
(61, 'Watchmen', 'Alan Moore', '1953', '1980', 'ECC', '416'),
(62, 'La hoguera de las vanidades', 'Tom Wolfe', '1930', '1980', 'Anagrama', '636'),
(63, 'La familia de Pascual Duarte', 'Camilo José Cela', '1916', '1942', 'Destino', '165'),
(64, 'El señor de las moscas', 'William Golding', '1911', '1972', 'Alianza', '236'),
(65, 'La ciudad de los prodigios', 'Eduardo Mendoza', '1943', '1986', 'Seix Barral', '541'),
(66, 'Ensayo sobre la ceguera', 'José Saramago', '1922', '1995', 'Santillana', '439'),
(67, 'Los surcos del azar', 'Paco Roca', '1969', '2013', 'Astiberri', '349'),
(68, 'Ghosts of Spain', 'Giles Tremlett', '1962', '2006', 'Faber & Faber', '468'),
(69, 'Sidi', 'Arturo Pérez Reverte', '1951', '2019', 'Penguin', '369'),
(70, 'Dune', 'Frank Herbert', '1920', '1965', 'Acervo', '741');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `bibliotecaadd`
--
ALTER TABLE `bibliotecaadd`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `bibliotecaadd`
--
ALTER TABLE `bibliotecaadd`
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=71;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
