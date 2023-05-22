package mx.com.jdgv.models


class User (
    noCliente:Int,
    nombre:String,
    contraseña:String
){
    private var noCliente:Int = noCliente
    private var nombre:String = nombre
    private var contraseña:String = contraseña



    fun getNoCliente():Int{
        return noCliente
    }

    fun getNombre():String{
        return nombre
    }

    fun setNombre(nombre: String){
        this.nombre = nombre
    }

    fun getContraseña():String{
        return contraseña
    }

    fun setContraseña(contraseña: String){
        this.contraseña = contraseña
    }
}