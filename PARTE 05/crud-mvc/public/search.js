document.addEventListener("DOMContentLoaded", function () {
  const inputBusqueda = document.getElementById("buscador");
  const filas = document.querySelectorAll("tbody tr");
  const tabla = document.querySelector("table");
  const sinResultados = document.createElement("tr");

  // Agrega clases de estilo al td de mensaje vacio
  sinResultados.innerHTML = `
    <td colspan="100%" class="td-vacio">
      No se encontraron resultados.
    </td>
  `;
  sinResultados.style.display = "none";
  tabla.querySelector("tbody").appendChild(sinResultados);

  inputBusqueda.addEventListener("input", function () {
    const valor = this.value.toLowerCase();
    let hayCoincidencias = false;

    filas.forEach((fila) => {
      const textoFila = fila.innerText.toLowerCase();
      if (textoFila.includes(valor)) {
        fila.style.display = "";
        hayCoincidencias = true;
      } else {
        fila.style.display = "none";
      }
    });

    sinResultados.style.display = hayCoincidencias ? "none" : "";
  });

  inputBusqueda.addEventListener("keydown", function (e) {
    if (e.key === "Escape") {
      this.value = "";
      this.dispatchEvent(new Event("input"));
    }
  });

  inputBusqueda.focus();
});
