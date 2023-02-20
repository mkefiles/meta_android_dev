/*
* LESSON:
* -> Handle nullability with the 'elvis operator' and the 'assertion operator'
* 
* SCENARIO:
* -> You are assisting an IT department of a high school and there is a list of students.
* -> The list must be searchable by ID OR by name.
* -> IF the ID exists, then return student otherwise you must return a 'null pointer exception'
* -> IF the name exists, then return student otherwise return 'The student is not found'
*
* NOTES:
* -> I decided to slightly improve the logic to let the user choose between searching ID or name
*/

// a data class strictly to create new data-objects
data class Student(var id: Int, var fullName: String, var grade: Double)

// pre-defined data-set used for example
var student = listOf<Student>(
    Student(223, "John", 140.0),
    Student(548, "Mark", 120.0),
    Student(342, "Natali", 150.0),
    Student(781, "Sara", 130.0)
)

// function intentionally does not expect any null values
fun getStudentById(id: Int) : Student {

    // search list of students
    // allow for null value return using 'null assertion operator'
    return student.find { it.id == id }!!
}

// function set to expect null values
fun searchInStudents(name: String) : Student? {

    // search list of students
    // use 'lowercase()' to standardize data due to Kotlin being case-sensitive
    return student.find {it.fullName.lowercase() == name.lowercase()}
}

fun main() {
    print("Search by student ID or by student name ('id' or 'name'): ")
    var userChoice: String = readln()
    when(userChoice) {
        "id" -> {
            print("Enter the student's ID: ")
            println(getStudentById(readln().toInt()))
        }
        "name" -> {
            // use of 'elvis' (ternary) operator for when 'null' is returned
            print("Enter the student's name: ")
            println(searchInStudents(readln())?:"The student is not found!")
        }
        else -> {
            println("Incorrect response!")
        }
    }
}