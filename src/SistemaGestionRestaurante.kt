class SistemaGestionRestaurante(private val mesas: List<Mesa>) {

    /*
    * Asocia un pedido a una mesa, antes comprueba si la mesa está ocupada
    *
    * @Params numeroMesa:Int - Numero de la mesa
    * @Params pedido:Pedido - Pedido de la mesa
    *
    * @Return un String diciendo cuando se agrega correctamente el pedido a la mesa o si no ha encontrado la mesa o esta está ocupada
    */
    fun realizarPedido(numeroMesa: Int, pedido: Pedido): String{
        val mesa = mesas.find { it.numero == numeroMesa }


        if (mesa != null && mesa.estado == estadoMesas.Ocupada){
            mesa.agregarPedidos(pedido)
            return "Pedido agregado correctamente a la mesa $numeroMesa"
        }else{
            return "Mesa no encontrada o no ocupada"
        }
    }

    /*
    * Se entregan los pedidos y cambia el estado del pedido a Servido, si llega algun pedido nuevo cambia el estado de ese pedido en concreto a Servido
    *
    * @Params numeroMesa:Int - Numero de la mesa
    * @Params numeroPedido:Int? - Numero del pedido, si no lo encuentra retorna null
    **/
    fun cerrarPedido(numeroMesa: Int, numeroPedido: Int? = null) {

    }

    /*
    * Si ya todos los pedidos de la mesa estan Servidos, se libera la mesa
    *
    * @Params numeroMesa:Int - Numero de la mesa
    *  */
    fun cerrarMesa(numeroMesa: Int) {

        val mesa = mesas.find { it.numero == numeroMesa }

        //si encuentra la mesa entonces que haga la siguiente instrucción
        if (mesa != null){
            if (estadoPedido.Pendiente == estadoPedido.Servido){
                mesa.liberarMesas()
            }
        }
    }

    /*
    * Busca los platos y retorna una lista con el nombre de los platos pedidos
    *
    * @Return platos:List<String> - Lista de los platos
    * */

    fun buscarPlatos(): List<String>? {
        val platos = mesas.flatMap { it.pedidos }.flatMap { it.platos }.map { it.nombre }
        return platos.ifEmpty { null }
    }

    /*
    * Cuenta el numero de veces que se ha pedido el plato
    * */
    fun contarPlato(nombre: String): Int? {
        val count = mesas.flatMap { it.pedidos }
            .flatMap { it.platos }
            .count { it.nombre == nombre }
        return if (count > 0) count else null
    }

    /*
    * Busca y retorna los platos más pedidos
    * */
    fun buscarPlatoMasPedido(): List<String>? {
        val platoCounts = mesas.flatMap { it.pedidos }
            .flatMap { it.platos }
            .groupingBy { it.nombre }
            .eachCount()

        val maxCount = platoCounts.maxByOrNull { it.value }?.value
        return maxCount?.let { max -> platoCounts.filter { it.value == max }.keys.toList() }
    }
}
