const ejercicio = (cadena1, cadena2) => {
    let map1 = new Map()
    let map2 = new Map()
    for (let i = 0; i < cadena1.length; i++) {
        if (!map1.has(cadena1[i])) {
            map1.set(cadena1[i], i)
        }
    }

    for (let i = 0; i < cadena2.length; i++) {
        if (!map2.has(cadena2[i])) {
            map2.set(cadena2[i], i)
        }
    }

    for (let key of map1.keys()) {
        if (map2.has(key)) {
            map2.delete(key)
            map1.delete(key)
        }
    }

    console.log('Letras de la primera cadena que no tiene las segunda:', Array.from(map1.keys()).join(','))
    console.log('Letras de la segunda cadena que no tiene la primera:', Array.from(map2.keys()).join(','))
}

ejercicio('hola', 'mundo')