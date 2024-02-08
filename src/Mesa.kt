
enum class estadoMesas {
    Ocupada,
    Libre,
    Reservada
}


class Mesa(
    var numero:Int, //Numero de mesa
    val capacidad:Int, //Numero de comensales de 1-6

) {

    var estado = estadoMesas.Libre //estado de la mesa "ocupada", "libre", "reservada", libre por defecto
    var pedidos:MutableList<Pedido> = mutableListOf()//Lista de pedidos de la mesa vacia por defecto

    init {
        require(capacidad in 1..6){"ERROR, no se pueden ese numero de personas"}
    }


    /*
    * Si la mesa esta libre, se ocupa
    */
    fun ocuparMesa(){

        if (estado == estadoMesas.Libre ){
            estado = estadoMesas.Ocupada
        }

    }

    /*
    * Si la mesa esta reservada, se ocupa*/
    fun ocuparReserva(){
        if (estado == estadoMesas.Reservada ){
            estado = estadoMesas.Ocupada
        }

    }

    /*
    * Se libera la mesa
    */
    fun liberarMesas(){
        estado = estadoMesas.Libre

    }

    /*
    * Añade un pedido a los pedidios ya hechos, o se añade nuevo
    */
    fun agregarPedidos(pedido:Pedido){
        pedidos.add(pedido)
    }
}
