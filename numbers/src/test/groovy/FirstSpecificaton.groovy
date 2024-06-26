import spock.lang.Specification

class FirstSpecification extends Specification {
    def "two plus two should equal four"() {
        given:
        int left = 2
        int right = 2
        when:
        int result = left + right
        then:
        result == 4
    }

    def "Should get an index out of bounds when removing a nonexistent item"() {
    given:
    def list = [1, 2, 3, 4]
    when:
    list.remove(20)
    then:
    thrown(IndexOutOfBoundsException)
    list.size() == 4
}
}