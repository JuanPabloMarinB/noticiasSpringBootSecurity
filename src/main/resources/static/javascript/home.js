const idArrayRutasImg = [
  [
    "images/musica.jpg",
    "images/grecia.jpg",
    "images/astronauta.jpg",
    "images/agricultura.jpg",
  ],
  [
    "images/hamburguesa.jpg",
    "images/pensando.jpg",
    "images/penol.jpg",
    "images/buho.jpg",
  ],
  [
    "images/cine.jpg",
    "images/cultura.jpg",
    "images/deportes.jpg",
    "images/hamburguesa.jpg",
  ],
  [
    "images/cultura.jpg",
    "images/deportes.jpg",
    "images/cine.jpg",
    "images/hamburguesa.jpg",
  ],
  [
    "images/deportes.jpg",
    "images/cine.jpg",
    "images/ciencia.jpg",
    "images/carretera.jpg",
  ],
  [
    "images/universo.jpg",
    "images/hamburguesa.jpg",
    "images/cine.jpg",
    "images/deportes.jpg",
  ],
];

const idArrayImg = [
  "imagesId1",
  "imagesId2",
  "imagesId3",
  "imagesId4",
  "imagesId5",
  "imagesId6",
];

function cambiarImagenes(idArrayImg, idArrayRutasImg) {
  var indiceActualIdImg = 0;
  var indiceActualRutaImg = 0;
  let imgActual = document.getElementById(idArrayImg[indiceActualIdImg]);
  
  imgActual.style.opacity = 0;
  
  setTimeout(function () {
    for (indiceActualRutaImg; indiceActualRutaImg < idArrayRutasImg.length; indiceActualRutaImg++) {
      for (indiceActualIdImg; indiceActualIdImg < idArrayImg.length; indiceActualIdImg++) {
        imgActual[indiceActualIdImg].src = idArrayRutasImg[indiceActualRutaImg];
        imgActual.alt = `${idArrayRutasImg[index]}`;
        imgActual.style.opacity = 1;
      }
    }
  }, 1000);
}

cambiarImagenes(idArrayImg, idArrayRutasImg);

function changeImages(idsImagenes, rutasImagenes) {
  function changeImage(imageElementId, images) {
    var imageElement = document.getElementById(imageElementId);
    var currentIndex = imageElement.dataset.currentIndex || 0;

    imageElement.style.opacity = 0;
    setTimeout(function () {
      imageElement.src = images[currentIndex];
      imageElement.alt = "Imagen " + (currentIndex + 1);
      imageElement.style.opacity = 1;
    }, 1000);

    currentIndex++;
    if (currentIndex === images.length) {
      currentIndex = 0;
    }
    imageElement.dataset.currentIndex = currentIndex;

    setTimeout(function () {
      changeImage(imageElementId, images);
    }, 1000);
  }

  // Verificar que los arrays de IDs e imágenes tengan la misma longitud
  if (idsImagenes.length !== rutasImagenes.length) {
    console.error("Los arrays de IDs e imágenes deben tener la misma longitud");
    return;
  }

  // Recorrer los arrays de IDs e imágenes y llamar a changeImage para cada combinación
  for (var i = 0; i < idsImagenes.length; i++) {
    var imageId = idsImagenes[i];
    var images = rutasImagenes[i];

    changeImage(imageId, images);
  }
}

changeImages(gridImagesId, totalImages);

function numPrimoAleatorio() {
  var numerosPrimos = [11, 13, 17, 19, 23, 29];
  var numeroAleatorio =
    numerosPrimos[Math.floor(Math.random() * numerosPrimos.length)] * 1000;
  return numeroAleatorio;
}

/*
changeImage("imagen1-seccion-der", imagesId1, numPrimoAleatorio());
changeImage("imagen2-seccion-der", imagesId2, numPrimoAleatorio());
changeImage("imagen3-seccion-der", imagesId3, numPrimoAleatorio());
changeImage("imagen4-seccion-der", imagesId4, numPrimoAleatorio());
changeImage("imagen5-seccion-der", imagesId5, numPrimoAleatorio());
changeImage("imagen6-seccion-der", imagesId6, numPrimoAleatorio());
*/

/*var imagesId1 = [
  "images/musica.jpg",
  "images/grecia.jpg",
  "images/astronauta.jpg",
  "images/agricultura.jpg",
];
var imagesId2 = [
  "images/hamburguesa.jpg",
  "images/pensando.jpg",
  "images/penol.jpg",
  "images/buho.jpg",
];
var imagesId3 = [
  "images/cine.jpg",
  "images/cultura.jpg",
  "images/deportes.jpg",
  "images/hamburguesa.jpg",
];
var imagesId4 = [
  "images/cultura.jpg",
  "images/deportes.jpg",
  "images/cine.jpg",
  "images/hamburguesa.jpg",
];
var imagesId5 = [
  "images/deportes.jpg",
  "images/cine.jpg",
  "images/ciencia.jpg",
  "images/carretera.jpg",
];
var imagesId6 = [
  "images/universo.jpg",
  "images/hamburguesa.jpg",
  "images/cine.jpg",
  "images/deportes.jpg",
];
*/

/*
setInterval(function () {
  changeImage("imagen1-seccion-der", imagesId1, 1000);
}, numPrimoAleatorio() + 10000);

setInterval(function () {
  changeImage("imagen6-seccion-der", imagesId1, 1000);
}, numPrimoAleatorio());

setInterval(function () {
  changeImage("imagen2-seccion-der", imagesId1, 1000);
}, numPrimoAleatorio());

setInterval(function () {
  changeImage("imagen3-seccion-der", imagesId1, 1000);
}, numPrimoAleatorio());

setInterval(function () {
  changeImage("imagen4-seccion-der", imagesId1, 1000);
}, numPrimoAleatorio());

setInterval(function () {
  changeImage("imagen5-seccion-der", imagesId1, 1000);
}, numPrimoAleatorio());
*/
