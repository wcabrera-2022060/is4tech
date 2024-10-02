const ejercicio = (texto) => {
  let letras = 0
  let palabras = 0
  let oraciones = 0
  let letrasPalabra = 0
  let letrasPalabraMasLarga = 0
  let enPalabra = false
  for (let i = 0; i < texto.length; i++) {
    if (texto[i] === ' ') {
      if (enPalabra) {
        palabras++
        enPalabra = false
        if (letrasPalabra > letrasPalabraMasLarga) {
          letrasPalabraMasLarga = letrasPalabra
        }
        letrasPalabra = 0
      }
    } else if (texto[i] === '.') {
      oraciones++
      if (enPalabra) {
        palabras++
        enPalabra = false
        if (letrasPalabra > letrasPalabraMasLarga) {
          letrasPalabraMasLarga = letrasPalabra
        }
        letrasPalabra = 0
      }
    } else {
      letras++
      letrasPalabra++
      enPalabra = true
    }
  }
  if (enPalabra) {
    palabras++
  }
  console.log('Letras: ', letras)
  console.log('Palabras: ', palabras)
  console.log('Oraciones: ', oraciones)
  console.log('Letras promedio por palabra: ', letras / palabras)
  console.log('Letras de la palabra más larga: ', letrasPalabraMasLarga)
}

ejercicio('Hola mundo. Esto es una prueba.')