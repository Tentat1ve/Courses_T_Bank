class PetShop {
    fun identifyAnimal(breed: String, weight: Double, age: Int): Animal? {
        return when (breed.toLowerCase()) {
            "хаски" -> Husky(weight, age)
            "корги" -> Corgi(weight, age)
            "шотландский кот" -> Scottish(weight, age)
            "сиамский кот" -> Siamese(weight, age)
            else -> null
        }
    }
}

interface Animal {
    val weight: Double
    val age: Int
}

interface Cat : Animal {
    val behaviorType: BehaviorType
}

interface Dog : Animal {
    val biteType: BiteType
}

enum class BiteType {
    DIRECT, OVERBITE, UNDERBITE
}

enum class BehaviorType {
    ACTIVE, PASSIVE
}

class Husky(override val weight: Double, override val age: Int) : Dog {
    override val biteType = BiteType.DIRECT
}

class Corgi(override val weight: Double, override val age: Int) : Dog {
    override val biteType = BiteType.UNDERBITE
}

class Siamese(override val weight: Double, override val age: Int) : Cat {
    override val behaviorType = BehaviorType.ACTIVE
}

class Scottish(override val weight: Double, override val age: Int) : Cat {
    override val behaviorType = BehaviorType.PASSIVE
}

fun main() {
    val petShop = PetShop()
    println("Введите породу: ")
    val name = readLine()
    println("Введите возвраст: ")
    var age :Int = readLine()!!.toInt() 
    println("Введите вес: ")
    var weight :Double = readLine()!!.toDouble() 
    if (name != null) {
        val animal = petShop.identifyAnimal(name.trim(), weight, age)
        if (animal != null) {
            println("Создано животное: ${animal::class.simpleName}, вес: ${animal.weight}, возраст: ${animal.age}")
            when (animal) {
                is Dog -> println("Тип прикуса: ${animal.biteType}")
                is Cat -> println("Тип поведения: ${animal.behaviorType}")
            }
        } else {
            println("Неизвестная порода.")
        }
    } else {
        println("Вы не ввели породу.")
    }
}
