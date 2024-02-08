enum class estadoPedido{
    Pendiente,
    Preparacion,
    Listo,
    Servido
}
class Pedido(

    var estado:estadoPedido = estadoPedido.Pendiente
) {
    val numero:Int
    val platos:MutableList<Plato> = mutableListOf()

    companion object{
        var contPedidos:Int = 0

    }
    //init para que cada vez que se instancie un objeto tenga un numero de pedido distinto
    init {
        numero = ++contPedidos
    }
    /*
    * Agrega un plato al pedido
    */
    fun agregarPlato(plato:Plato){
        platos.add(plato)
    }

    /*
    * Elimina el plato del pedido
    *
    * @Params nombrePlato:String - Nombre del plato a eliminar
    *
    * @return String indicando si ha encontrado el plato y lo ha eliminado o si no existe el plato en el pedido
    */
    fun eliminarPlato(nombreplato:String):String{
        val platoEliminar = platos.find { it.nombre == nombreplato }

        if (platoEliminar != null){
            return "$nombreplato eliminado"
        }else{
            return "El plato $nombreplato no encontrado"
        }
    }

    /*
    * Calcula el precio total del pedido sumando los precios de cada plato
    *
    * @return precioTotal:Int - suma de los platos pedidos
    */
    fun calcularPrecio():Double{
        var precioTotal = 0.0

        for (plato in platos){
            precioTotal += plato.precio
        }
        return precioTotal
    }

    /*
    * Calcula el tiempo que va a tardar el pedido en salir de cocina
    *
    * @Returns tiempoTotal:Int - Tiempo total en minutos de lo que va a tardar en salir el pedido
    */
    fun calcularTiempo():Int{
        var tiempoTotal = 0

        for (plato in platos){
            tiempoTotal += plato.tiempoPreparacion
        }
        return tiempoTotal
    }

    override fun toString(): String {
        return "Pedido $contPedidos, compuesto por $platos (${calcularTiempo()} Min) -> ${calcularPrecio()}€, (Lista de lo que lleva la comida)"
    }

}
