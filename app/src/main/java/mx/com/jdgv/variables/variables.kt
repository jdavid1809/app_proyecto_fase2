package mx.com.jdgv.variables

import mx.com.jdgv.models.User


    var USER1 = User(1000,"Javier","Contra1000")
    var USER2 = User(1001,"David","Contra1001")
    var USERS= mutableListOf<User>(USER1, USER2)
    var NoUser = 2000

    //var peliculas = emptyArray<String>()

    var peliculas = mutableListOf<String>(
        "vecino malo",
        "th help",
        "guardianes",
        "pasante de moda"
    )