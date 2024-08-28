function sayHello() {
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

function getPi() {
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