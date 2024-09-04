const esPalindromo = (palabra) => {

  const palabraFormateada = palabra.replaceAll(' ', '').toLowerCase()

  for (let i = 0; i < palabraFormateada.length; i++) {

    if (palabraFormateada[i] !== palabraFormateada[palabraFormateada.length - 1 - i]) {
      return console.log('No es palindromo')
    }

  }

  return console.log('Es palindromo')
}

esPalindromo('reconocer')
esPalindromo('ReConOcEr')
esPalindromo('re con oc er')
esPalindromo('Hola mundo')