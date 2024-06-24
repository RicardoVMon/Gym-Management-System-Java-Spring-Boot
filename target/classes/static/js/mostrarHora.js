function mostrarHora() {
    var fecha = new Date();
    var diaSemana = ['Domingo', 'Lunes', 'Martes', 'Miércoles', 'Jueves', 'Viernes', 'Sábado'][fecha.getDay()];
    var dia = ('0' + fecha.getDate()).slice(-2);
    var mes = ('0' + (fecha.getMonth() + 1)).slice(-2);
    var año = fecha.getFullYear();
    var horas = ('0' + ((fecha.getHours() % 12) || 12)).slice(-2);
    var minutos = ('0' + fecha.getMinutes()).slice(-2);
    var segundos = ('0' + fecha.getSeconds()).slice(-2);
    var sufijo = fecha.getHours() >= 12 ? 'PM' : 'AM';

    var fechaHoraActual = diaSemana + ', ' + horas + ':' + minutos + ':' + segundos + ' ' + sufijo;

    document.getElementById('hora-actual').innerText = fechaHoraActual;

    setTimeout(mostrarHora, 1000);
}

window.onload = function () {
    mostrarHora();
};