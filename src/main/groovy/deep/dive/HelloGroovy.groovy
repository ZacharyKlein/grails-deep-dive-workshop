package deep.dive

class HelloGroovy {

    String name


    void playWithCollections() {

        def list = ["Grails", "Gradle", "Groovy", "Spock"]

        list.collect {
            it.toUpperCase()
        }.findAll { it.size() > 5 }
                .each { println it }

    }


    void loadProps(Map props) {

        String value = props?.value
        if (value) {
            println "The value is ${value}"
        } else {
            props.value = "ABC"
            println "The value is ${value}"
        }


    }


    String printName() {
        "Hello from ${name}"
    }
}
