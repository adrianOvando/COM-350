<?php
include 'conect.php';

$id=1;
$citas = [];

if(!empty($_GET)){
$sql="select *from citas where medico_id = '$id'";
$P_nombre=$_GET['Nombre'] ?? '';
$P_apellido=$_GET['Apellido'] ?? '';
$Fecha=$_GET['Fecha'] ?? '';


$res=$con->query($sql);

$q = "SELECT c.id, c.fecha_cita, c.hora_cita, 
             p.nombre AS paciente_nombre, p.apellido AS paciente_apellido,
             m.nombre AS medico_nombre, m.apellido AS medico_apellido
      FROM citas c
      JOIN pacientes p ON c.paciente_id = p.id
      JOIN medicos m ON c.medico_id = m.id
      WHERE c.medico_id = '$id' 
        AND c.estado = 'Programada'";

if (!empty($P_nombre)) {
    $q .= " AND p.nombre = '$P_nombre'";
}
if (!empty($P_apellido)) {
    $q .= " AND p.apellido = '$P_apellido'";
}
if (!empty($Fecha)) {
    $q .= " AND c.fecha_cita = '$Fecha'";
}

$q .= " ORDER BY c.fecha_cita, c.hora_cita";

$r = $con->query($q);
$citas = $r->fetch_all(MYSQLI_ASSOC);
}

?>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Mis Citas Programadas</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
<h1>Filtros</h1>
    <form method="Get">
        <label for="P_nombre">Nombre</label>
        <input type="text" name="P_Nombre">
        <Label for="p_apellido">Apellido</Label>
        <input type="text" name="P_Apellido">
        <label for="Fecha" >Fecha</label>
        <input type="date" name="Fecha">
        <button type="submit">Buscar</button><br>
        <button type="submit">Lista</button>
    </form>
    <h1>Mis Citas Programadas</h1>
        <?php if(!empty($citas)) {?>
        <table>
            <thead>
                <tr>
                    <th>Fecha</th>
                    <th>Hora</th>
                    <th>Paciente</th>
                    <th>Médico</th>
                </tr>
            </thead>
            <tbody>
                <?php foreach ($citas as $cita) : ?>
                    <tr>
                        <td><?php echo htmlspecialchars($cita['fecha_cita']); ?></td>
                        <td><?php echo htmlspecialchars($cita['hora_cita']); ?></td>
                        <td><?php echo htmlspecialchars($cita['paciente_nombre'] . ' ' . $cita['paciente_apellido']); ?></td>
                        <td><?php echo htmlspecialchars($cita['medico_nombre'] . ' ' . $cita['medico_apellido']); ?></td>
                    </tr>
                <?php endforeach; ?>
            </tbody>
        </table>
        <?php }?>
</body>
</html>
