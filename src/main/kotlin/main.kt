
fun main() {

    val databaseDAO = DatabaseDAO()

    var everyone = databaseDAO.getAllPeople()
    println("This is everyone...")
    everyone.forEach {
        println(it)
    }

    var myFriends = databaseDAO.getOnlyFriends(5)
    println("These are my friends...")
    myFriends?.forEach {
        println(it)
    }

    var peopleWithLetter = databaseDAO.getByName("a")
    println("These names contain the letter 'a'...")
    peopleWithLetter?.forEach {
        println(it)
    }

}

class DatabaseDAO {

    var people : ArrayList<Person> =   ArrayList<Person>()

    init {
        people.add(Person(0, "Shad", 48, 8))
        people.add(Person(6, "Mick", 23, 4))
        people.add(Person(1, "Connie", 31, 9))
        people.add(Person(12, "Hank", 8, 3))
        people.add(Person(42, "Norman", 76, 6))
        people.add(Person(99, "Donna", 28, 1))
    }

    fun getAllPeople():List<Person> {

        return people
    }

    fun getById(id:Int) : Person? {

        val found = people.findLast { x -> x.id == id }
        return found
    }

    fun removePerson(personToRemove:Person) : Boolean {
        val result =  people.remove(personToRemove)
        return  result
    }

    fun getByName(searchTerm: String) : List<Person>? {
        val foundItems = people.filter { x -> x.name.contains(searchTerm) }
        return foundItems
    }

    fun getOnlyFriends(minLikeScore: Int) : List<Person>? {
        val foundItems = people.filter { x -> x.likable >= minLikeScore }
        return foundItems
    }
}

data class Person(val id: Int, val name: String, val age: Int, val likable: Int)



