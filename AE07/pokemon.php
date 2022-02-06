<?php
if (isset($_POST["nombre"])) {

    $nombre = $_POST["nombre"];
    $posicion = $_POST["posicion"];
    $habilidad = $_POST["habilidad"];
    $tipo = $_POST["tipo"];
    $experiencia = $_POST["experiencia"];
    $altura = $_POST["altura"];
    $peso = $_POST["peso"];
    $figura = $_POST["figura"];
    $frontal = $_POST["frontal"];
    $trasera = $_POST["trasera"];
    $brillante = $_POST["brillante"];
    $servidor = "localhost";
    $usuario = "root";
    $password = "";
    $dbname = "pokemon";

    $conexion = mysqli_connect($servidor, $usuario, $password, $dbname);
    if (!$conexion) {
        echo "Error en la conexiona MySQL: " . mysqli_connect_error();
        exit();
    }
    $sql = "INSERT INTO infopokemon (nombre,posicion,habilidad,tipo,experiencia,altura,peso,figura,frontal,trasera,brillante) 
    VALUES ('" . addslashes($nombre) . "','" 
               . addslashes($posicion) . "', '" 
               . addslashes($habilidad) . "', '" 
               . addslashes($tipo) . "', '" 
               . addslashes($experiencia) . "', '" 
               . addslashes($altura) . "', '" 
               . addslashes($peso) . "', '" 
               . addslashes($figura) . "', '" 
               . addslashes($frontal) . "', '" 
               . addslashes($trasera) . "', '" 
               . addslashes($brillante) . "')";
    if (mysqli_query($conexion, $sql)) {
        echo "Registro insertado correctamente.";
    } else {
        echo "Error del php " . mysqli_error($conexion);
    }
}
