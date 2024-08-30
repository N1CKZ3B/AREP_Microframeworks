function salute() {
    const name = document.getElementById('name-input').value;
    fetch(`/App/hello?name=${encodeURIComponent(name)}`)
        .then(response => response.text())
        .then(data => {
            document.getElementById('hello-result').textContent = data;
        })
        .catch(error => {
            console.error('Error:', error);
            document.getElementById('hello-result').textContent = 'No se pudo ejecutar el saludo';
        });
}

function obtainPi() {
    fetch('/App/pi')
        .then(response => response.text())
        .then(data => {
            document.getElementById('pi-result').textContent = `pi tiene un valor aproximado de: ${data}`;
        })
        .catch(error => {
            console.error('Error:', error);
            document.getElementById('pi-result').textContent = 'No se pudo obtener el valor de pi';
        });
}

function redirectToWebsite() {
    window.location.href = "https://campusvirtual.escuelaing.edu.co/moodle/mod/assign/view.php?id=211410";
}

function getDateTime(){
    fetch('/App/datetime')
        .then(response => response.text())
        .then(data => {
            document.getElementById('date-result').textContent = `La fecha de hoy es: ${data}`;
        })
        .catch(error => {
            console.error('Error:', error);
            document.getElementById('date-result').textContent = 'No se pudo obtener la fecha de hoy :C';
        });
}

function calculateSum() {
    // Obtiene los valores ingresados por el usuario
    const num1 = document.getElementById('num1').value;
    const num2 = document.getElementById('num2').value;

    // Envía una solicitud GET al servicio /App/sum con los números como parámetros
    fetch(`/App/sum?num1=${encodeURIComponent(num1)}&num2=${encodeURIComponent(num2)}`)
        .then(response => response.text()) // Obtiene la respuesta en texto
        .then(text => {
            // Muestra el resultado en el elemento con id 'sum-result'
            document.getElementById('sum-result').innerText = text;
        })
        .catch(error => {
            // Maneja errores en caso de que algo salga mal
            console.error('Error:', error);
            document.getElementById('sum-result').innerText = 'Hubo un error al calcular la suma.';
        });
}
