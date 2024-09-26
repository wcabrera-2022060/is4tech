const ejercicio = (cadena) => {
  const map = new Map()

  for (let i = 0; i < cadena.length; i++) {
    map.set(cadena[i], i)
  }

  if(map.get("{") == undefined && map.get("}") != undefined || map.get("{") != undefined && map.get("}") == undefined){
    return false
  }

  if(map.get("[") == undefined && map.get("]") != undefined || map.get("[") != undefined && map.get("]") == undefined){
    return false
  }

  if(map.get("(") == undefined && map.get(")") != undefined || map.get("(") != undefined && map.get(")") == undefined){
    return false
  }

  if (map.get("{") < map.get("[") < map.get("(") && map.get(")") < map.get("]") < map.get("}")) {
    return true
  } else {
    return false
  }
}

console.log(ejercicio("{[a*(c+d)]-5}")) // true
console.log(ejercicio("{[a*(c+d]-5}")) // false
console.log(ejercicio("{[()]}")) // true
console.log(ejercicio("{[)]}")) // false