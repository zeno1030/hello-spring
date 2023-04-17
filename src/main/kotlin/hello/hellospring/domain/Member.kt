package hello.hellospring.domain

class Member {
    var id:Long ?=null
    var name: String ?=null

    @JvmName("")
    fun getId(): Long? {
        return id
    }

    fun settId(id:Long){
        this.id = id
    }

    fun getName(): String? {
        return name
    }

    fun setName(name: String?){
        this.name = name
    }
}


