import com.spock.demo.dto.A
import spock.lang.Specification

class Sample extends Specification {

    def "List对象相关"() {

        given:
        //new对象
        def list = ["aaaa", "bbbbbb"]
        //添加对象
        list += "aaaaa"
        println list
        list -= "aaaaa"
        println list
        def map = ["aaa": "bbb", "asdad": "sdad"]
        map += ["aac": "bbb"]
        println map
        map -= ["aac": "bbb"]
        println map
    }

    def "初始化对象"() {

        given:
        def a = new A(aaa: "aaaaasdsdsdds")
        def a1 = new A(bbb: "ewrwerwe",aaa: "rerttrt")
        def a2 = new A(ccc: "tyrtyrtyrt")
        def a3 = new A(ddd: "kjhjkjhkhj")

        def aaa = a2.aaa

        a2.doAction()>>"result"
    }


    def "where"(){


        expect:
        a*b==c
        where:

        [a,b,c]<<[[1,2,2],[2,3,6],[4,5,20]]
    }


}
