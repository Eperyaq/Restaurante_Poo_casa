class Plato( nombre:String,
             var precio:Double,
             var tiempoPreparacion:Int,
             val ingredientes:MutableList<String>) {

    var nombre:String = nombre
        set(value) {
            require(nombre.isNotBlank()){"el nombre no puede ser vacio"}
            field = value
        }

    init {
        this.nombre = nombre

        require(!nombre.isNullOrBlank()){"Nombre no puede ser blanco ni vacio"}
        require(precio > 0){"El precio no puede ser menor que 0"}
        require(!ingredientes.isNullOrEmpty())

    }


    fun agregarIngrediente(ingrediente:String){
        try {
            if (ingrediente.isNullOrBlank()){
                throw IllegalArgumentException("El ingrediente no puede ser vacio ni blaco")
            }else{
                ingredientes.add(ingrediente)
            }
        }catch (e: IllegalArgumentException){
            e.message
        }
    }

    override fun toString(): String {
        return "$nombre ($tiempoPreparacion) -> $precio, ${ingredientes.joinToString { "," }}"
    }
}
