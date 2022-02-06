<?php
if (isset($_POST["artista"])) {

    $artista = $_POST["artista"];
    $imagen = $_POST["imagen"];
    $biografia = $_POST["biografia"];
    $discografia = $_POST["discografia"];
    $servidor = "localhost";
    $usuario = "root";
    $password = "";
    $dbname = "audiodb";

    $conexion = mysqli_connect($servidor, $usuario, $password, $dbname);
    if (!$conexion) {
        echo "Error en la conexiona MySQL: " . mysqli_connect_error();
        exit();
    }
    $sql = "INSERT INTO infogrupo (artista,imagen,biografia,discografia) VALUES ('" . addslashes($artista) . "','" . addslashes($imagen) . "', '" . addslashes($biografia) . "', '" . addslashes($discografia) . "')";
    if (mysqli_query($conexion, $sql)) {
        echo "Registro insertado correctamente.";
    } else {
        echo "Error del php " . mysqli_error($conexion);
    }
}
