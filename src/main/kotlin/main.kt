fun greet(name: String): String {
    require(name.isNotEmpty())

    return "hi $name"
}

fun main() {
    print(greet(readLine()!!))
}
