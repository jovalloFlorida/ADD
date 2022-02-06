-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 06-02-2022 a las 17:50:48
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
-- Base de datos: `pokemon`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `infopokemon`
--

CREATE TABLE `infopokemon` (
  `id` int(4) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `posicion` varchar(50) NOT NULL,
  `habilidad` varchar(100) NOT NULL,
  `tipo` varchar(100) NOT NULL,
  `experiencia` varchar(100) NOT NULL,
  `altura` varchar(25) NOT NULL,
  `peso` varchar(25) NOT NULL,
  `figura` varchar(500) NOT NULL,
  `frontal` varchar(500) NOT NULL,
  `trasera` varchar(500) NOT NULL,
  `brillante` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `infopokemon`
--

INSERT INTO `infopokemon` (`id`, `nombre`, `posicion`, `habilidad`, `tipo`, `experiencia`, `altura`, `peso`, `figura`, `frontal`, `trasera`, `brillante`) VALUES
(1, 'pikachu', '25', 'mega-punch', 'electric', '112', '4', '60', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/home/25.png', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/25.png', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/25.png', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/shiny/25.png'),
(2, 'bulbasaur', '1', 'razor-wind', 'grass', '64', '7', '69', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/home/1.png', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/1.png', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/shiny/1.png'),
(4, 'pikachu', '25', 'mega-punch', 'electric', '112', '4', '60', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/home/25.png', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/25.png', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/25.png', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/shiny/25.png'),
(5, 'ekans', '23', 'bind', 'poison', '58', '20', '69', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/home/23.png', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/23.png', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/23.png', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/shiny/23.png'),
(6, 'jynx', '124', 'pound', 'ice', '159', '14', '406', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/home/124.png', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/124.png', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/124.png', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/shiny/124.png'),
(7, 'bellsprout', '69', 'swords-dance', 'grass', '60', '7', '40', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/home/69.png', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/69.png', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/69.png', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/shiny/69.png'),
(8, 'hippowdon', '450', 'sand-attack', 'ground', '184', '20', '3000', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/home/450.png', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/450.png', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/450.png', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/shiny/450.png'),
(9, 'bergmite', '712', 'tackle', 'ice', '61', '10', '995', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/home/712.png', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/712.png', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/712.png', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/shiny/712.png'),
(10, 'corsola', '222', 'headbutt', 'water', '144', '6', '50', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/home/222.png', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/222.png', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/222.png', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/shiny/222.png');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `infopokemon`
--
ALTER TABLE `infopokemon`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `infopokemon`
--
ALTER TABLE `infopokemon`
  MODIFY `id` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
